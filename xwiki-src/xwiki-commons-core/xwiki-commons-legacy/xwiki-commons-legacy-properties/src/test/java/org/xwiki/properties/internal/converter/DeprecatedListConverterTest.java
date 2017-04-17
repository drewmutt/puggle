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
package org.xwiki.properties.internal.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xwiki.properties.converter.Converter;
import org.xwiki.test.jmock.AbstractComponentTestCase;

/**
 * Validate {@link ColorConverter} component.
 * 
 * @version $Id: 39a516c858ce96258537d8f27af627143a8532a5 $
 */
public class DeprecatedListConverterTest extends AbstractComponentTestCase
{
    private Converter listConverter;

    public List<Integer> field1;

    public List<List<Integer>> field2;

    @Before
    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        this.listConverter = getComponentManager().getInstance(Converter.class, List.class.getName());
    }

    @Test
    public void testConvert() throws SecurityException, NoSuchFieldException
    {
        Assert.assertEquals(new ArrayList<String>(Arrays.asList("1", "2", "3")),
            this.listConverter.convert(List.class, "1, 2, 3"));

        Assert.assertEquals(new ArrayList<String>(Arrays.asList("1", "\n", "2", "\n", "3")),
            this.listConverter.convert(List.class, "1,\n 2,\n 3"));

        Assert.assertEquals(
            new ArrayList<Integer>(Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))),
            this.listConverter.convert(DeprecatedListConverterTest.class.getField("field1").getGenericType(), "1, 2, 3"));

        Assert.assertEquals(new ArrayList(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))),
            this.listConverter.convert(DeprecatedListConverterTest.class.getField("field2").getGenericType(),
                "'\\'1\\', 2, 3', \"4, 5, 6\""));

        Assert.assertEquals(new ArrayList<String>(Arrays.asList("1:2")), this.listConverter.convert(List.class, "1:2"));
    }
}
