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
package org.xwiki.logging.event;

import org.slf4j.Marker;
import org.xwiki.logging.LogLevel;
import org.xwiki.observation.event.BeginEvent;

/**
 * The beginning of a group of logs.
 *
 * @version $Id: e8d06083b52d02ea8f7fd359f6ae44706048bac1 $
 * @since 5.4RC1
 */
public class BeginLogEvent extends LogEvent implements BeginEvent
{
    /**
     * Serialization identifier.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Matches any {@link LogEvent}.
     */
    protected BeginLogEvent()
    {

    }

    /**
     * @param logEvent the log event to copy
     */
    public BeginLogEvent(LogEvent logEvent)
    {
        super(logEvent);
    }

    /**
     * @param marker the log marker
     * @param level the log level
     * @param message the log message
     * @param argumentArray the event arguments to insert in the message
     * @param throwable the throwable associated to the event
     */
    public BeginLogEvent(Marker marker, LogLevel level, String message, Object[] argumentArray, Throwable throwable)
    {
        super(marker, level, message, argumentArray, throwable);
    }

    /**
     * @param marker the log marker
     * @param level the log level
     * @param message the log message
     * @param argumentArray the event arguments to insert in the message
     * @param throwable the throwable associated to the event
     * @param timeStamp the number of milliseconds elapsed from 1/1/1970 until logging event was created.
     * @since 6.4M1
     */
    public BeginLogEvent(Marker marker, LogLevel level, String message, Object[] argumentArray, Throwable throwable,
        long timeStamp)
    {
        super(marker, level, message, argumentArray, throwable, timeStamp);
    }
}
