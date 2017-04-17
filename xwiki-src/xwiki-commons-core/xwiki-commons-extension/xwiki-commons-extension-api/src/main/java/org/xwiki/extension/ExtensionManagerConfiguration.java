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

import java.io.File;
import java.util.Collection;

import org.xwiki.component.annotation.Role;
import org.xwiki.extension.repository.ExtensionRepositoryDescriptor;
import org.xwiki.extension.repository.ExtensionRepositoryId;

/**
 * Provide some general extension manager configuration.
 *
 * @version $Id: 32c5949529b806a834ea59e3b1042e158ac7d740 $
 * @since 4.0M1
 */
@Role
public interface ExtensionManagerConfiguration
{
    /**
     * @return the folder containing the local extensions
     * @see org.xwiki.extension.repository.LocalExtensionRepository
     */
    File getLocalRepository();

    /**
     * @return the configured repositories
     * @deprecated since 4.3M1 use {@link #getExtensionRepositoryDescriptors()} instead
     */
    @Deprecated
    Collection<ExtensionRepositoryId> getRepositories();

    /**
     * @return the configured repositories
     * @since 4.3M1
     */
    Collection<ExtensionRepositoryDescriptor> getExtensionRepositoryDescriptors();

    /**
     * @return the user agent to declare when communication with external services (generally repositories)
     */
    String getUserAgent();

    /**
     * @return true if XWiki should try to get more informations about the core extensions using the repositories
     * @since 8.3RC1
     */
    default boolean resolveCoreExtensions()
    {
        return true;
    }
}
