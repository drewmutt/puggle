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
package org.xwiki.extension.repository.aether.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.aether.artifact.Artifact;
import org.xwiki.extension.Extension;
import org.xwiki.extension.internal.ExtensionFactory;
import org.xwiki.extension.maven.internal.AbstractMavenExtension;
import org.xwiki.extension.repository.ExtensionRepositoryDescriptor;

/**
 * Add support for repositories supported by AETHER (only Maven for now).
 *
 * @version $Id: 4f6981f80c8c0300be213e4f4b2b59a0c9bb23a4 $
 * @since 4.0M1
 */
public class AetherExtension extends AbstractMavenExtension
{
    public static final String PKEY_AETHER_ARTIFACT = "aether.Artifact";

    public AetherExtension(Extension mavenExtension, Artifact artifact, AetherExtensionRepository repository,
        ExtensionFactory factory)
    {
        super(repository, mavenExtension);

        setId(AetherUtils.createExtensionId(artifact, factory));
        setType(artifact.getExtension());

        setFile(new AetherExtensionFile(artifact, repository));

        // Make sure we remember the extension repository (Extension#getRepository() will be the local extension
        // repository when the extension is downloaded)
        if (repository != null) {
            List<ExtensionRepositoryDescriptor> newRepositories = new ArrayList<>(getRepositories().size() + 1);

            newRepositories.add(repository.getDescriptor());
            newRepositories.addAll(getRepositories());

            setRepositories(newRepositories);
        }
    }
}
