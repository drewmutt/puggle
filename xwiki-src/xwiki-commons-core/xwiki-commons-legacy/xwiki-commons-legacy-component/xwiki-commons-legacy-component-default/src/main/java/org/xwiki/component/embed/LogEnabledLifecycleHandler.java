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
import org.xwiki.component.logging.DefaultLogger;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.component.phase.LogEnabled;

/**
 * Handles lifecycle for {@link org.xwiki.component.phase.LogEnabled}.
 * 
 * @version $Id: d6d0b0c87941146f47f4cf03291d7321eab3fefb $
 * @since 3.2RC1
 */
public class LogEnabledLifecycleHandler implements LifecycleHandler
{
    @Override
    public <T> void handle(T instance, ComponentDescriptor<T> descriptor, ComponentManager componentManager)
    {
        if (LogEnabled.class.isAssignableFrom(descriptor.getImplementation())) {
            ((LogEnabled) instance).enableLogging(new DefaultLogger(instance.getClass()));
        }
    }
}
