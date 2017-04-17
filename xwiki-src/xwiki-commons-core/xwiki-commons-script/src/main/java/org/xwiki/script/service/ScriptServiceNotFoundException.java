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
package org.xwiki.script.service;

/**
 * Thrown when a Script Service cannot be located.
 *
 * @version $Id: 461fc2c44ee37010b0a7ab32210475b3d0994ba2 $
 * @since 2.3M1
 * @deprecated not used anymore
 */
@Deprecated
public class ScriptServiceNotFoundException extends Exception
{
    /**
     * Class ID for serialization.
     */
    private static final long serialVersionUID = 8940300614005225360L;

    /**
     * Creates a new exception with the given message.
     *
     * @param message the exception message
     * @see Exception#Exception(String)
     */
    public ScriptServiceNotFoundException(String message)
    {
        super(message);
    }

    /**
     * Creates a new exception with the given message, wrapping the specified throwable object.
     *
     * @param message the exception message
     * @param throwable the throwable object to wrap
     * @see Exception#Exception(String, Throwable)
     */
    public ScriptServiceNotFoundException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
