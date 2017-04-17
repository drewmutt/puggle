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

package org.xwiki.job.event;

import java.io.Serializable;
import java.util.List;

import org.xwiki.job.Request;
import org.xwiki.observation.event.Event;

/**
 * Common interface for job events.
 *
 * @version $Id: 25f6ab9ba7db8bd1c5329e7b09bb6d855d3251fe $
 * @since 4.0M1
 */
public interface JobEvent extends Event, Serializable
{
    /**
     * @return the job id of the source job of this event
     * @since 4.1M2
     */
    List<String> getJobId();

    /**
     * @return the job type of the source job of this event
     */
    String getJobType();

    /**
     * @return the request related to the source job of this event
     */
    Request getRequest();
}
