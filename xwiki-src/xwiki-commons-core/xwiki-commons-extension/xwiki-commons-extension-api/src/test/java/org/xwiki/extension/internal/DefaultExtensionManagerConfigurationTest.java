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
package org.xwiki.extension.internal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.xwiki.configuration.internal.MemoryConfigurationSource;
import org.xwiki.environment.Environment;
import org.xwiki.extension.ExtensionManagerConfiguration;
import org.xwiki.extension.repository.DefaultExtensionRepositoryDescriptor;
import org.xwiki.extension.repository.ExtensionRepositoryDescriptor;
import org.xwiki.test.LogRule;
import org.xwiki.test.annotation.BeforeComponent;
import org.xwiki.test.annotation.ComponentList;
import org.xwiki.test.mockito.MockitoComponentManagerRule;

/**
 * Unit test for {@link DefaultExtensionManagerConfiguration}.
 *
 * @version $Id: d4f308ee00474989b4c1482e0d91c00244b7f32e $
 */
@ComponentList({ DefaultExtensionManagerConfiguration.class, ExtensionFactory.class })
public class DefaultExtensionManagerConfigurationTest
{
    @Rule
    public final MockitoComponentManagerRule componentManager = new MockitoComponentManagerRule();

    @Rule
    public final LogRule logCapture = new LogRule()
    {
        {
            record(LogLevel.WARN);
            recordLoggingForType(DefaultExtensionManagerConfiguration.class);
        }
    };

    private ExtensionManagerConfiguration configuration;

    private MemoryConfigurationSource source;

    @BeforeComponent
    public void registerComponents() throws Exception
    {
        // Register a Mocked Environment since we need to provide one.
        this.componentManager.registerMockComponent(Environment.class);

        // Register some in-memory Configuration Source for the test
        this.source = this.componentManager.registerMemoryConfigurationSource();
    }

    @Before
    public void setUp() throws Exception
    {
        this.configuration = this.componentManager.getInstance(ExtensionManagerConfiguration.class);
    }

    @Test
    public void testGetRepositoriesWithInvalid() throws Exception
    {
        // We define 2 repositories: a valid one and an invalid one.
        // The goal is to verify that the invalid one is ignored but a warning is reported in the logs.
        this.source.setProperty("extension.repositories", Arrays.asList("id:type:http://url", "invalid"));

        Assert.assertEquals(
            Arrays.asList(new DefaultExtensionRepositoryDescriptor("id", "type", new URI("http://url"))),
            new ArrayList<ExtensionRepositoryDescriptor>(this.configuration.getExtensionRepositoryDescriptors()));
        Assert.assertEquals(1, this.logCapture.size());
        Assert.assertEquals("Ignoring invalid repository configuration [invalid]. Root cause "
            + "[ExtensionManagerConfigurationException: Invalid repository configuration format for [invalid]. Should "
            + "have been matching [([^:]+):([^:]+):(.+)].]", this.logCapture.getMessage(0));
    }

    @Test
    public void testGetExtensionRepositoryDescriptorsEmpty()
    {
        Assert.assertEquals(null, this.configuration.getExtensionRepositoryDescriptors());
        Assert.assertEquals(0, this.logCapture.size());
    }

    @Test
    public void testGetExtensionRepositoryDescriptorsWithProperties() throws URISyntaxException
    {
        this.source.setProperty("extension.repositories", Arrays.asList("id:type:http://url"));
        this.source.setProperty("extension.repositories.id.property", "value");
        this.source.setProperty("extension.repositories.id.property.with.dots", "other value");

        Collection<ExtensionRepositoryDescriptor> descriptors = this.configuration.getExtensionRepositoryDescriptors();

        Assert.assertFalse(descriptors.isEmpty());

        ExtensionRepositoryDescriptor descriptor = descriptors.iterator().next();

        Assert.assertEquals("id", descriptor.getId());
        Assert.assertEquals("type", descriptor.getType());
        Assert.assertEquals(new URI("http://url"), descriptor.getURI());
        Assert.assertEquals("value", descriptor.getProperty("property"));
        Assert.assertEquals("other value", descriptor.getProperty("property.with.dots"));
        Assert.assertEquals(0, this.logCapture.size());
    }
}
