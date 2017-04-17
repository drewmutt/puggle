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
package org.xwiki.properties.internal.converter;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.properties.converter.collection.AbstractCollectionConverter;

/**
 * @version $Id: b0051601caf8c8651e7bdea3b9b6540063213c08 $
 * @since 5.2M1
 */
@Component
@Singleton
public class ArrayListConverter extends AbstractCollectionConverter<ArrayList>
{
    @Override
    protected <G extends ArrayList> G convertToType(Type targetType, Object value)
    {
        if (value instanceof ArrayList) {
            return (G) value;
        }

        return super.convertToType(targetType, value);
    }
}
