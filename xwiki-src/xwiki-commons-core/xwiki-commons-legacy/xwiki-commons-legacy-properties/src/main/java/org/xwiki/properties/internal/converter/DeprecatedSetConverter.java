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

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.properties.converter.AbstractCollectionConverter;

/**
 * @version $Id: 3f6bd2f9adda36e275089268e6a38246bcacb80f $
 * @deprecated since 5.2M1 use {@link SetConverter} instead
 */
@Component(hints = {"java.util.Set", "java.util.LinkedHashSet", "java.util.HashSet" })
@Singleton
@Deprecated
public class DeprecatedSetConverter extends AbstractCollectionConverter
{
    @Override
    protected Collection newCollection()
    {
        return new LinkedHashSet();
    }
}
