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
package org.xwiki.component.namespace;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A namespace.
 * 
 * @version $Id: 31292fe6ec6dc8ebf4dad168c8bcc3ca6731630f $
 * @since 9.0RC1
 */
public class Namespace
{
    private String type;

    private String value;

    /**
     * @param type the optional type
     * @param value the value
     */
    public Namespace(String type, String value)
    {
        this.type = type;
        this.value = value;
    }

    /**
     * @return the namespace type (can be null)
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * @return the namespace value
     */
    public String getValue()
    {
        return this.value;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) {
            return true;
        }

        if (other instanceof Namespace) {
            return StringUtils.equals(this.type, ((Namespace) other).getType())
                && StringUtils.equals(this.value, ((Namespace) other).getValue());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        HashCodeBuilder builder = new HashCodeBuilder();
        
        builder.append(this.type);
        builder.append(this.value);

        return builder.toHashCode();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        // Type
        if (this.type != null) {
            builder.append(this.type.replace("\\", "\\\\").replace(":", "\\:"));
            builder.append(':');
        }

        // Value
        builder.append(this.value);

        return builder.toString();
    }
}
