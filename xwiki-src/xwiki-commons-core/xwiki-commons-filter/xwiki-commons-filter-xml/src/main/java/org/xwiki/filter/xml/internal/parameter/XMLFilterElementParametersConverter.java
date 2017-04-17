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
package org.xwiki.filter.xml.internal.parameter;

import org.xwiki.filter.FilterEventParameters;

import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * XML converter for {@link FilterEventParameters}.
 *
 * @version $Id: fde8806003c84148fa1629d7d5830d9b72a2d8c2 $
 * @since 5.2M2
 */
public class XMLFilterElementParametersConverter extends MapConverter
{
    /**
     * @param mapper the mapper
     */
    public XMLFilterElementParametersConverter(Mapper mapper)
    {
        super(mapper);
    }

    @Override
    public boolean canConvert(Class type)
    {
        return type.equals(FilterEventParameters.class);
    }

    @Override
    protected Object createCollection(Class type)
    {
        return new FilterEventParameters();
    }
}
