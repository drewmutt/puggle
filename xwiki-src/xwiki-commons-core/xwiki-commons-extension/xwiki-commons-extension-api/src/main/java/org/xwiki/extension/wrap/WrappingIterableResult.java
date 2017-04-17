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
package org.xwiki.extension.wrap;

import java.util.Iterator;

import org.xwiki.extension.Extension;
import org.xwiki.extension.repository.result.IterableResult;
import org.xwiki.script.internal.safe.AbstractSafeObject;
import org.xwiki.script.internal.safe.ScriptSafeProvider;

/**
 * Provide a public script access to a iterable result.
 *
 * @param <E> the extension type
 * @version $Id: b83b4a300bacdfdffe1c1a35283666fa3b896954 $
 * @since 4.0M2
 */
public class WrappingIterableResult<E extends Extension> extends AbstractSafeObject<IterableResult<E>> implements
    IterableResult<E>
{
    /**
     * @param result the wrapped result
     * @param safeProvider the provider of instances safe for public scripts
     */
    public WrappingIterableResult(IterableResult<E> result, ScriptSafeProvider<?> safeProvider)
    {
        super(result, safeProvider);
    }

    @Override
    public Iterator<E> iterator()
    {
        return getWrapped().iterator();
    }

    @Override
    public int getTotalHits()
    {
        return getWrapped().getTotalHits();
    }

    @Override
    public int getOffset()
    {
        return getWrapped().getOffset();
    }

    @Override
    public int getSize()
    {
        return getWrapped().getSize();
    }

}
