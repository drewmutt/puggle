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

import org.xwiki.component.annotation.Role;
import org.xwiki.extension.repository.ExtensionRepository;

/**
 * Main entry point for some extensions management tasks.
 *
 * @version $Id: 85a02ad232c8af58ded7ad70938308ce00ae9017 $
 * @since 4.0M1
 */
@Role
public interface ExtensionManager
{
    /**
     * Search the provided extension among all repositories including core and local repositories.
     * <p>
     * The search is done in the following order:
     * <ul>
     * <li>Is it a core extension ?</li>
     * <li>Is it a local extension ?</li>
     * <li>Is it a remote extension in one of the configured remote repositories ?</li>
     * </ul>
     * The first one found is returned.
     *
     * @param extensionId the extension identifier
     * @return the resolved extension
     * @throws ResolveException error when trying to resolve extension
     */
    Extension resolveExtension(ExtensionId extensionId) throws ResolveException;

    /**
     * Search the provided extension as a dependency of another extension among all repositories including core and
     * local repositories.
     * <p>
     * The search is done in the following order:
     * <ul>
     * <li>Is it a core extension ?</li>
     * <li>Is it a local extension ?</li>
     * <li>Is it a remote extension in one of the configured remote repositories ?</li>
     * </ul>
     * The first one found is returned.
     *
     * @param extensionDependency the extension as dependency
     * @return the resolved extension
     * @throws ResolveException error when trying to resolve extension
     * @deprecated since 5.3M1, use {@link #resolveExtension(ExtensionDependency, String)} instead
     */
    @Deprecated
    Extension resolveExtension(ExtensionDependency extensionDependency) throws ResolveException;

    /**
     * Search the provided extension as a dependency of another extension among all repositories including core and
     * local repositories.
     * <p>
     * The search is done in the following order:
     * <ul>
     * <li>Is it a core extension ?</li>
     * <li>Is it a local extension ?</li>
     * <li>Is this feature installed in current namespace or parent ?</li>
     * <li>Is it a remote extension in one of the configured remote repositories ?</li>
     * </ul>
     * The first one found is returned.
     *
     * @param extensionDependency the extension as dependency
     * @param namespace the namespace where to search for the dependency
     * @return the resolved extension
     * @throws ResolveException error when trying to resolve extension
     * @since 5.3M1
     */
    Extension resolveExtension(ExtensionDependency extensionDependency, String namespace) throws ResolveException;

    /**
     * Return a repository based on its id.
     * <p>
     * This method also return <tt>local</tt>, <tt>installed</tt> and <tt>core</tt> repositories.
     *
     * @param repositoryId the id of the repository
     * @return the repository
     * @since 4.0M2
     */
    ExtensionRepository getRepository(String repositoryId);
}
