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
package org.xwiki.extension.job.history.internal;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.configuration.ConfigurationSource;
import org.xwiki.environment.Environment;
import org.xwiki.extension.job.history.ExtensionJobHistoryConfiguration;

/**
 * Default implementation of {@link ExtensionJobHistoryConfiguration}.
 * 
 * @version $Id: a88fea9ab8c80ae611dff821f8dd7a2abfa29c6a $
 * @since 7.1RC1
 */
@Component
@Singleton
public class DefaultExtensionJobHistoryConfiguration implements ExtensionJobHistoryConfiguration
{
    /**
     * Used to get permanent directory.
     */
    @Inject
    private Environment environment;

    /**
     * The configuration.
     */
    @Inject
    private Provider<ConfigurationSource> configuration;

    /**
     * The history storage folder.
     */
    private File storage;

    @Override
    public File getStorage()
    {
        if (this.storage == null) {
            String historyPath = this.configuration.get().getProperty("extension.historyFolder");

            if (historyPath == null) {
                this.storage = new File(this.environment.getPermanentDirectory(), "extension/history/");
            } else {
                this.storage = new File(historyPath);
            }
        }

        return this.storage;
    }
}
