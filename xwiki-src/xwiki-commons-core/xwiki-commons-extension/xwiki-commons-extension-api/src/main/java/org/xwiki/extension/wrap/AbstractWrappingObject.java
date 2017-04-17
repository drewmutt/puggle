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
package org.xwiki.extension.wrap;

/**
 * Wrap an Object.
 *
 * @param <T> the type of the wrapped object
 * @version $Id: 592f5ed2cc7588ac98363b06320d6b4f2a682ffe $
 * @since 4.0M1
 * @deprecated since 7.2M1, use directly {@link org.xwiki.script.wrap.AbstractWrappingObject} instead
 */
@Deprecated
public abstract class AbstractWrappingObject<T> extends org.xwiki.script.wrap.AbstractWrappingObject<T>
{
    /**
     * @param wrapped the wrapped object
     */
    public AbstractWrappingObject(T wrapped)
    {
        super(wrapped);
    }
}
