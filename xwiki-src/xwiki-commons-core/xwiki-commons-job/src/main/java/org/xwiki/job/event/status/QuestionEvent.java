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

import java.util.List;

import org.xwiki.observation.event.Event;

/**
 * Common interface for job question events.
 * 
 * @version $Id: fa332b267517a12d979d7c1650b4c709cf0b4640 $
 * @since 7.1RC1
 */
public interface QuestionEvent extends Event
{
    /**
     * @return the type of question that can trigger this event
     */
    String getQuestionType();

    /**
     * @return the id of the job that raised the question
     */
    List<String> getJobId();
}
