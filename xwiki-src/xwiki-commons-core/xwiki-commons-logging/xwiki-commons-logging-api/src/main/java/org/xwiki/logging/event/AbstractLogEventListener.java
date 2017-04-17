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

import java.util.Arrays;
import java.util.List;

import org.xwiki.observation.EventListener;
import org.xwiki.observation.event.Event;

/**
 * Base class to implement {@link LogEvent} listener.
 *
 * @version $Id: fc4410562393cdf20e426171265d2f74217bd314 $
 * @since 3.2M3
 */
public abstract class AbstractLogEventListener implements EventListener
{
    /**
     * The matched events.
     */
    private static final List<Event> EVENTS = Arrays.<Event>asList(new LogEvent(), new BeginLogEvent(),
        new EndLogEvent());

    @Override
    public List<Event> getEvents()
    {
        return EVENTS;
    }
}
