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
import java.util.Set;

import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.properties.converter.collection.AbstractSetConverter;

/**
 * @version $Id: 55ce1656dd589d1cf887c9bc8f0f3ba96f8efeea $
 * @since 5.2M1
 */
@Component
@Singleton
public class SetConverter extends AbstractSetConverter<Set>
{
    @Override
    protected <G extends Set> G convertToType(Type targetType, Object value)
    {
        if (value instanceof Set) {
            return (G) value;
        }

        return super.convertToType(targetType, value);
    }
}
