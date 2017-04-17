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

import java.util.ArrayList;
import java.util.Collection;

/**
 * Base class for {@link ExtensionRepositorySource} implementations.
 *
 * @version $Id: d350e0dbf54138b426a04346e1cbf20ff6c13263 $
 * @since 4.3M1
 */
public abstract class AbstractExtensionRepositorySource implements ExtensionRepositorySource
{
    @Override
    public int getPriority()
    {
        return 100;
    }

    @Override
    public Collection<ExtensionRepositoryId> getExtensionRepositories()
    {
        Collection<ExtensionRepositoryId> repositories = new ArrayList<ExtensionRepositoryId>();

        for (ExtensionRepositoryDescriptor descriptor : getExtensionRepositoryDescriptors()) {
            repositories.add(new ExtensionRepositoryId(descriptor));
        }

        return repositories;
    }
}
