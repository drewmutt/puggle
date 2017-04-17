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

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xwiki.logging.LogLevel;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

/**
 * Provide several Logback related utility methods.
 *
 * @version $Id: eb5f5d9c936e05701455bd7de12515ae0944d7a7 $
 * @since 3.2M3
 */
public class LogbackUtils
{
    /**
     * @return the root {@link LoggerContext}.
     */
    public LoggerContext getLoggerContext()
    {
        ILoggerFactory loggerFactory = getLoggerFactory();

        return loggerFactory instanceof LoggerContext ? (LoggerContext) loggerFactory : null;
    }

    /**
     * @return the Logback root logger
     */
    public ch.qos.logback.classic.Logger getRootLogger()
    {
        LoggerContext loggerContext = getLoggerContext();

        return loggerContext != null ? getLoggerContext().getLogger(Logger.ROOT_LOGGER_NAME) : null;
    }

    /**
     * @param level the Logback log level
     * @return the XWiki log level
     */
    public LogLevel toLogLevel(Level level)
    {
        return level != null ? LogLevel.valueOf(level.toString()) : null;
    }

    /**
     * @param logLevel the XWikilog level
     * @return the Logback log level
     */
    public Level toLevel(LogLevel logLevel)
    {
        return logLevel != null ? Level.toLevel(logLevel.toString(), null) : null;
    }

    /**
     * @return the SLF4J Logger Factory used for logging
     */
    protected ILoggerFactory getLoggerFactory()
    {
        return LoggerFactory.getILoggerFactory();
    }
}
