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
package org.xwiki.extension.event;

import org.xwiki.extension.ExtensionId;
import org.xwiki.observation.event.Event;

/**
 * An extension related event.
 *
 * @version $Id: 8de4bdcbb6360109eb57c77bbc5833b96de7f878 $
 * @since 4.0M1
 */
public interface ExtensionEvent extends Event
{
    /**
     * @return the event related extension identifier
     */
    ExtensionId getExtensionId();

    /**
     * @return the namespace on which the event happened, null mean root namespace
     */
    String getNamespace();

    /**
     * @return indicate of the namespace has been set in this event
     */
    boolean hasNamespace();
}
