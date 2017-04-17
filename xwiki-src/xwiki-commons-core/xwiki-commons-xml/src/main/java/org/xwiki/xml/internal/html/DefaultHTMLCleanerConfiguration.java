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
package org.xwiki.xml.internal.html;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.xwiki.xml.html.HTMLCleanerConfiguration;
import org.xwiki.xml.html.filter.HTMLFilter;

/**
 * Default and basic implementation used by the {@link DefaultHTMLCleaner} implementation.
 *
 * @version $Id: 4fb589b23a598672193ce62135055f31604db3fe $
 * @since 1.8.1
 */
public class DefaultHTMLCleanerConfiguration implements HTMLCleanerConfiguration
{
    /**
     * Ordered list of filters to apply in that order.
     */
    private List<HTMLFilter> filters = Collections.emptyList();

    /**
     * Parameters to apply for the cleaning.
     */
    private Map<String, String> parameters = Collections.emptyMap();

    @Override
    public List<HTMLFilter> getFilters()
    {
        return this.filters;
    }

    @Override
    public Map<String, String> getParameters()
    {
        return this.parameters;
    }

    @Override
    public void setFilters(List<HTMLFilter> filters)
    {
        this.filters = filters;
    }

    @Override
    public void setParameters(Map<String, String> parameters)
    {
        this.parameters = parameters;
    }
}
