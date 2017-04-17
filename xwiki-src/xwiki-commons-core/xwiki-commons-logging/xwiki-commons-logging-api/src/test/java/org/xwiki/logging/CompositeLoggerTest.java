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
package org.xwiki.logging;

import org.junit.Assert;
import org.junit.Test;
import org.xwiki.logging.test.Utils;

/**
 * Test {@link CompositeLogger}.
 *
 * @version $Id: 1b784e4fe61a5cf5768b60ea7dba351739b4f0b5 $
 */
public class CompositeLoggerTest
{
    @Test
    public void test()
    {
        LogTree logTree = new LogTree();
        LogQueue logQueue = new LogQueue();

        Logger logger = new CompositeLogger(logQueue, logTree);

        Assert.assertTrue(logger.isTraceEnabled());
        Assert.assertTrue(logger.isDebugEnabled());
        Assert.assertTrue(logger.isInfoEnabled());
        Assert.assertTrue(logger.isWarnEnabled());
        Assert.assertTrue(logger.isErrorEnabled());

        Utils.populateLogger(logger);

        Utils.validateLogger(logQueue.iterator());
        Utils.validateLogger(logTree.iterator(true));
    }
}
