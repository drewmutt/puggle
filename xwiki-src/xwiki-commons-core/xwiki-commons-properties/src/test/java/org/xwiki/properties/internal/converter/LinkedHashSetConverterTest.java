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

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xwiki.properties.ConverterManager;
import org.xwiki.test.jmock.AbstractComponentTestCase;

/**
 * Validate {@link LinkedHashSetConverter} component.
 *
 * @version $Id: 0bccc6b37e90977e4d011397033f841aa7a6a433 $
 */
public class LinkedHashSetConverterTest extends AbstractComponentTestCase
{
    private ConverterManager converterManager;

    @Before
    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        this.converterManager = getComponentManager().getInstance(ConverterManager.class);
    }

    @Test
    public void testConvertToString()
    {
        Assert.assertEquals("1, 2, 3",
            this.converterManager.convert(String.class, new LinkedHashSet<String>(Arrays.asList("1", "2", "3"))));
    }

    @Test
    public void testConvertFromLinkedHashSet()
    {
        HashSet<String> expect = new LinkedHashSet<String>(Arrays.asList("1", "2", "3"));

        Assert.assertSame(expect, this.converterManager.convert(LinkedHashSet.class, expect));
    }
}
