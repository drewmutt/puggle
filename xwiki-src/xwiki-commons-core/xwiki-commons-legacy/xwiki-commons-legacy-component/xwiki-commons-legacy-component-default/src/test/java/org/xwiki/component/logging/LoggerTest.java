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
package org.xwiki.component.logging;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link org.xwiki.component.logging.AbstractLogEnabled}.
 * 
 * @version $Id: 070c93ca35dc2ef5dcbf78738a347321be8388db $
 * @since 1.8RC3
 * @deprecated starting with 3.1M2 use {@link javax.inject.Inject} annotation to get injected a SLF4J Logger instead
 */
@Deprecated
public class LoggerTest
{
    @Test
    public void testDefaultVoidLogger()
    {
        AbstractLogEnabled component = new AbstractLogEnabled() {};
        Assert.assertEquals(VoidLogger.class.getName(), component.getLogger().getClass().getName());
    }
}
