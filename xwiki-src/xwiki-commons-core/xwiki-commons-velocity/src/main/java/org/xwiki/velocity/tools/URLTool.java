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
package org.xwiki.velocity.tools;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/**
 * Velocity tool to parse URL parts.
 * 
 * @version $Id: dbbb6644b7c0f267c556a8c7857ae21b02f4c0f7 $
 * @since 6.3M1
 */
public class URLTool
{
    /**
     * Parse a query string into a map of key-value pairs.
     * 
     * @param query query string to be parsed
     * @return a mapping of parameter names to values suitable e.g. to pass into {@link EscapeTool#url(Map)}
     */
    public Map<String, List<String>> parseQuery(String query)
    {
        Map<String, List<String>> queryParams = new LinkedHashMap<>();
        if (query != null) {
            for (NameValuePair params : URLEncodedUtils.parse(query, StandardCharsets.UTF_8)) {
                String name = params.getName();
                List<String> values = queryParams.get(name);
                if (values == null) {
                    values = new ArrayList<>();
                    queryParams.put(name, values);
                }
                values.add(params.getValue());
            }
        }
        return queryParams;
    }
}
