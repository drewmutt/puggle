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
package org.xwiki.filter;

import org.xwiki.properties.annotation.PropertyDescription;
import org.xwiki.properties.annotation.PropertyName;

/**
 * Properties common to most streams.
 *
 * @version $Id: 8237d45e41f73be3486f1c48d1f6228d662f947d $
 * @since 6.2M1
 */
public interface FilterStreamProperties
{
    /**
     * The {@link String} name of the <code>verbose</code> property.
     *
     * @since 6.2M1
     */
    String PROPNAME_VERBOSE = "verbose";

    /**
     * @return true if the stream should log details of what is happening
     */
    @PropertyName("Verbose")
    @PropertyDescription("Indicates if the stream should log details of what is happening")
    boolean isVerbose();

    /**
     * @param verbose true if the stream should log details of what is happening
     */
    void setVerbose(boolean verbose);
}
