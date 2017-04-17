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
package org.xwiki.observation;

import java.util.Arrays;
import java.util.List;

import org.xwiki.observation.event.Event;

/**
 * Base class for {@link EventListener}s.
 *
 * @version $Id: 945e79b216b98e3babad44dc92ebc7e198ae5594 $
 * @since 5.4RC1
 */
public abstract class AbstractEventListener implements EventListener
{
    private final String name;

    private final List<? extends Event> events;

    /**
     * @param name the listener's name. It's a free form text identifying this listener instance in a unique manner.
     *            This name is used for some operations in {@link ObservationManager}.
     * @param events the list of events this listener is configured to receive. This listener will be automatically
     *            registered with this list of events against the {@link ObservationManager}. When an event occurs, for
     *            each matching event in this list, the {@link #onEvent(Event, Object, Object)} method will be called.
     */
    public AbstractEventListener(String name, List<? extends Event> events)
    {
        this.name = name;
        this.events = events;
    }

    /**
     * @param name the listener's name. It's a free form text identifying this listener instance in a unique manner.
     *            This name is used for some operations in {@link ObservationManager}.
     * @param events the list of events this listener is configured to receive. This listener will be automatically
     *            registered with this list of events against the {@link ObservationManager}. When an event occurs, for
     *            each matching event in this list, the {@link #onEvent(Event, Object, Object)} method will be called.
     */
    public AbstractEventListener(String name, Event... events)
    {
        this.name = name;
        this.events = Arrays.asList(events);
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public List<Event> getEvents()
    {
        return (List<Event>) this.events;
    }
}
