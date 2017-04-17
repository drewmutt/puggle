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
 * Give informations about the progress of a job.
 *
 * @version $Id: 4eb664ecc2cd2f4fb095b8ad2b0a3c7de13f0338 $
 * @since 4.0M1
 */
public interface JobProgress
{
    /**
     * @return global progress between 0 and 1
     */
    double getOffset();

    /**
     * @return progress of the current level between 0 and 1
     */
    double getCurrentLevelOffset();

    /**
     * @return the root step
     * @since 7.1M2
     */
    JobProgressStep getRootStep();

    /**
     * @return the current step
     * @since 7.1M2
     */
    JobProgressStep getCurrentStep();
}
