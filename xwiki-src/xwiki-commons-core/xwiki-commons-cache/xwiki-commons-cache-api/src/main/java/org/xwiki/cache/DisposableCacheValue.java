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
package org.xwiki.cache;

/**
 * If the value inserted in the cache implement this interface, the {@link #dispose()} method will be called to release
 * all resource used by this data when it is removed from the cache.
 * 
 * @version $Id: 8386d2fc688325138efb41c1d8bd2acb248119ec $
 */
public interface DisposableCacheValue
{
    /**
     * @throws Exception error when releasing the resource of this data.
     */
    void dispose() throws Exception;
}
