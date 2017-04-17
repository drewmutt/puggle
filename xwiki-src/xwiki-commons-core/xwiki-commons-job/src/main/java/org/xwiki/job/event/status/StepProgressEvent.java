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
 * Indicate to the progress listener that a new step is starting.
 * <p>
 * The event also send the following parameters:
 * </p>
 * <ul>
 * <li>source: whoever sent the event</li>
 * <li>data: null</li>
 * </ul>
 *
 * @version $Id: e46dc9ad59a28d045b75accc5416735675b16ef3 $
 * @since 4.0M1
 * @deprecated since 7.1M2, use {@link StartStepProgressEvent} instead
 */
@Deprecated
public class StepProgressEvent extends AbstractProgressEvent
{
    /**
     * Unique instance of {@link StepProgressEvent}.
     * 
     * @since 7.1M2
     */
    public static final StepProgressEvent INSTANCE = new StepProgressEvent();
}
