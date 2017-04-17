package org.xwiki.filter.test.integration;
import org.junit.Assert;
import org.junit.Test;
import org.xwiki.filter.test.integration.TestDataParser;

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

public class TestDataParserTest
{
    @Test
    public void testInterpret()
    {
        System.setProperty("key", "value");

        Assert.assertEquals("test", TestDataParser.interpret("test"));
        Assert.assertEquals("value", TestDataParser.interpret("${{{key}}}"));
        Assert.assertEquals("testvaluetest", TestDataParser.interpret("test${{{key}}}test"));
        Assert.assertEquals("test${{{key}}}", TestDataParser.interpret("test\\${{{key}}}"));
    }
}
