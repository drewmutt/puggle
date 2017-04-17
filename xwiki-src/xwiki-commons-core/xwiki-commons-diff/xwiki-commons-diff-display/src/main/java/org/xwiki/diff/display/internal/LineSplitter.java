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
package org.xwiki.diff.display.internal;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.commons.io.IOUtils;
import org.xwiki.component.annotation.Component;
import org.xwiki.diff.display.Splitter;

/**
 * Splits a text into multiple lines.
 *
 * @version $Id: 394e7cd8c4f6390a1c4b7fd3076dfb0dd9ebdfc5 $
 * @since 4.1RC1
 */
@Component
@Named("line")
@Singleton
public class LineSplitter implements Splitter<String, String>
{
    @Override
    public List<String> split(String composite)
    {
        try {
            return composite == null ? Collections.<String>emptyList() : IOUtils.readLines(new StringReader(composite));
        } catch (IOException e) {
            throw new RuntimeException("Failed to split lines.", e);
        }
    }
}
