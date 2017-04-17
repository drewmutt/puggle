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
package org.xwiki.context;

/**
 * Thrown when declaring a property that already exists in the execution context.
 *
 * @version $Id: 9ecd1ccfd59389c86f82ade29ca5aa42f77b99f6 $
 * @since 4.3M1
 */
public class PropertyAlreadyExistsException extends RuntimeException
{
    /** The serial version uid. */
    private static final long serialVersionUID = 1L;

    /** @param key The key of the property in question. */
    public PropertyAlreadyExistsException(String key)
    {
        super(String.format("There property [%s] already exists in the execution context.", key));
    }
}
