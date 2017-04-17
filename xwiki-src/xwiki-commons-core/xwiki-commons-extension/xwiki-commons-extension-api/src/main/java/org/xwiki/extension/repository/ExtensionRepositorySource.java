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
package org.xwiki.extension.repository;

import java.util.Collection;

import org.xwiki.component.annotation.Role;

/**
 * A repository identifiers source (for example xwiki.properties).
 *
 * @version $Id: 3e0f940ef725c2fdf7bdd6f593d7cbae8f181a98 $
 * @since 4.0M1
 */
@Role
public interface ExtensionRepositorySource
{
    /**
     * The priority used to order extension repositories. The lowest values have the highest priorities and are listed
     * first. For example a repository priority of 100 will be checked before one with a priority of 500.
     *
     * @return the priority
     * @since 8.3M1
     */
    default int getPriority()
    {
        return ExtensionRepositoryManager.DEFAULT_PRIORITY;
    }

    /**
     * @return the extension repositories identifiers
     * @deprecated since 4.3M1 use {@link #getExtensionRepositoryDescriptors()} instead
     */
    @Deprecated
    Collection<ExtensionRepositoryId> getExtensionRepositories();

    /**
     * @return the extension repositories identifiers
     */
    Collection<ExtensionRepositoryDescriptor> getExtensionRepositoryDescriptors();
}
