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
package org.xwiki.component.manager;

/**
 * Raised during component lookup when an error happens.
 *
 * @see ComponentManager#getInstance(java.lang.reflect.Type)
 * @version $Id: b77ad300098ff19c447b9a595c61aff63b4043ea $
 */
public class ComponentLookupException extends Exception
{
    /**
     * Needed to identify the version of this code when serializing/deserializing (since Exception is Serializable).
     * Note that the value needs to be modified whenever a non transient field is added or removed in this class.
     */
    private static final long serialVersionUID = 8361313158481775054L;

    /**
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *            method.
     */
    public ComponentLookupException(String message)
    {
        super(message);
    }

    /**
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *            method.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public ComponentLookupException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
