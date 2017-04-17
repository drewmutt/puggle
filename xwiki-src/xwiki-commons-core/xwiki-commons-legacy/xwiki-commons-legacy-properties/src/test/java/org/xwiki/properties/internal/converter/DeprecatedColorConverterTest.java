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

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xwiki.properties.converter.ConversionException;
import org.xwiki.properties.converter.Converter;
import org.xwiki.test.jmock.AbstractComponentTestCase;

/**
 * Validate {@link ColorConverter} component.
 * 
 * @version $Id: 3629857218471df5885012278a8776b359759763 $
 */
public class DeprecatedColorConverterTest extends AbstractComponentTestCase
{
    private Converter colorConverter;

    @Before
    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        this.colorConverter = getComponentManager().getInstance(Converter.class, Color.class.getName());
    }

    @Test
    public void testConvertRGB()
    {
        Assert.assertEquals(Color.WHITE, this.colorConverter.convert(Color.class, "255 , 255 , 255"));
    }

    @Test
    public void testConvertHTML()
    {
        Assert.assertEquals(Color.WHITE, this.colorConverter.convert(Color.class, "#ffffff"));
        Assert.assertEquals(Color.WHITE, this.colorConverter.convert(Color.class, "#FFFFFF"));
    }

    @Test
    public void testConvertInvalid()
    {
        try {
            Assert.assertEquals(Color.WHITE, this.colorConverter.convert(Color.class, "wrongformat"));
            Assert.fail("Should have thrown a ConversionException exception");
        } catch (ConversionException expected) {
            // expected
        }
    }
}
