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
package org.xwiki.extension.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

/**
 * @version $Id: 8ac00d99803866574baf9499b0a9a481460f1a49 $
 */
public class RepositoryUtils
{
    protected static final String MAVENREPOSITORY_ID = "test-maven";

    protected static final String MAVEN2REPOSITORY_ID = "test-maven2";

    protected final File permanentDirectory;

    protected final File temporaryDirectory;

    protected final File extensionDirectory;

    protected final File localRepositoryRoot;

    protected final File mavenRepositoryRoot;

    protected final File maven2RepositoryRoot;

    protected final File remoteRepositoryRoot;

    protected final ExtensionPackager extensionPackager;

    public RepositoryUtils()
    {
        File testDirectory = new File("target/test-" + new Date().getTime());

        this.temporaryDirectory = new File(testDirectory, "temporary-dir");

        this.permanentDirectory = new File(testDirectory, "permanent-dir");
        this.extensionDirectory = new File(this.permanentDirectory, "extension/");
        this.localRepositoryRoot = new File(this.extensionDirectory, "repository/");

        this.mavenRepositoryRoot = new File(testDirectory, "maven/");
        this.maven2RepositoryRoot = new File(testDirectory, "maven2/");
        this.remoteRepositoryRoot = new File(testDirectory, "remote/");

        Map<String, File> repositories = new HashMap<String, File>();
        repositories.put(null, getRemoteRepository());
        repositories.put("remote", getRemoteRepository());
        repositories.put("local", getLocalRepository());

        this.extensionPackager = new ExtensionPackager(this.permanentDirectory, repositories);

        System.setProperty("extension.repository.local", this.localRepositoryRoot.getAbsolutePath());
        System.setProperty("extension.repository.maven", this.mavenRepositoryRoot.getAbsolutePath());
        System.setProperty("extension.repository.maven2", this.maven2RepositoryRoot.getAbsolutePath());
        System.setProperty("extension.repository.remote", this.remoteRepositoryRoot.getAbsolutePath());
    }

    public File getPermanentDirectory()
    {
        return this.permanentDirectory;
    }

    public File getTemporaryDirectory()
    {
        return this.temporaryDirectory;
    }

    public File getExtensionDirectory()
    {
        return this.extensionDirectory;
    }

    public File getLocalRepository()
    {
        return this.localRepositoryRoot;
    }

    public File getRemoteRepository()
    {
        return this.remoteRepositoryRoot;
    }

    public File getMavenRepository()
    {
        return this.mavenRepositoryRoot;
    }

    public File getMaven2Repository()
    {
        return this.maven2RepositoryRoot;
    }

    public String getMavenRepositoryId()
    {
        return MAVENREPOSITORY_ID;
    }

    public String getMaven2RepositoryId()
    {
        return MAVEN2REPOSITORY_ID;
    }

    public ExtensionPackager getExtensionPackager()
    {
        return this.extensionPackager;
    }

    public void setup() throws Exception
    {
        // copy

        copyResourceFolder(getLocalRepository(), "repository.local");
        copyResourceFolder(getMavenRepository(), "repository.maven");
        copyResourceFolder(getMaven2Repository(), "repository.maven2");

        // generated extensions

        this.extensionPackager.generateExtensions();
    }

    public int copyResourceFolder(File targetFolder, String resourcePackage) throws IOException
    {
        int nb = 0;

        Collection<URL> urls = ClasspathHelper.forPackage(resourcePackage);

        if (!urls.isEmpty()) {
            String prefix = resourcePackage;
            if (!prefix.endsWith(".")) {
                prefix = prefix + '.';
            }

            Reflections reflections =
                new Reflections(new ConfigurationBuilder().setScanners(new ResourcesScanner()).setUrls(urls)
                    .filterInputsBy(new FilterBuilder.Include(FilterBuilder.prefix(prefix))));

            for (String resource : reflections.getResources(Pattern.compile(".*"))) {
                targetFolder.mkdirs();

                File targetFile = new File(targetFolder, resource.substring(prefix.length()));

                InputStream resourceStream = getClass().getResourceAsStream("/" + resource);

                try {
                    FileUtils.copyInputStreamToFile(resourceStream, targetFile);
                    ++nb;
                } finally {
                    resourceStream.close();
                }
            }
        }

        return nb;
    }
}
