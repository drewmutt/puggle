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
import org.xwiki.extension.CoreExtension;
import org.xwiki.extension.ExtensionDependency;
import org.xwiki.extension.ExtensionId;
import org.xwiki.extension.ResolveException;
import org.xwiki.extension.repository.search.AdvancedSearchable;

/**
 * Virtual extension repository containing core extensions.
 *
 * @version $Id: f8efd8bc11d44955d6202516949da59c548bc250 $
 * @since 4.0M1
 */
@Role
public interface CoreExtensionRepository extends ExtensionRepository, AdvancedSearchable
{
    /**
     * @return the number of core extensions
     */
    int countExtensions();

    /**
     * @return all the core extensions
     */
    Collection<CoreExtension> getCoreExtensions();

    /**
     * Return the extension corresponding to the current environment if any. Generally used to get the current XWiki
     * distribution.
     *
     * @return the core extension associated to the environment
     */
    CoreExtension getEnvironmentExtension();

    /**
     * @param feature the feature provided by the extension including its identifier (version is not needed since there
     *            can be only one version of a core extension)
     * @return the core extension, null if none is found
     */
    CoreExtension getCoreExtension(String feature);

    /**
     * @param feature the feature provided by the extension including its identifier (version is not needed since there
     *            can be only one version of a core extension)
     * @return true if the extension exists, false otherwise
     */
    boolean exists(String feature);

    // ExtensionRepository

    @Override
    CoreExtension resolve(ExtensionDependency extensionDependency) throws ResolveException;

    @Override
    CoreExtension resolve(ExtensionId extensionId) throws ResolveException;
}
