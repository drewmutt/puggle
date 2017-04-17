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
package org.xwiki.component.descriptor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link DefaultComponentDescriptor}.
 * 
 * @version $Id: f5c90e05e30d7ee77802196112c3a49f3a9c67be $
 * @since 3.3M1
 */
public class DefaultComponentDescriptorTest
{
    private interface Role
    {
    }

    private interface OtherRole
    {
    }

    private class ImplRole
    {
    }
    
    private class ImplOtherRole
    {
    }

    @Test
    public void equals()
    {
        DefaultComponentDescriptor cd1 = new DefaultComponentDescriptor();
        cd1.setImplementation(ImplRole.class);
        cd1.setRoleType(Role.class);
        cd1.setRoleHint("hint");

        Assert.assertEquals(cd1, cd1);

        DefaultComponentDescriptor cd2 = new DefaultComponentDescriptor();
        cd2.setImplementation(ImplRole.class);
        cd2.setRoleType(Role.class);
        cd2.setRoleHint("hint");

        Assert.assertEquals(cd1, cd2);

        DefaultComponentDescriptor cd3 = new DefaultComponentDescriptor();
        cd3.setImplementation(ImplRole.class);
        cd3.setRoleType(OtherRole.class);
        cd3.setRoleHint("hint");

        Assert.assertFalse(cd1.equals(cd3));

        DefaultComponentDescriptor cd4 = new DefaultComponentDescriptor();
        cd4.setImplementation(ImplOtherRole.class);
        cd4.setRoleType(Role.class);
        cd4.setRoleHint("hint");

        Assert.assertFalse(cd1.equals(cd4));

        DefaultComponentDescriptor cd5 = new DefaultComponentDescriptor();
        cd5.setImplementation(ImplRole.class);
        cd5.setRoleType(Role.class);
        cd5.setRoleHint("hint");
        cd5.setInstantiationStrategy(ComponentInstantiationStrategy.PER_LOOKUP);

        Assert.assertFalse(cd1.equals(cd5));

        DefaultComponentDescriptor cd6 = new DefaultComponentDescriptor();
        cd6.setImplementation(ImplRole.class);
        cd6.setRoleType(Role.class);
        cd6.setRoleHint("hint");
        DefaultComponentDependency dep = new DefaultComponentDependency();
        dep.setName("name");
        dep.setMappingType(String.class);
        cd6.addComponentDependency(dep);

        Assert.assertFalse(cd1.equals(cd6));

        DefaultComponentDescriptor cd7 = new DefaultComponentDescriptor();
        cd7.setImplementation(ImplRole.class);
        cd7.setRoleType(Role.class);
        cd7.setRoleHint("hint");
        DefaultComponentDependency dep2 = new DefaultComponentDependency();
        dep2.setName("name");
        dep2.setMappingType(String.class);
        cd7.addComponentDependency(dep2);

        Assert.assertEquals(cd6, cd7);

        DefaultComponentDescriptor cd8 = new DefaultComponentDescriptor();
        cd8.setImplementation(ImplRole.class);
        cd8.setRoleType(Role.class);
        cd8.setRoleHint("hint");
        DefaultComponentDependency dep3 = new DefaultComponentDependency();
        dep3.setName("name");
        dep3.setMappingType(String.class);
        cd8.addComponentDependency(dep3);
        cd8.addComponentDependency(dep3);

        Assert.assertFalse(cd7.equals(cd8));
    }
}
