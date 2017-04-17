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

package org.xwiki.extension.jar;

import javax.inject.Singleton;

import org.xwiki.classloader.internal.DefaultClassLoaderManager;
import org.xwiki.component.annotation.Component;
import org.xwiki.component.phase.InitializationException;

/**
 * Override the DefaultJarExtensionClassLoader to prevent access to extension classes available in the classpath of the
 * test and therefore isolate the tested extension properly.
 *
 * @version $Id: 2eb9cd1037ba81849545746d081173f3df45ed40 $
 */
@Component(staticRegistration = false)
@Singleton
public class TestJarExtensionClassLoaderManager extends DefaultClassLoaderManager
{
    public TestExtensionClassLoader testExtensionClassLoader = new TestExtensionClassLoader();

    @Override
    public void initialize() throws InitializationException
    {
        this.containerClassLoader = this.testExtensionClassLoader;
    }
}
