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
package org.xwiki.cache.event;

import org.xwiki.cache.CacheEntry;

/**
 * Base object used to contains informations when sending cache entry events.
 * 
 * @param <T> the class of the data stored in the cache.
 * @version $Id: dd5bba2a8d3cf77a203d72f506e1950a296cb4bc $
 * @see CacheEntryListener
 */
public interface CacheEntryEvent<T> extends CacheEvent<T>
{
    /**
     * @return the cache entry containing, among other things, the value and the key.
     */
    CacheEntry<T> getEntry();
}
