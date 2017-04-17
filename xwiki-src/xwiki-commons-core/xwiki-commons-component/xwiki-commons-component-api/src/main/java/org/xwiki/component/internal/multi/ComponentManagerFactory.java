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
package org.xwiki.component.internal.multi;

import org.xwiki.component.annotation.Role;
import org.xwiki.component.manager.ComponentManager;

/**
 * Return {@link ComponentManager} implementations. If you want to implement your own version of component manager
 * handling for XWiki you'd need to implement this interface. This is the top level interface used to configure XWiki's
 * component system. For example:
 * <code><pre>
 * ComponentManagerFactory factory = new EmbeddableComponentManagerFactory();
 * ComponentAnnotationLoader loader = new ComponentAnnotationLoader();
 * loader.initialize(factory.createComponentManager(), classLoader);
 * </pre></code>
 *
 * @version $Id: 44596d7d867a9ae839bac9f7c079432d78c25ec6 $
 * @since 3.3M2
 */
@Role
public interface ComponentManagerFactory
{
    /**
     * @param parentComponentManager the parent Component Manager of the Component Manager to create. Can be null to
     *            create a Root Component Manager. See also {@link ComponentManager#getParent()}
     * @return a {@link ComponentManager} implementation
     */
    ComponentManager createComponentManager(ComponentManager parentComponentManager);

    /**
     * @param namespace the namespace associated to the new {@link ComponentManager}
     * @param parentComponentManager the parent Component Manager of the Component Manager to create. Can be null to
     *            create a Root Component Manager. See also {@link ComponentManager#getParent()}
     * @return a {@link ComponentManager} implementation
     * @since 6.4M2
     */
    ComponentManager createComponentManager(String namespace, ComponentManager parentComponentManager);
}
