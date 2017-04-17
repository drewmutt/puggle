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
package org.xwiki.extension;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Base class or implementations of {@link ExtensionScm}.
 *
 * @version $Id: 71e1b442cf081234b2a0ccbba986409cf49bae14 $
 * @since 6.3M1
 */
public abstract class AbstractExtensionScm implements ExtensionScm
{
    private ExtensionScmConnection connection;

    private ExtensionScmConnection developerConnection;

    private String url;

    /**
     * @param url the browsable URL
     * @param connection the read connection
     * @param developerConnection the write connection
     */
    public AbstractExtensionScm(String url, ExtensionScmConnection connection,
        ExtensionScmConnection developerConnection)
    {
        this.url = url;
        this.connection = connection;
        this.developerConnection = developerConnection;
    }

    @Override
    public ExtensionScmConnection getConnection()
    {
        return this.connection;
    }

    @Override
    public ExtensionScmConnection getDeveloperConnection()
    {
        return this.developerConnection;
    }

    @Override
    public String getUrl()
    {
        return this.url;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }

        if (obj instanceof ExtensionScm) {
            ExtensionScm scm = (ExtensionScm) obj;
            return StringUtils.equals(this.url, scm.getUrl()) && Objects.equals(this.connection, scm.getConnection())
                && Objects.equals(this.developerConnection, scm.getDeveloperConnection());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        HashCodeBuilder builder = new HashCodeBuilder();

        builder.append(this.connection);
        builder.append(this.developerConnection);
        builder.append(this.url);

        return builder.toHashCode();
    }
}
