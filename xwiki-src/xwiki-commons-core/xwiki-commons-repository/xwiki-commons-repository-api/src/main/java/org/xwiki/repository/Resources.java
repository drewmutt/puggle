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
package org.xwiki.repository;

/**
 * Resources to use to access Extension Manager REST service.
 *
 * @version $Id: 7e8ef4e5ffbf9c0cda6fb0ac7612c199bf00f591 $
 * @since 4.2M1
 */
public interface Resources
{
    /**
     * Version 1.0 of the protocol.
     * @since 7.0M2
     */
    String VERSION10 = "1.0";

    /**
     * Version 1.1 of the protocol.
     * @since 7.0M2
     */
    String VERSION11 = "1.1";

    /**
     * Version 1.2 of the protocol.
     * @since 8.3RC1
     */
    String VERSION12 = "1.2";

    // Entry point

    /**
     * Entry point of XWiki Repository protocol.
     */
    /**
     * 
     */
    String ENTRYPOINT = "/repository";

    // Path parameters

    /**
     * Name of the parameter indication the id of the extension.
     */
    String PPARAM_EXTENSIONID = "extensionId";

    /**
     * Name of the parameter indication the version of the extension.
     */
    String PPARAM_EXTENSIONVERSION = "extensionVersion";

    // Extensions

    /**
     * Get extensions.
     */
    String EXTENSIONS = ENTRYPOINT + "/extensions";

    /**
     * Get extension informations.
     */
    String EXTENSION = EXTENSIONS + '/' + '{' + PPARAM_EXTENSIONID + '}';

    /**
     * Get extension versions.
     */
    String EXTENSION_VERSIONS = EXTENSION + "/versions";

    /**
     * Get extension version informations.
     */
    String EXTENSION_VERSION = EXTENSION_VERSIONS + '/' + '{' + PPARAM_EXTENSIONVERSION + '}';

    /**
     * Download extension file.
     */
    String EXTENSION_VERSION_FILE = EXTENSION_VERSION + "/file";

    // Search

    /**
     * Execute search query among extensions.
     */
    String SEARCH = ENTRYPOINT + "/search";

    // Query parameters

    /**
     * Language of the result to produce.
     */
    String QPARAM_LANGUAGE = "language";

    /**
     * Used to indicate versions ranges to filter versions request.
     */
    String QPARAM_VERSIONS_RANGES = "versionRanges";

    /**
     * The search query.
     */
    String QPARAM_SEARCH_QUERY = "q";

    /**
     * Offset from where the search start to return results.
     */
    String QPARAM_LIST_START = "start";

    /**
     * Indicate if we want to get the total number of possible result without limits in the result. Allow to speed up a
     * bit the query when we don't care since it generally mean one more query on server side.
     */
    String QPARAM_LIST_REQUIRETOTALHITS = "requireTotalHits";

    /**
     * Maximum number of results.
     */
    String QPARAM_LIST_NUMBER = "number";
}
