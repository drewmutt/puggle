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
package org.xwiki.extension.repository.aether.internal.components;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.codehaus.plexus.ContainerConfiguration;
import org.codehaus.plexus.DefaultContainerConfiguration;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusConstants;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.PlexusContainerException;
import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.component.phase.Initializable;
import org.xwiki.component.phase.InitializationException;

/**
 * Provide easy access to singleton {@link PlexusContainer}.
 *
 * @version $Id: e7db152dcb2b445271d525390eeb1c2cc4e82bd3 $
 * @since 5.2M1
 */
@Component
@Singleton
public class PlexusContainerProvider implements Provider<PlexusContainer>, Initializable
{
    /**
     * The logger to log.
     */
    @Inject
    private Logger logger;

    /**
     * In-process maven runtime.
     */
    private DefaultPlexusContainer plexusContainer;

    @Override
    public void initialize() throws InitializationException
    {
        try {
            ContainerConfiguration config = new DefaultContainerConfiguration();
            config.setAutoWiring(true);
            config.setClassPathScanning(PlexusConstants.SCANNING_INDEX);
            this.plexusContainer = new DefaultPlexusContainer(config);
            this.plexusContainer.setLoggerManager(new XWikiLoggerManager(this.logger));
        } catch (PlexusContainerException e) {
            throw new InitializationException("Failed to initialize Maven", e);
        }
    }

    @Override
    public PlexusContainer get()
    {
        return this.plexusContainer;
    }
}
