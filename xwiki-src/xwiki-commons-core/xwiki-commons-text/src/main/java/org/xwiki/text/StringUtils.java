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
package org.xwiki.text;

/**
 * Extends {@link org.apache.commons.lang3.StringUtils} with some more useful tools.
 * 
 * @version $Id: eb7bbcaf336c6f791fdce502b7443f350229e2ae $
 * @since 6.2
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils
{
    /**
     * An attempt to make doubling a character (usually for escaping purposes) as fast as it can be. A lot faster than
     * the usual <code>mystring.replace("a", "aa")</code> for example.
     * 
     * @param str the string to modify
     * @param c the character to double
     * @return the modified string
     */
    public static String doubleChar(final String str, final char c)
    {
        if (isEmpty(str)) {
            return str;
        }

        int start = 0;
        int end = str.indexOf(c, start);
        if (end == INDEX_NOT_FOUND) {
            return str;
        }

        final StringBuilder buf = new StringBuilder(str.length() + 1);

        do {
            end += 1;
            buf.append(str.substring(start, end)).append(c);

            start = end;
            end = str.indexOf(c, start);
        } while (end != INDEX_NOT_FOUND);

        buf.append(str.substring(start));

        return buf.toString();
    }
}
