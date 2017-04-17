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
 * Indicate to the progress listener to close the current step.
 * <p>
 * The event also send the following parameters:
 * </p>
 * <ul>
 * <li>source: whoever sent the event</li>
 * <li>data: the associated {@link org.xwiki.logging.Message} or null</li>
 * </ul>
 *
 * @version $Id: 59a2806f4394a0533a3cc5a122a09b06b309d326 $
 * @since 7.1M2
 */
public class EndStepProgressEvent extends AbstractProgressEvent
{
    /**
     * Unique instance of {@link EndStepProgressEvent}.
     */
    public static final EndStepProgressEvent INSTANCE = new EndStepProgressEvent();
}
