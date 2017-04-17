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
package org.xwiki.observation.event.filter;

import java.io.Serializable;

/**
 * An {@link EventFilter} that always matches another event filter.
 *
 * @version $Id: 23993703e89d0167dc90e6e564cc37956b99f9be $
 */
public class AlwaysMatchingEventFilter implements EventFilter, Serializable
{
    /**
     * Unique instance of {@link AlwaysMatchingEventFilter}.
     *
     * @since 6.0M1
     */
    public static final AlwaysMatchingEventFilter INSTANCE = new AlwaysMatchingEventFilter();

    /**
     * The version identifier for this Serializable class. Increment only if the <i>serialized</i> form of the class
     * changes.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @deprecated since 6.0M1, use {@link #INSTANCE} instead
     */
    @Deprecated
    public AlwaysMatchingEventFilter()
    {

    }

    @Override
    public String getFilter()
    {
        return ".*";
    }

    @Override
    public boolean matches(EventFilter eventFilter)
    {
        return true;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj != null && obj.getClass() == getClass();
    }

    @Override
    public int hashCode()
    {
        return 0;
    }
}
