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
package org.xwiki.component.util;

/**
 * Various Object utilities.
 *
 * @version $Id: e98e004e29b1d6656d3e0d89dfe9137155879810 $
 * @since 2.1RC1
 */
public final class ObjectUtils
{
    /**
     * Utility class.
     */
    private ObjectUtils()
    {
        // Utility class
    }

    /**
     * Check if provided object are equals. This method also take care of null.
     *
     * @param object1 the first object
     * @param object2 the second object
     * @return true of the provided objects are equal
     * @deprecated use {@link java.util.Objects#equals(Object, Object)} instead
     */
    @Deprecated
    public static boolean equals(Object object1, Object object2)
    {
        if (object1 == object2) {
            return true;
        }

        if (object1 == null || object2 == null) {
            return false;
        }

        return object1.equals(object2);
    }

    /**
     * @param object the object
     * @return the provided object hash code or 0 of the object is null
     * @deprecated use {@link java.util.Objects#hashCode(Object)} instead
     */
    @Deprecated
    public static int hasCode(Object object)
    {
        return object == null ? 0 : object.hashCode();
    }
}
