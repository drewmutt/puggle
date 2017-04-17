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
package org.xwiki.job.internal.xstream;

import org.junit.Test;
import org.xwiki.logging.LogLevel;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

/**
 * Validate {@link XStreamUtils}.
 * 
 * @version $Id: 8b69f35888e1693a26b52377d150ab48e0b50c26 $
 */
public class XStreamUtilsTest
{
    @Test
    public void testRecursiveObject()
    {
        assertTrue(XStreamUtils.isSafeType(null));
        assertTrue(XStreamUtils.isSafeType("string"));
        assertTrue(XStreamUtils.isSafeType(1));
        assertTrue(XStreamUtils.isSafeType(new Object[] {}));
        assertTrue(XStreamUtils.isSafeType(LogLevel.ERROR));

        assertFalse(XStreamUtils.isSafeType(getClass()));
    }
}
