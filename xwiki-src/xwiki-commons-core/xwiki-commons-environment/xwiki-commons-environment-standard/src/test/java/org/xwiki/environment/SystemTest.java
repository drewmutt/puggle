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
package org.xwiki.environment;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.helpers.NOPLogger;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.component.util.ReflectionUtils;

/**
 * Unit tests for {@link org.xwiki.environment.System}.
 *
 * @version $Id: 1a3366c80f29a7d96f9c5c27ee5e2eddaaf4070b $
 * @since 3.5M1
 */
public class SystemTest
{
    private static final File TMPDIR = new File(java.lang.System.getProperty("java.io.tmpdir"), "xwiki-temp");

    @Test
    public void testInitializeWithNoParameter() throws Exception
    {
        ComponentManager componentManager = System.initialize();
        Assert.assertNotNull(componentManager);

        Environment environment = componentManager.getInstance(Environment.class);

        // Capture logs so that they don't leak in the test console
        ReflectionUtils.setFieldValue(environment, "logger", NOPLogger.NOP_LOGGER);

        // Verify that the temporary directory is `java.io.tmpdir`/xwiki-temp/
        Assert.assertEquals(TMPDIR, environment.getTemporaryDirectory());

        // Verify that the Permanent directory is java.io.tmpdir
        Assert.assertEquals(new File(java.lang.System.getProperty("java.io.tmpdir")),
            environment.getPermanentDirectory());
    }

    @Test
    public void testInitializeWithAllDirectoriesSet() throws Exception
    {
        File permanentDirectory = new File("/permanent");
        File temporaryDirectory = new File("/temporary");
        File resourceDirectory = new File("/resource");

        ComponentManager componentManager =
            System.initialize(permanentDirectory, resourceDirectory, temporaryDirectory);
        Assert.assertNotNull(componentManager);

        Environment environment = componentManager.getInstance(Environment.class);

        // Verify the temporary directory
        Assert.assertEquals(temporaryDirectory, environment.getTemporaryDirectory());

        // Verify the Permanent directory
        Assert.assertEquals(permanentDirectory, environment.getPermanentDirectory());
    }

    @Test
    public void testDispose() throws Exception
    {
        ComponentManager componentManager = System.initialize();

        TestComponent testComponent = componentManager.getInstance(TestRole.class);

        Assert.assertFalse(testComponent.isDisposed());

        System.dispose(componentManager);

        Assert.assertTrue(testComponent.isDisposed());
    }
}
