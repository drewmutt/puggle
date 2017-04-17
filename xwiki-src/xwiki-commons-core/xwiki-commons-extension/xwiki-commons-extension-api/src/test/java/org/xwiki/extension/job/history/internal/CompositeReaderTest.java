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
package org.xwiki.extension.job.history.internal;

import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link CompositeReader}.
 * 
 * @version $Id: 4dd4f204f2c73c8708be2a62c4b5a9f78f7beec1 $
 * @since 7.1RC1
 */
public class CompositeReaderTest
{
    @Test
    public void readOK() throws Exception
    {
        assertEquals("oneTwo", IOUtils.toString(new CompositeReader(new StringReader("one"), new StringReader("Two"))));
    }

    @Test
    public void closeAll() throws Exception
    {
        Reader first = mock(Reader.class, "first");
        Reader second = mock(Reader.class, "second");
        new CompositeReader(first, second).close();

        verify(first).close();
        verify(second).close();
    }
}
