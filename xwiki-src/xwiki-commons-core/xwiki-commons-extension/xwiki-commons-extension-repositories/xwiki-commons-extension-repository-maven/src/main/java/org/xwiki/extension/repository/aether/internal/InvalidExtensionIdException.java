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
package org.xwiki.extension.repository.aether.internal;

import org.xwiki.extension.ResolveException;

/**
 * Extension id does not match groupid:artifactid.
 *
 * @version $Id: 4a8ccdf72cb85f648c08a42efceeae2a2f6e6160 $
 * @since 8.2M1
 */
public class InvalidExtensionIdException extends ResolveException
{
    /**
     * Serialization identifier.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause(Throwable)}.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public InvalidExtensionIdException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). A null value is
     *            permitted, and indicates that the cause is nonexistent or unknown
     */
    public InvalidExtensionIdException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
