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
 * Provides various services for manipulating an {@link ExecutionContext}.
 *
 * @version $Id: 841a10e171338378a762c3f33ea2024b100c8d0c $
 */
@Role
public interface ExecutionContextManager
{
    /**
     * Set the passed Execution Context in {@link Execution} and initialize it by executing all
     * {@link ExecutionContextInitializer} registered components.
     *
     * @param context the execution context to initialize
     * @throws ExecutionContextException in case one {@link ExecutionContextInitializer} fails to execute
     */
    void initialize(ExecutionContext context) throws ExecutionContextException;

    /**
     * Perform deep cloning of Execution Context properties.
     *
     * @return the cloned Execution Context
     * @param context the execution context to clone
     * @throws ExecutionContextException if the Execution Context failed to be cloned for any reason
     */
    ExecutionContext clone(ExecutionContext context) throws ExecutionContextException;
}
