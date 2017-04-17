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
package org.xwiki.filter;

import org.xwiki.filter.annotation.Default;

/**
 * Unknown elements related events.
 *
 * @version $Id: 0c6ac8f099e721dc058962dc03a20f1f8d13cab1 $
 * @since 5.2M1
 */
public interface UnknownFilter
{
    /**
     * The identifier of the unknown events.
     */
    String FILTER_ELEMENT_ID = "unknown";

    /**
     * @param id the id of the event
     * @param parameters the data of the event
     * @exception FilterException when an error occurs after sending the event
     */
    void beginUnknwon(String id, @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters)
        throws FilterException;

    /**
     * @param id the id of the event
     * @param parameters the data of the event
     * @exception FilterException when an error occurs after sending the event
     */
    void endUnknwon(String id, @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters)
        throws FilterException;

    /**
     * @param id the id of the event
     * @param parameters the data of the event
     * @exception FilterException when an error occurs after sending the event
     */
    void onUnknwon(String id, @Default(FilterEventParameters.DEFAULT) FilterEventParameters parameters)
        throws FilterException;
}
