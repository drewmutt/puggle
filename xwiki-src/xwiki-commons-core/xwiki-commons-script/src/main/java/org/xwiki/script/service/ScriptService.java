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
package org.xwiki.script.service;

import org.xwiki.component.annotation.Role;

/**
 * Any module wishing to expose Script APIs (for example APIs accessible through Groovy, Python, Velocity, etc)
 * must implement this component interface, in addition to implementing its own business interface. Any component
 * implementing this interface will be automatically exposed to scripts.
 *
 * @version $Id: 92948d382d2382c0d449e6b678d1d409d561e1b3 $
 * @since 2.3M1
 */
@Role
public interface ScriptService
{
    // Voluntarily empty
}
