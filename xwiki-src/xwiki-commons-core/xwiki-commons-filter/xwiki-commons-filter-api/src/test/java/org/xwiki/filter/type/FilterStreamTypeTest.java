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
package org.xwiki.filter.type;

import org.junit.Assert;
import org.junit.Test;

/**
 * Validate {@link FilterStreamType}.
 *
 * @version $Id: f815073336ad5f44758f8e302d7c5c561017708c $
 */
public class FilterStreamTypeTest
{
    // Tests

    @Test
    public void testSerializeWithDataAndVersion()
    {
        FilterStreamType type = new FilterStreamType(new SystemType("type"), "data", "version");

        Assert.assertEquals("type+data/version", type.serialize());
    }

    @Test
    public void testUnserializeWithDataAndVersion()
    {
        FilterStreamType type = FilterStreamType.unserialize("type+data/version");

        Assert.assertEquals("type", type.getType().getId());
        Assert.assertEquals("data", type.getDataFormat());
        Assert.assertEquals("version", type.getVersion());
    }

    @Test
    public void testUnserializeWithData()
    {
        FilterStreamType type = FilterStreamType.unserialize("type+data");

        Assert.assertEquals("type", type.getType().getId());
        Assert.assertEquals("data", type.getDataFormat());
        Assert.assertNull(type.getVersion());
    }

    @Test
    public void testUnserializeWithEmptyData()
    {
        FilterStreamType type = FilterStreamType.unserialize("type+");

        Assert.assertEquals("type", type.getType().getId());
        Assert.assertEquals("", type.getDataFormat());
        Assert.assertNull(type.getVersion());
    }

    @Test
    public void testUnserializeWithVersion()
    {
        FilterStreamType type = FilterStreamType.unserialize("type/version");

        Assert.assertEquals("type", type.getType().getId());
        Assert.assertNull(type.getDataFormat());
        Assert.assertEquals("version", type.getVersion());
    }

    @Test
    public void testUnserializeWithEmptyVersion()
    {
        FilterStreamType type = FilterStreamType.unserialize("type/");

        Assert.assertEquals("type", type.getType().getId());
        Assert.assertNull(type.getDataFormat());
        Assert.assertEquals("", type.getVersion());
    }
}
