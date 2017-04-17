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
package org.xwiki.management;

import org.xwiki.component.annotation.Role;

/**
 * Registers MBeans against the default platform MBean Server.
 *
 * @version $Id: 1af06da4b694985593a048a05fc70dffa783b3d7 $
 * @since 2.4M2
 */
@Role
public interface JMXBeanRegistration
{
    /**
     * @param mbean the mbean instance to register
     * @param name the name under which to register, for example "type=Velocity,domain=Engines,name=someName". Note
     *        that the domain is registered by default and shouldn't be passed
     */
    void registerMBean(Object mbean, String name);

    /**
     * @param name the name under which to register, for example "type=Velocity,domain=Engines,name=someName". Note
     *        that the domain is registered by default and shouldn't be passed
     * @since 6.4RC1
     */
    void unregisterMBean(String name);
}
