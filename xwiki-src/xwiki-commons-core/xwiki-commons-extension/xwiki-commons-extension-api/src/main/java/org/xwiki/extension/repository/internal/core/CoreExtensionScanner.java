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
package org.xwiki.extension.repository.internal.core;

import java.util.Collection;
import java.util.Map;

import org.xwiki.component.annotation.Role;

/**
 * Scan jars to find core extensions.
 *
 * @version $Id: 135c1339ae8cf4c8b04409753b93e7a87eceb9a8 $
 * @since 4.0M1
 */
@Role
public interface CoreExtensionScanner
{
    /**
     * Try to get informations as complete as possible using remote repositories. This method can take a long time so it
     * is generally used in a thread started after a short scan to update the list.
     *
     * @param extensions the extensions to update
     */
    void updateExtensions(Collection<DefaultCoreExtension> extensions);

    /**
     * Scan environment resources to find core extension.
     *
     * @param repository the repository used to create {@link DefaultCoreExtension}s.
     * @return the found extension. Null if none is declared.
     */
    DefaultCoreExtension loadEnvironmentExtension(DefaultCoreExtensionRepository repository);

    /**
     * Scan classpath to find core extensions.
     *
     * @param repository the repository used to create {@link DefaultCoreExtension}s.
     * @return found extensions. Empty {@link Map} if none can be found.
     */
    Map<String, DefaultCoreExtension> loadExtensions(DefaultCoreExtensionRepository repository);
}
