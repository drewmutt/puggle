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
package org.xwiki.component.event;

import java.lang.reflect.Type;

import org.xwiki.observation.event.Event;

/**
 * Base interface for all components descriptor events.
 *
 * @version $Id: 2dfc9b6b606b24236c0f976ee57896e209b0d6cc $
 * @since 2.6RC2
 */
public interface ComponentDescriptorEvent extends Event
{
    /**
     * @return the role of the component
     * @deprecated since 4.4MA use {@link #getRoleType()} instead
     */
    @Deprecated
    Class<?> getRole();

    /**
     * @return the role type of the component
     * @since 4.4RC1
     */
    Type getRoleType();

    /**
     * @return the role hint of the component
     */
    String getRoleHint();
}
