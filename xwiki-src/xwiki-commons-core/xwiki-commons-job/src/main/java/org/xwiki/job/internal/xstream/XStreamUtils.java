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
package org.xwiki.job.internal.xstream;

import java.util.Arrays;
import java.util.List;

import javax.inject.Provider;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.job.annotation.Serializable;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * Various XStream related utilities.
 *
 * @version $Id: 5227fa72ccc59b0928305a7a64f6a129a91b3442 $
 * @since 5.4M1
 */
public final class XStreamUtils
{
    /**
     * Some famous unserializable classes. Fields with this classes are supposed to be made <code>transient</code> in
     * placed that may end up serialized but never too careful...
     */
    private final static List<Class<?>> UNSERIALIZABLE_CLASSES =
        Arrays.<Class<?>>asList(Logger.class, Provider.class, ComponentManager.class);

    private XStreamUtils()
    {

    }

    /**
     * @param obj the value to check
     * @return true if the type serialization cannot fail
     */
    public static boolean isSafeType(Object obj)
    {
        return obj == null || obj instanceof String || obj instanceof Number || obj.getClass().isArray()
            || obj instanceof Enum;
    }

    /**
     * @param item the item to serialize
     * @return true of the item is serializable
     */
    public static boolean isSerializable(Object item)
    {
        if (item != null) {
            Serializable serializable = item.getClass().getAnnotation(Serializable.class);
            if (serializable != null) {
                return serializable.value();
            } else {
                if (item instanceof java.io.Serializable) {
                    return true;
                }
            }

            if (!item.getClass().isAnnotationPresent(Component.class)) {
                for (Class<?> clazz : UNSERIALIZABLE_CLASSES) {
                    if (clazz.isInstance(item)) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return true;
        }

        return false;
    }

    public static void serializeField(String name, Class<?> defaultType, Object value, HierarchicalStreamWriter writer,
        MarshallingContext context, Mapper mapper)
    {
        if (value != null) {
            // Start node
            writer.startNode(name);

            Class<?> actualType = value.getClass();

            if (actualType != defaultType) {
                String serializedClassName = mapper.serializedClass(actualType);
                String attributeName = mapper.aliasForSystemAttribute("class");
                if (attributeName != null) {
                    writer.addAttribute(attributeName, serializedClassName);
                }
            }

            // Value
            context.convertAnother(value);

            // End node
            writer.endNode();
        }
    }
}
