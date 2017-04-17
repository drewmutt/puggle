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
package org.xwiki.filter.job;

import java.util.List;

import org.xwiki.job.Request;
import org.xwiki.job.event.JobStartedEvent;
import org.xwiki.observation.event.BeginFoldEvent;

/**
 * Extends {@link JobStartedEvent} to fold events produced during conversion.
 * 
 * @see JobStartedEvent
 * @version $Id: 1a18b234a6ebfac8022bc6ff45068a414b60d14d $
 * @since 8.2RC1
 */
public class FilterConversionStarted extends JobStartedEvent implements BeginFoldEvent
{
    /**
     * @param jobId the event related job unique id
     * @param jobType the event related job type
     * @param request the event related job request
     */
    public FilterConversionStarted(List<String> jobId, String jobType, Request request)
    {
        super(jobId, jobType, request);
    }

}
