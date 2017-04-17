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
package org.xwiki.extension.repository.result;

/**
 * The result of a query.
 *
 * @param <T> the type
 * @version $Id: 4df134813f5409805208d5e96d2555b520b01d40 $
 * @since 4.0M1
 */
public interface IterableResult<T> extends Iterable<T>
{
    /**
     * @return the total number of possible results without offset or maximum results limits
     */
    int getTotalHits();

    /**
     * @return the index in the total number of possible search result where this extract starts
     */
    int getOffset();

    /**
     * @return the number of found extensions
     */
    int getSize();
}
