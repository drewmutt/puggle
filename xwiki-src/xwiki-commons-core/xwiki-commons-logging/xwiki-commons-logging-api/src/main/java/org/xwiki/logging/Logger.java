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

import org.xwiki.logging.event.LogEvent;

/**
 * A {@link org.slf4j.Logger} with support for {@link LogEvent}.
 *
 * @version $Id: 37907fca36c520e0acfececcd08c46542d317816 $
 * @since 5.4M1
 */
public interface Logger extends org.slf4j.Logger
{
    /**
     * @param logEvent the log event
     */
    void log(LogEvent logEvent);
}
