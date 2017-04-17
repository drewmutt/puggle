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
package org.xwiki.properties.converter;

import java.lang.reflect.Type;

import org.xwiki.component.util.ReflectionUtils;

/**
 * Helper base class for a {@link Converter} component.
 * <p>
 * Commonly a new component is supposed to implements {@link AbstractConverter#convertToString(Object)} and
 * {@link AbstractConverter#convertToType(Class, Object)}.
 *
 * @param <T> the type in which the provided value has to be converted
 * @version $Id: 1ab948f1f76935985bc9d433afff884dfda7650b $
 * @since 2.0M2
 */
public abstract class AbstractConverter<T> implements Converter<T>
{
    @Override
    public <G> G convert(Type targetType, Object sourceValue)
    {
        Class<?> sourceType = sourceValue == null ? null : sourceValue.getClass();

        G result;
        if (targetType.equals(String.class)) {
            // Convert --> String
            result = (G) ((Class) targetType).cast(convertToString((T) sourceValue));
        } else if (targetType.equals(sourceType)) {
            // No conversion necessary
            result = (G) sourceValue;
        } else {
            // Convert --> Type
            result = (G) convertToType(targetType, sourceValue);
        }

        return result;
    }

    /**
     * Convert the input object into a String.
     * <p>
     * <b>N.B.</b>This implementation simply uses the value's <code>toString()</code> method and should be overridden if
     * a more sophisticated mechanism for <i>conversion to a String</i> is required.
     *
     * @param value The input value to be converted.
     * @return the converted String value.
     */
    protected String convertToString(T value)
    {
        return value.toString();
    }

    /**
     * Convert the input object into an output object of the specified type.
     * <p>
     * Typical implementations will provide a minimum of {@code String --> type} conversion.
     *
     * @param <G> the type in which the provided value has o be converted
     * @param targetType Data type to which this value should be converted.
     * @param value The input value to be converted.
     * @return The converted value.
     * @since 3.0M1
     */
    protected <G extends T> G convertToType(Type targetType, Object value)
    {
        Class<G> clazz = ReflectionUtils.getTypeClass(targetType);

        // Call #convertToType(Class<T> type, Object value) for retro-compatibility
        return convertToType(clazz, value);
    }

    /**
     * Convert the input object into an output object of the specified type.
     * <p>
     * Typical implementations will provide a minimum of {@code String --> type} conversion.
     *
     * @param <G> the type in which the provided value has o be converted
     * @param type Data type to which this value should be converted.
     * @param value The input value to be converted.
     * @return The converted value.
     * @deprecated since 3.0M1 overwrite {@link #convertToType(Type, Object)} instead
     */
    @Deprecated
    protected <G extends T> G convertToType(Class<G> type, Object value)
    {
        return convertToType((Type) type, value);
    }
}
