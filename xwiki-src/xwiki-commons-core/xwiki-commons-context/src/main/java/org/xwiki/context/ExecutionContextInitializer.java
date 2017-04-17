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
package org.xwiki.context;

import org.xwiki.component.annotation.Role;

/**
 * Role which allows different components to initialize every new execution context created, by adding, altering, or
 * removing properties.
 *
 * @version $Id: c8f2feb6ff05c0ba8d5c7bda5cc3dda99a5c5a87 $
 */
@Role
public interface ExecutionContextInitializer
{
    /**
     * The method that will be called when a context is created.
     *
     * @param context the execution context being created
     * @throws ExecutionContextException if the context is not in a state valid for an initializer
     */
    void initialize(ExecutionContext context) throws ExecutionContextException;
}
