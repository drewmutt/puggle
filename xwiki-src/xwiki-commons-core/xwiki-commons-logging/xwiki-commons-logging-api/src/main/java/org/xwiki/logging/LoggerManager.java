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
package org.xwiki.logging;

import java.util.Collection;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Role;
import org.xwiki.observation.EventListener;

/**
 * Provide some logging management APIs such as the ability to redirect logs to an {@link EventListener}.
 *
 * @version $Id: 3dc731b3efedcf034f2699bad7250817fd6ca4d7 $
 * @since 3.2M3
 */
@Role
public interface LoggerManager
{
    /**
     * Grab subsequent logs produced by the current thread and send them to the provided listener.
     * <p>
     * Note that the logs generated by the current thread will not be output anymore by the logging system implementing
     * the SLF4J API (Technically, this is done, for example when the implementation is LogBack, by dynamically
     * replacing the LogBack appender with our own).
     * </p>
     * <p>
     * After this method is called, logs will be only be received as XWiki events sent to the provided listener. In
     * addition, it also overrides any previous call to {@link #pushLogListener(EventListener)} (which will get active
     * again after a call to {@link #popLogListener()}).
     * </p>
     *
     * @param listener the listener that will receive all future logging events
     */
    void pushLogListener(EventListener listener);

    /**
     * Remove the current listener from the current thread stack.
     * <p>
     * If several listeners have been pushed it makes the previous one active again.
     *
     * @return the previous log events listener for the current thread
     */
    EventListener popLogListener();

    /**
     * Associate the passed logger to the passed log level.
     *
     * @param loggerName the logger
     * @param level the level of the logger
     */
    void setLoggerLevel(String loggerName, LogLevel level);

    /**
     * @param loggerName the logger
     * @return the log level associated to the logger, return null if the level is inherited from parent logger
     */
    LogLevel getLoggerLevel(String loggerName);

    /**
     * @return all the registered loggers
     */
    Collection<Logger> getLoggers();
}
