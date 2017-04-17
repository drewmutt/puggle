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
package org.xwiki.classloader;

import org.xwiki.component.annotation.Role;

/**
 * Adds the ability for a {@link java.net.URLStreamHandler} implementation to return the protocol it's managing. Note
 * that unfortunately we cannot extend {@link java.net.URLStreamHandler} since it's an abstract class and not an
 * interface. Thus components implementing this interface need also to extend {@link java.net.URLStreamHandler} and user
 * code need to cast looked up instance as {@link java.net.URLStreamHandler} instances to use them as proper stream
 * handlers.
 *
 * @version $Id: 3a5e71d5e9e9db4887440d608ece2224a8ee49b1 $
 * @since 2.0.1
 */
@Role
public interface ExtendedURLStreamHandler
{
    /**
     * @return the URL protocol supported by the current stream handler (eg "jar", "http", "attachmentjar", etc)
     */
    String getProtocol();
}
