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
package org.xwiki.job.internal;

import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Test;
import org.xwiki.context.Execution;
import org.xwiki.context.ExecutionContextManager;
import org.xwiki.context.internal.DefaultExecution;
import org.xwiki.context.internal.DefaultExecutionContextManager;
import org.xwiki.job.JobManager;
import org.xwiki.job.JobStatusStore;
import org.xwiki.test.annotation.ComponentList;
import org.xwiki.test.jmock.AbstractMockingComponentTestCase;
import org.xwiki.test.jmock.annotation.MockingRequirement;

/**
 * Unit tests for {@link DefaultJobManager}.
 *
 * @version $Id: 3f87df872e55c9aa69b973d7ecb689e718a52c93 $
 */
@MockingRequirement(value = DefaultJobManager.class, exceptions = { ExecutionContextManager.class, Execution.class })
@ComponentList({
    DefaultExecution.class,
    DefaultExecutionContextManager.class
})
public class DefaultJobManagerTest extends AbstractMockingComponentTestCase<JobManager>
{
    @Test
    public void testGetJobStatusForUnexistingJob() throws Exception
    {
        final List<String> jobId = Arrays.asList("unexisting-job");
        final JobStatusStore jobStatusStorage = getComponentManager().getInstance(JobStatusStore.class);

        getMockery().checking(new Expectations()
        {
            {
                oneOf(jobStatusStorage).getJobStatus(jobId);
                will(returnValue(null));
            }
        });

        Assert.assertNull(getMockedComponent().getJobStatus(jobId));
    }
}
