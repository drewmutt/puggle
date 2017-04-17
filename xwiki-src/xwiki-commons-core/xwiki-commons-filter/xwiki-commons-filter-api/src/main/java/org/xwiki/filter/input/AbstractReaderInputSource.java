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
package org.xwiki.filter.input;

import java.io.IOException;
import java.io.Reader;

/**
 * @version $Id: 1347a52039b3351396f035e93b3bdbb897b08e12 $
 * @since 6.2M1
 */
public abstract class AbstractReaderInputSource implements ReaderInputSource
{
    private Reader reader;

    @Override
    public boolean restartSupported()
    {
        return true;
    }

    @Override
    public Reader getReader()
    {
        if (this.reader == null) {
            this.reader = openReader();
        }

        return this.reader;
    }

    protected abstract Reader openReader();

    @Override
    public void close() throws IOException
    {
        if (this.reader != null) {
            this.reader.close();
        }
        this.reader = null;
    }
}
