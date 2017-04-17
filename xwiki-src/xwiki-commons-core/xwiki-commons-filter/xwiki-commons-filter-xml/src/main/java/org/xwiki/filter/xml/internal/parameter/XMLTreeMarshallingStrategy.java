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

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.core.TreeMarshallingStrategy;
import com.thoughtworks.xstream.core.TreeUnmarshaller;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * Customize {@link TreeMarshallingStrategy}.
 *
 * @version $Id: bd03cb80f335f255a170461ad46685c3e4cba7c9 $
 * @since 5.2M1
 */
public class XMLTreeMarshallingStrategy extends TreeMarshallingStrategy
{
    @Override
    protected XMLTreeMarshaller createMarshallingContext(HierarchicalStreamWriter writer,
        ConverterLookup converterLookup, Mapper mapper)
    {
        return new XMLTreeMarshaller(writer, converterLookup, mapper);
    }

    @Override
    protected TreeUnmarshaller createUnmarshallingContext(Object root, HierarchicalStreamReader reader,
        ConverterLookup converterLookup, Mapper mapper)
    {
        return new XMLTreeUnmarshaller(root, reader, converterLookup, mapper);
    }
}
