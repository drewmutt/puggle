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
package org.xwiki.component.namespace;

import java.util.Collection;

import org.xwiki.component.annotation.Role;

/**
 * Validate a namespace against list of allowed namespaces.
 * 
 * @version $Id: ab90906780ffb4282206afb149b2524d3929f01b $
 * @since 8.0M1
 */
@Role
public interface NamespaceValidator
{
    /**
     * @param allowedNamespaces the allowed dynamic (or not) namespaces, null matches any namespace
     * @param namespace to validate against passed allowed namespaces
     * @return the namespace(s) corresponding to the passed dynamic namespaces
     */
    boolean isAllowed(Collection<String> allowedNamespaces, String namespace);

    /**
     * @param allowedNamespaces the allowed dynamic (or not) namespaces, null matches any namespace
     * @param namespace to validate against passed allowed namespaces
     * @throws NamespaceNotAllowedException when the passed namespace is not allowed
     */
    void checkAllowed(Collection<String> allowedNamespaces, String namespace) throws NamespaceNotAllowedException;
}
