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
package org.xwiki.component.descriptor;

import java.util.Collection;

/**
 * Represent a component.
 *
 * @version $Id: a0aae74ff005b8535ca54b29c20903c022ebc0b3 $
 * @param <T> the type of the component role
 * @since 1.7M1
 */
public interface ComponentDescriptor<T> extends ComponentRole<T>
{
    /**
     * @return the class of the component implementation
     */
    Class<? extends T> getImplementation();

    /**
     * @return the way the component should be instantiated
     * @see ComponentInstantiationStrategy
     */
    ComponentInstantiationStrategy getInstantiationStrategy();

    /**
     * @return the components on which this component depends
     */
    Collection<ComponentDependency<?>> getComponentDependencies();
}
