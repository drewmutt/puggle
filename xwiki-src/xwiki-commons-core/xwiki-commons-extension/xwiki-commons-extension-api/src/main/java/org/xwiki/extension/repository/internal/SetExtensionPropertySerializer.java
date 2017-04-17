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
package org.xwiki.extension.repository.internal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Serialize and unserialize {@link Set} properties.
 *
 * @version $Id: 826e6d285c659a5e664ec58ce33b0e01635f2fea $
 */
public class SetExtensionPropertySerializer extends CollectionExtensionPropertySerializer<Set>
{
    /**
     * @param serializerById the serializers by type id
     * @param serializerByClass the serializers by class
     */
    public SetExtensionPropertySerializer(Map<String, ExtensionPropertySerializer> serializerById,
        Map<Class<?>, ExtensionPropertySerializer> serializerByClass)
    {
        super("set", serializerById, serializerByClass);
    }

    /**
     * @return a new collection
     */
    @Override
    protected Set createCollection()
    {
        return new HashSet();
    }
}
