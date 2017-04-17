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
package org.xwiki.script;

import javax.script.ScriptContext;

import org.xwiki.component.annotation.Role;

/**
 * Initialize {@link ScriptContext}.
 *
 * @version $Id: 88416eaad98d39e6a955d85cc9ab886291f63132 $
 */
@Role
public interface ScriptContextInitializer
{
    /**
     * Initialize provided {@link ScriptContext}.
     *
     * @param context the {@link ScriptContext} to initialize.
     */
    void initialize(ScriptContext context);
}
