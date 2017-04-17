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
package org.xwiki.component.embed;

import org.xwiki.component.descriptor.ComponentDescriptor;
import org.xwiki.component.internal.Composable;
import org.xwiki.component.manager.ComponentManager;

/**
 * Handles lifecycle for {@link Composable}.
 *
 * @version $Id: 8bdedc6b3df65727eab0b39da7e7003b6a2407d0 $
 * @since 3.2RC1
 */
public class ComposableLifecycleHandler implements LifecycleHandler
{
    @Override
    public <T> void handle(T instance, ComponentDescriptor<T> descriptor, ComponentManager componentManager)
    {
        // Only support Composable for classes implementing ComponentManager since for all other components
        // they should have ComponentManager injected.
        if (ComponentManager.class.isAssignableFrom(descriptor.getImplementation())
            && Composable.class.isAssignableFrom(descriptor.getImplementation()))
        {
            ((Composable) instance).compose(componentManager);
        }
    }
}
