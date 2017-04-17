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
package org.xwiki.diff.display;

import java.util.ArrayList;

/**
 * Represents a list of {@link UnifiedDiffElement}s that share the same context. The context is defined based on the
 * distance between changes. Changes that are close to each other are grouped in a single block. A block can contain
 * both added and removed elements. Blocks also contain unmodified elements that put changes in context.
 *
 * @param <E> the type of elements that are compared to produce the first level diff
 * @param <F> the type of sub-element that are compared to produce the second level diff
 * @version $Id: 0f7fdf1cab8e970df67f1f66cdd9647c50104aec $
 * @since 4.1RC1
 */
public class UnifiedDiffBlock<E, F> extends ArrayList<UnifiedDiffElement<E, F>>
{
    /**
     * Needed for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the index where this block starts in the previous version; since blocks are most of the time not empty,
     *         the returned value is the index of the first unmodified or removed element in this group
     */
    public int getPreviousStart()
    {
        for (UnifiedDiffElement<E, F> element : this) {
            if (!element.isAdded()) {
                return element.getIndex();
            }
        }
        return 0;
    }

    /**
     * @return the size of this block (number of elements) in the previous version; unmodified elements and elements
     *         marked as removed are counted only
     */
    public int getPreviousSize()
    {
        int size = 0;
        for (UnifiedDiffElement<E, F> element : this) {
            if (!element.isAdded()) {
                size++;
            }
        }
        return size;
    }

    /**
     * @return the index where this block starts in the next version; since blocks are most of the time not empty, the
     *         returned value is the index of the first unmodified or added element in this group
     */
    public int getNextStart()
    {
        for (UnifiedDiffElement<E, F> element : this) {
            if (!element.isDeleted()) {
                return element.getIndex();
            }
        }
        return 0;
    }

    /**
     * @return the size of this block (number of elements) in the next version; unmodified elements and elements marked
     *         as added are counted only
     */
    public int getNextSize()
    {
        int size = 0;
        for (UnifiedDiffElement<E, F> element : this) {
            if (!element.isDeleted()) {
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        // The element index is 0-based so we add 1 for display.
        stringBuilder.append(String.format("@@ -%s,%s +%s,%s @@\n", getPreviousStart() + 1, getPreviousSize(),
            getNextStart() + 1, getNextSize()));
        for (UnifiedDiffElement<E, F> element : this) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }
}
