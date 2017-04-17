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
package org.xwiki.filter.event.extension;

import org.xwiki.filter.FilterEventParameters;
import org.xwiki.filter.FilterException;
import org.xwiki.filter.annotation.Default;

/**
 * Extension related events.
 *
 * @version $Id: 2a582732c58d2285b885d33efaee9eca7eb3a6d9 $
 * @since 6.2M1
 */
public interface ExtensionFilter
{
    // Properties

    // Events

    /**
     * @param name the name of the namespace
     * @param parameters the parameters of the namespace
     * @throws FilterException when failing to send event
     */
    void beginNamespace(String name, @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters)
        throws FilterException;

    /**
     * @param name the name of the namespace
     * @param parameters the parameters of the namespace
     * @throws FilterException when failing to send event
     */
    void endNamespace(String name, @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters)
        throws FilterException;

    /**
     * @param id the id of the extension
     * @param version the version of the extension
     * @param parameters the parameters of the extension
     * @throws FilterException when failing to send event
     */
    void beginExtension(String id, String version,
        @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters) throws FilterException;

    /**
     * @param id the id of the extension
     * @param version the version of the extension
     * @param parameters the parameters of the extension
     * @throws FilterException when failing to send event
     */
    void endExtension(String id, String version,
        @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters) throws FilterException;
}
