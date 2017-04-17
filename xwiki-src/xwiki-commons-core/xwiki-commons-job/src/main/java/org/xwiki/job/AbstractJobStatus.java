/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.job;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.xwiki.job.event.status.JobProgress;
import org.xwiki.job.event.status.JobStatus;
import org.xwiki.job.event.status.QuestionAnsweredEvent;
import org.xwiki.job.event.status.QuestionAskedEvent;
import org.xwiki.job.internal.DefaultJobProgress;
import org.xwiki.logging.LogLevel;
import org.xwiki.logging.LogQueue;
import org.xwiki.logging.LoggerManager;
import org.xwiki.logging.event.LogEvent;
import org.xwiki.logging.event.LoggerListener;
import org.xwiki.observation.ObservationManager;
import org.xwiki.observation.WrappedThreadEventListener;

/**
 * Base implementation of {@link JobStatus}.
 *
 * @param <R> the request type associated to the job
 * @version $Id: f91eb28981b734404d10f0fce0c54d25ed096146 $
 * @since 7.4M1
 */
public abstract class AbstractJobStatus<R extends Request> implements JobStatus
{
    /**
     * Used register itself to receive logging and progress related events.
     */
    private final transient ObservationManager observationManager;

    /**
     * Used to isolate job related log.
     */
    private final transient LoggerManager loggerManager;

    /**
     * Used to lock #ask().
     */
    private final transient ReentrantLock askLock = new ReentrantLock();

    /**
     * Condition for waiting answer.
     */
    private final transient Condition answered = this.askLock.newCondition();

    /**
     * The status of the parent job, i.e. the status of the job that started this one. This is {@code null} if the job
     * has no parent, i.e. if the job hasn't been started by another job.
     * <p>
     * We don't want to serialize it.
     */
    private final transient JobStatus parentJobStatus;

    /**
     * Take care of progress related events to produce a progression information usually used in a progress bar.
     */
    private final DefaultJobProgress progress = new DefaultJobProgress();

    /**
     * Log sent during job execution.
     */
    private final LogQueue logs;

    /**
     * Used to listen to all the log produced during job execution.
     */
    private transient LoggerListener logListener;

    /**
     * The question.
     */
    private transient volatile Object question;

    /**
     * General state of the job.
     */
    private State state = State.NONE;

    /**
     * @see #getError()
     */
    private Throwable error;

    /**
     * Request provided when starting the job.
     */
    private R request;

    /**
     * @see #getStartDate()
     */
    private Date startDate;

    /**
     * @see #getEndDate()
     */
    private Date endDate;

    /**
     * Indicate if Job log should be grabbed.
     */
    private boolean isolated = true;

    /**
     * @param request the request provided when started the job
     * @param parentJobStatus the status of the parent job (i.e. the status of the job that started this one); pass
     *            {@code null} if this job hasn't been started by another job (i.e. if this is not a sub-job)
     * @param observationManager the observation manager component
     * @param loggerManager the logger manager component
     */
    public AbstractJobStatus(R request, JobStatus parentJobStatus, ObservationManager observationManager,
        LoggerManager loggerManager)
    {
        this.request = request;
        this.parentJobStatus = parentJobStatus;

        this.isolated = parentJobStatus == null;

        this.observationManager = observationManager;
        this.loggerManager = loggerManager;

        this.logs = new LogQueue();
    }

    /**
     * Start listening to events.
     */
    public void startListening()
    {
        // Register progress listener
        this.observationManager.addListener(new WrappedThreadEventListener(this.progress));

        // Isolate log for the job status
        this.logListener = new LoggerListener(LoggerListener.class.getName() + '_' + hashCode(), this.logs);
        if (isIsolated()) {
            this.loggerManager.pushLogListener(this.logListener);
        } else {
            this.observationManager.addListener(new WrappedThreadEventListener(this.logListener));
        }
    }

    /**
     * Stop listening to events.
     */
    public void stopListening()
    {
        if (isIsolated()) {
            this.loggerManager.popLogListener();
        } else {
            this.observationManager.removeListener(this.logListener.getName());
        }
        this.observationManager.removeListener(this.progress.getName());

        // Make sure the progress is closed
        this.progress.getRootStep().finish();
    }

    // JobStatus

    @Override
    public State getState()
    {
        return this.state;
    }

    /**
     * @param state the general state of the job
     */
    public void setState(State state)
    {
        this.state = state;
    }

    @Override
    public Throwable getError()
    {
        return this.error;
    }

    /**
     * @param error the {@link Throwable} on which the job stopped
     * @since 8.1RC1
     */
    public void setError(Throwable error)
    {
        this.error = error;
    }

    @Override
    public R getRequest()
    {
        return this.request;
    }

    @Override
    public LogQueue getLog()
    {
        // Make sure to always return something (it could be null if unserialized as such)
        return this.logs != null ? this.logs : new LogQueue();
    }

    @Override
    public JobProgress getProgress()
    {
        return this.progress;
    }

    @Override
    public void ask(Object question) throws InterruptedException
    {
        ask(question, 0, null);
    }

    @Override
    public boolean ask(Object question, long time, TimeUnit unit) throws InterruptedException
    {
        boolean notTimeout = true;

        this.question = question;

        this.askLock.lockInterruptibly();

        try {
            // Wait for the answer
            this.state = State.WAITING;
            if (isSubJob()) {
                this.parentJobStatus.ask(question);
            } else {
                String questionType = question != null ? question.getClass().getName() : null;
                QuestionAskedEvent event = new QuestionAskedEvent(questionType, this.request.getId());
                this.observationManager.notify(event, this);
                if (event.isAnswered()) {
                    answered();
                } else {
                    if (unit != null) {
                        notTimeout = this.answered.await(time, unit);
                    } else {
                        this.answered.await();
                    }
                }
            }
            this.state = State.RUNNING;
        } finally {
            this.askLock.unlock();
        }

        return notTimeout;
    }

    @Override
    public Object getQuestion()
    {
        return this.question;
    }

    @Override
    public void answered()
    {
        this.askLock.lock();

        try {
            if (isSubJob()) {
                this.question = null;
                this.parentJobStatus.answered();
            } else {
                String questionType = this.question != null ? this.question.getClass().getName() : null;
                this.observationManager.notify(new QuestionAnsweredEvent(questionType, this.request.getId()), this);
                this.question = null;
                this.answered.signal();
            }
        } finally {
            this.askLock.unlock();
        }
    }

    @Override
    public Date getStartDate()
    {
        return this.startDate;
    }

    /**
     * @param startDate the date and time when the job has been started
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate()
    {
        return this.endDate;
    }

    /**
     * @param endDate the date and time when the job finished
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     * @return true if the job is part of another job execution
     */
    public boolean isSubJob()
    {
        return getParentJobStatus() != null;
    }

    /**
     * @return true if the job log should be grabbed
     */
    public boolean isIsolated()
    {
        return this.isolated;
    }

    /**
     * @param isolated true if the job log should be grabbed
     */
    public void setIsolated(boolean isolated)
    {
        this.isolated = isolated;
    }

    /**
     * @return the status of the parent job, i.e. the status of the job that started this one; returns {@code null} if
     *         the job has no parent, i.e. if the job hasn't been started by another job
     */
    public JobStatus getParentJobStatus()
    {
        return this.parentJobStatus;
    }

    // Deprecated

    @Override
    @Deprecated
    public List<LogEvent> getLog(LogLevel level)
    {
        return getLog().getLogs(level);
    }
}
