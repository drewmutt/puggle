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
import java.util.Map;

import org.xwiki.component.annotation.Role;
import org.xwiki.extension.Extension;
import org.xwiki.extension.ExtensionDependency;
import org.xwiki.extension.ExtensionId;
import org.xwiki.extension.LocalExtension;
import org.xwiki.extension.ResolveException;
import org.xwiki.extension.repository.search.AdvancedSearchable;

/**
 * A repository containing local extension.
 * <p>
 * That's were remote extension are stored after being downloaded and from where extension are actually installed by
 * their respective handlers.
 *
 * @version $Id: cf6259b5a2dd7681a9bbde7605f8de5e119dae81 $
 * @since 4.0M1
 */
@Role
public interface LocalExtensionRepository extends ExtensionRepository, AdvancedSearchable
{
    /**
     * @return the number of local extensions
     */
    int countExtensions();

    /**
     * Return extension descriptor from the repository. If the extension can't be found null is returned.
     *
     * @param extensionId the extension identifier
     * @return the found extension descriptor or null if none could be found
     * @since 4.2RC1
     */
    LocalExtension getLocalExtension(ExtensionId extensionId);

    /**
     * @return all the local extensions, an empty collection if none could be found
     */
    Collection<LocalExtension> getLocalExtensions();

    /**
     * @param id the id of the extension
     * @return the version of the extension stored in the local repository order from the upper version to the lower
     *         version
     */
    Collection<LocalExtension> getLocalExtensionVersions(String id);

    /**
     * Store provided extension (generally a remote extension) in the local repository.
     *
     * @param extension the extension to store
     * @return the new local extension
     * @throws LocalExtensionRepositoryException error when trying store provided extension in the local repository
     */
    LocalExtension storeExtension(Extension extension) throws LocalExtensionRepositoryException;

    /**
     * @param localExtension the local extension to modify
     * @param properties the properties to set
     * @throws LocalExtensionRepositoryException error when trying to save the extension change
     */
    void setProperties(LocalExtension localExtension, Map<String, Object> properties)
        throws LocalExtensionRepositoryException;

    /**
     * Remove extension from local repository.
     *
     * @param extension the extension to remove
     * @throws ResolveException error when trying to find provided extension
     */
    void removeExtension(LocalExtension extension) throws ResolveException;

    // ExtensionRepository

    @Override
    LocalExtension resolve(ExtensionDependency extensionDependency) throws ResolveException;

    @Override
    LocalExtension resolve(ExtensionId extensionId) throws ResolveException;
}
