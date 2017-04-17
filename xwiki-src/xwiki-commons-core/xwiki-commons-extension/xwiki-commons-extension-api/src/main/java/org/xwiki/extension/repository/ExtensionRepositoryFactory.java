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

import org.xwiki.component.annotation.Role;

/**
 * Create {@link ExtensionRepository}s.
 *
 * @version $Id: 499c8d3cb48d00e4dfb360d4e2c27929e24b8ddd $
 * @since 4.0M1
 */
@Role
public interface ExtensionRepositoryFactory
{
    /**
     * Create a new {@link ExtensionRepository}.
     *
     * @param repositoryId the repository identifier
     * @return the {@link ExtensionRepository}
     * @throws ExtensionRepositoryException failed to create a {@link ExtensionRepository} for the provided identifier
     * @deprecated since 4.3M1 use {@link #createRepository(ExtensionRepositoryDescriptor)}
     */
    @Deprecated
    ExtensionRepository createRepository(ExtensionRepositoryId repositoryId) throws ExtensionRepositoryException;

    /**
     * Create a new {@link ExtensionRepository}.
     *
     * @param repositoryDescriptor the repository descriptor
     * @return the {@link ExtensionRepository}
     * @throws ExtensionRepositoryException failed to create a {@link ExtensionRepository} for the provided identifier
     * @since 4.3M1
     */
    ExtensionRepository createRepository(ExtensionRepositoryDescriptor repositoryDescriptor)
        throws ExtensionRepositoryException;
}
