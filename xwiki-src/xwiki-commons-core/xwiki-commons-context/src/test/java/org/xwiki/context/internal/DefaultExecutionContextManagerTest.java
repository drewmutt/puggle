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
package org.xwiki.context.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Provider;

import org.junit.Assert;
import org.junit.Test;
import org.xwiki.component.util.ReflectionUtils;
import org.xwiki.context.Execution;
import org.xwiki.context.ExecutionContext;
import org.xwiki.context.ExecutionContextException;
import org.xwiki.context.ExecutionContextInitializer;

/**
 * Unit tests for {@link ExecutionContext}.
 *
 * @version $Id: 4af95be4ed02cb2b10f6754891c865a2bb22641f $
 * @since 1.8RC3
 */
@SuppressWarnings("unchecked")
public class DefaultExecutionContextManagerTest
{
    /**
     * Verify we have different objects in the Execution Context after the clone.
     */
    @Test
    public void cloneExecutionContext() throws Exception
    {
        Execution execution = new DefaultExecution();
        ExecutionContext context = new ExecutionContext();
        execution.setContext(context);

        Map<Object, Object> xwikicontext = new HashMap<>();
        context.newProperty("property1").initial(xwikicontext).inherited().declare();
        context.newProperty("property2").initial(xwikicontext).inherited().makeFinal().cloneValue().declare();

        DefaultExecutionContextManager contextManager = new DefaultExecutionContextManager();
        ReflectionUtils.setFieldValue(contextManager, "execution", execution);

        // Set up an Execution Context Initiliazer for the test
        final ExecutionContextInitializer initializer = new ExecutionContextInitializer()
        {
            @Override
            public void initialize(ExecutionContext context) throws ExecutionContextException
            {
                context.setProperty("key", Arrays.asList("value"));
            }
        };
        Provider<List<ExecutionContextInitializer>> provider = new Provider<List<ExecutionContextInitializer>>()
        {
            @Override
            public List<ExecutionContextInitializer> get()
            {
                return Arrays.asList(initializer);
            }
        };
        ReflectionUtils.setFieldValue(contextManager, "initializerProvider", provider);

        ExecutionContext clonedContext = contextManager.clone(context);

        Assert.assertSame(context, execution.getContext());
        Assert.assertEquals("value", ((List<String>) clonedContext.getProperty("key")).get(0));
        Assert.assertNotSame(context.getProperty("key"), clonedContext.getProperty("key"));
        Assert.assertSame(xwikicontext, clonedContext.getProperty("property1"));
        Assert.assertNotSame(xwikicontext, clonedContext.getProperty("property2"));
    }
}
