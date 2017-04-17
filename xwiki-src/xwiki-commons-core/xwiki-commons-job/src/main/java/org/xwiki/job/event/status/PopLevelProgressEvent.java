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
package org.xwiki.job.event.status;

/**
 * Indicate to the progress listener that a new step level is ending.
 * <p>
 * The event also send the following parameters:
 * </p>
 * <ul>
 * <li>source: whoever sent the event</li>
 * <li>data: null</li>
 * </ul>
 * 
 * @version $Id: 9dab8d19c62d68afaf401bebd1e0185b49f66e1c $
 * @since 4.0M1
 */
public class PopLevelProgressEvent extends AbstractProgressEvent
{
    /**
     * Unique instance of {@link PopLevelProgressEvent}.
     * 
     * @since 7.1M2
     */
    public static final PopLevelProgressEvent INSTANCE = new PopLevelProgressEvent();
}
