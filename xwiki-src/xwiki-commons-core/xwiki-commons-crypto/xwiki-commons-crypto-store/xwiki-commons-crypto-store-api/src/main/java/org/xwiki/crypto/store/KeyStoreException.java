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
package org.xwiki.crypto.store;

/**
 * Exception thrown by the {@link org.xwiki.crypto.store.KeyStore}.
 *
 * @version $Id: 99eb5e9e83ede0adaca48ad87e8d3e2c7192b1cd $
 * @since 6.1M2
 */
public class KeyStoreException extends Exception
{
    private static final long serialVersionUID = -2977947971178390553L;

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage()
     *                method.
     */
    public KeyStoreException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage()
     *                method.
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is
     *              permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public KeyStoreException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
