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
package org.xwiki.extension.repository.search;

import org.xwiki.extension.Extension;
import org.xwiki.extension.repository.result.IterableResult;

/**
 * A repository can implements it to provide search capabilities.
 * 
 * @version $Id: cdf5121251ceb3b2f86903df0adc46c33447546c $
 * @since 7.0M2
 */
public interface AdvancedSearchable extends Searchable
{
    /**
     * @return true if the searched extensions can be filtered
     */
    boolean isFilterable();

    /**
     * @return true if the searched extensions can be ordered
     */
    boolean isSortable();

    /**
     * Search extension based of the provided query.
     * 
     * @param query the query
     * @return the found extensions descriptors, empty list if nothing could be found
     * @throws SearchException error when trying to search provided query
     */
    IterableResult<Extension> search(ExtensionQuery query) throws SearchException;
}
