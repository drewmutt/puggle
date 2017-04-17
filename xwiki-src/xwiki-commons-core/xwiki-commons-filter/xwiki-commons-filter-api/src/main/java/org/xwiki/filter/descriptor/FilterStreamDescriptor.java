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
package org.xwiki.filter.descriptor;

import java.util.Collection;

/**
 * Describes a filter stream.
 *
 * @version $Id: 4cf9218e9fc6d460eccf27b605b4c5737542aeb8 $
 * @since 6.2M1
 */
public interface FilterStreamDescriptor
{
    /**
     * @return human readable name of filter input source type.
     */
    String getName();

    /**
     * @return the description of the filter
     */
    String getDescription();

    /**
     * Return descriptor for the provided property name. The property name is not case sensitive.
     *
     * @param <T> the type of value associated to this property
     * @param propertyName the name of the property
     * @return the descriptor of the property.
     */
    <T> FilterStreamPropertyDescriptor<T> getPropertyDescriptor(String propertyName);

    /**
     * @return the properties of filter.
     */
    Collection<FilterStreamPropertyDescriptor<?>> getProperties();
}
