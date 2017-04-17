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
package org.xwiki.logging.logback.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.component.phase.Initializable;
import org.xwiki.component.phase.InitializationException;
import org.xwiki.logging.LogLevel;
import org.xwiki.logging.LoggerManager;
import org.xwiki.observation.EventListener;
import org.xwiki.observation.ObservationManager;
import org.xwiki.observation.WrappedThreadEventListener;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;

/**
 * Default implementation of {@link LoggerManager}.
 *
 * @version $Id: 660732e57c9e0ff04fb6bbc2879c019ec48cba3e $
 * @since 3.2M3
 */
@Component
@Singleton
public class DefaultLoggerManager implements LoggerManager, Initializable
{
    /**
     * Used to register/unregister {@link org.xwiki.logging.event.LogEvent} listeners.
     */
    @Inject
    private ObservationManager observation;

    /**
     * The logger.
     */
    @Inject
    private Logger logger;

    /**
     * The stack of listeners for the current thread.
     */
    private ThreadLocal<Stack<EventListener>> listeners = new ThreadLocal<Stack<EventListener>>();

    /**
     * Logback utilities.
     */
    private LogbackUtils utils = new LogbackUtils();

    /**
     * Filter forbidden threads for {@link Appender}s.
     */
    private ForbiddenThreadsFilter forbiddenThreads = new ForbiddenThreadsFilter();

    @Override
    public void initialize() throws InitializationException
    {
        // Register appender
        ch.qos.logback.classic.Logger rootLogger = getRootLogger();

        if (rootLogger != null) {
            Iterator<Appender<ILoggingEvent>> iterator = rootLogger.iteratorForAppenders();

            while (iterator.hasNext()) {
                Appender<ILoggingEvent> appender = iterator.next();

                if (!(appender instanceof LogbackEventGenerator)) {
                    appender.addFilter(this.forbiddenThreads);
                }
            }
        } else {
            this.logger.warn("Could not find any Logback root logger."
                + " All logging module advanced features will be disabled.");
        }
    }

    @Override
    public void pushLogListener(EventListener listener)
    {
        Stack<EventListener> listenerStack = this.listeners.get();

        if (listenerStack == null) {
            listenerStack = new Stack<EventListener>();
            this.listeners.set(listenerStack);
        }

        if (!listenerStack.isEmpty()) {
            this.observation.removeListener(listenerStack.peek().getName());
        }

        if (listener != null) {
            this.observation.addListener(new WrappedThreadEventListener(listener));
        }
        if (listenerStack.isEmpty()) {
            grabLog(Thread.currentThread());
        }
        listenerStack.push(listener);
    }

    @Override
    public EventListener popLogListener()
    {
        Stack<EventListener> listenerStack = this.listeners.get();

        EventListener listener;
        if (listenerStack != null && !listenerStack.isEmpty()) {
            listener = listenerStack.pop();
            if (listener != null) {
                this.observation.removeListener(listener.getName());
            }
            if (listenerStack.isEmpty()) {
                ungrabLog(Thread.currentThread());
            } else {
                EventListener topListener = listenerStack.peek();
                if (topListener != null) {
                    this.observation.addListener(new WrappedThreadEventListener(topListener));
                }
            }
        } else {
            listener = null;
        }

        return listener;
    }

    /**
     * Isolate all appender from provided thread except the event generator one.
     *
     * @param thread the thread to remove from the log appender
     */
    private void grabLog(Thread thread)
    {
        this.forbiddenThreads.addThread(thread);
    }

    /**
     * Restore all appender for the current provided thread.
     *
     * @param thread the thread to restore in the log appender
     */
    private void ungrabLog(Thread thread)
    {
        this.forbiddenThreads.removeThread(thread);
    }

    @Override
    public void setLoggerLevel(String loggerName, LogLevel logLevel)
    {
        LoggerContext loggerContext = this.utils.getLoggerContext();

        if (loggerContext != null) {
            ch.qos.logback.classic.Logger askedLogger = loggerContext.getLogger(loggerName);
            askedLogger.setLevel(this.utils.toLevel(logLevel));
        }
    }

    @Override
    public LogLevel getLoggerLevel(String loggerName)
    {
        LoggerContext loggerContext = getLoggerContext();

        if (loggerContext != null) {
            ch.qos.logback.classic.Logger askedLogger = loggerContext.exists(loggerName);

            if (askedLogger != null) {
                return this.utils.toLogLevel(askedLogger.getLevel());
            }
        }

        return null;
    }

    @Override
    public Collection<Logger> getLoggers()
    {
        return (Collection) this.utils.getLoggerContext().getLoggerList();
    }

    /**
     * @return the Logback root logger or null if Logback is not available
     */
    protected ch.qos.logback.classic.Logger getRootLogger()
    {
        return this.utils.getRootLogger();
    }

    /**
     * @return the Logback Context or null if Logback is not available
     */
    protected LoggerContext getLoggerContext()
    {
        return this.utils.getLoggerContext();
    }
}
