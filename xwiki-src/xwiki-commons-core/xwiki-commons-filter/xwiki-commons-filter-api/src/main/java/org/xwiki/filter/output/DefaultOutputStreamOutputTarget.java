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
package org.xwiki.filter.output;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @version $Id: 649422255fad3bb48a72599affa2743aacb43671 $
 * @since 6.2M1
 */
public class DefaultOutputStreamOutputTarget implements OutputStreamOutputTarget
{
    private final boolean close;

    private final OutputStream outputStream;

    /**
     * Create an instance of {@link OutputStreamOutputTarget} returning the passed {@link OutputStream}.
     * <p>
     * The passed {@link OutputStream} is not closed when the {@link OutputTarget} is closed.
     *
     * @param outputStream the {@link OutputStream}
     */
    public DefaultOutputStreamOutputTarget(OutputStream outputStream)
    {
        this(outputStream, false);
    }

    /**
     * Create an instance of {@link OutputStreamOutputTarget} returning the passed {@link OutputStream}.
     *
     * @param outputStream the {@link OutputStream}
     * @param close indicate of the passer {@link OutputStream} should be closed when the {@link OutputTarget} is closed
     * @since 6.2M1
     */
    public DefaultOutputStreamOutputTarget(OutputStream outputStream, boolean close)
    {
        this.outputStream = outputStream;
        this.close = close;
    }

    @Override
    public boolean restartSupported()
    {
        return false;
    }

    @Override
    public OutputStream getOutputStream()
    {
        return this.outputStream;
    }

    @Override
    public void close() throws IOException
    {
        if (this.close) {
            this.outputStream.close();
        }
    }

    @Override
    public String toString()
    {
        return this.outputStream.toString();
    }
}
