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
package org.xwiki.extension;

/**
 * Represent a local extension.
 * <p>
 * A local extension is an extension generally downloaded from a remote repository and now stored in the local
 * repository.
 *
 * @version $Id: ac5bd4c07e48d6e393a80076cafb68d3e5b60b26 $
 * @since 4.0M1
 */
public interface LocalExtension extends Extension
{
    /**
     * Custom property key containing {@link #getFile()}.
     */
    String PKEY_FILE = "local.file";

    // Extension

    @Override
    LocalExtensionFile getFile();
}
