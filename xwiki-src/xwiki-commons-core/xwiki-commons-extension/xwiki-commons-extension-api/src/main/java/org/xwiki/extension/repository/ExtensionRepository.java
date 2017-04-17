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

import org.xwiki.extension.Extension;
import org.xwiki.extension.ExtensionDependency;
import org.xwiki.extension.ExtensionId;
import org.xwiki.extension.ExtensionNotFoundException;
import org.xwiki.extension.ResolveException;
import org.xwiki.extension.repository.result.IterableResult;
import org.xwiki.extension.version.Version;

/**
 * A repository containing extensions.
 *
 * @version $Id: 5d9bb33118cae84bc5a00ffe81dda99b037b0630 $
 * @since 4.0M1
 */
public interface ExtensionRepository
{
    /**
     * @return the repository descriptor
     * @since 4.3M1
     */
    ExtensionRepositoryDescriptor getDescriptor();

    /**
     * Return extension descriptor from the repository. If the extension can't be found a {@link ResolveException} is
     * thrown.
     *
     * @param extensionId the extension identifier
     * @return the found extension descriptor
     * @throws ExtensionNotFoundException when the extension does not exist in the repository
     * @throws ResolveException failed to find extension in the repository
     */
    Extension resolve(ExtensionId extensionId) throws ResolveException;

    /**
     * Return extension descriptor from the repository. If the extension can't be found a {@link ResolveException} is
     * thrown.
     *
     * @param extensionDependency the target extension as a dependency
     * @return the found extension descriptor
     * @throws ExtensionNotFoundException when the dependency does not match any extension in the repository
     * @throws ResolveException failed to find extension in the repository
     */
    Extension resolve(ExtensionDependency extensionDependency) throws ResolveException;

    /**
     * Return ordered (ascendent) versions for the provided extension id.
     *
     * @param id the id of the extensions for which to return versions
     * @param offset the offset from where to start returning versions
     * @param nb the maximum number of versions to return
     * @return the versions of the provided extension id
     * @throws ExtensionNotFoundException when the extension does not exist in the repository
     * @throws ResolveException fail to find extension for provided id
     */
    IterableResult<Version> resolveVersions(String id, int offset, int nb) throws ResolveException;

    /**
     * @param extensionId the extension identifier
     * @return true if the extension exists in the repository
     */
    boolean exists(ExtensionId extensionId);

    // Deprecated

    /**
     * @return the repository identifier.
     * @deprecated since 4.3M1 use {@link #getDescriptor()} instead
     */
    @Deprecated
    ExtensionRepositoryId getId();
}
