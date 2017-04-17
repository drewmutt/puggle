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
package org.xwiki.velocity.tools;

import java.text.DateFormatSymbols;
import java.util.Locale;

/**
 * Extends the default DateTool from velocity-tools with some useful methods.
 * 
 * @version $Id: 24f59c254a90f04b36de08f2f944103111dfd147 $
 * @since 6.2.6
 * @since 6.4.2
 * @since 7.0M2
 */
public class ComparisonDateTool extends org.apache.velocity.tools.generic.ComparisonDateTool
{
    /**
     * @param locale a locale object
     * @return the {@link DateFormatSymbols} instance corresponding to the given locale
     */
    public DateFormatSymbols getDateFormatSymbols(Locale locale)
    {
        return DateFormatSymbols.getInstance(locale);
    }
}
