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

import java.awt.Color;
import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.properties.converter.Converter;

/**
 * Converter that converts a value into an {@link Color} object.
 * 
 * @version $Id: b95945587af65100b8ba0f43bfbc62d0a6b0ffa8 $
 * @since 2.0M2
 * @deprecated since 5.2M use {@link ColorConverter} instead
 */
@Component
@Named("java.awt.Color")
@Singleton
@Deprecated
public class DeprecatedColorConverter implements Converter
{
    /**
     * The actual converter.
     */
    @Inject
    private Converter<Color> converter;

    @Override
    public Object convert(Type targetType, Object sourceValue)
    {
        return this.converter.convert(targetType, sourceValue);
    }
}
