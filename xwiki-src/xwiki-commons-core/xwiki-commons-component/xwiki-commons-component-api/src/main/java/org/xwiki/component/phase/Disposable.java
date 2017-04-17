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
package org.xwiki.component.phase;

import org.xwiki.component.manager.ComponentLifecycleException;

/**
 * If a singleton component could be destroyed and replaced in the component manager, it should implement this interface
 * to properly clean up its resources. Any component depending of a component exposing this interface should be aware
 * that this component could be destroyed and should prevent itself to use a destroyed component.
 *
 * @version $Id: 96fb8204ddbb8b6c62c1618362ed20bb3a1ab157 $
 * @since 3.3M2
 */
public interface Disposable
{
    /**
     * Method called by the Component Manager when a singleton component is unregistered and should be destroyed.
     *
     * @throws ComponentLifecycleException if an error happens during a component's destruction
     */
    void dispose() throws ComponentLifecycleException;
}
