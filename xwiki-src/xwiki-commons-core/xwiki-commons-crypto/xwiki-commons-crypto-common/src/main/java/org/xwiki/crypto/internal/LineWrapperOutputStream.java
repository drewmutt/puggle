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
package org.xwiki.crypto.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Filter output stream that wraps line after a fixed number of bytes.
 *
 * @version $Id: 23ad749c116f120eb8edaae13da4a292fa792071 $
 * @since 5.4M1
 */
public class LineWrapperOutputStream extends FilterOutputStream
{
    /** New line bytes used to wrap lines. */
    private static final byte[] NEWLINE = System.getProperty("line.separator", "\n").getBytes();

    /** A one byte buffer to optimize one byte writing. */
    private byte[] oneByte = new byte[1];

    /** The count of bytes at which wrapping should occur. */
    private final int wrapAt;

    /** The count of bytes on the last written line. */
    private int count;

    /**
     * Constructs a LineWrapperOutputStream from an OutputStream and a line size.
     *
     * @param outputStream the output stream.
     * @param wrapAt the count of bytes at which wrapping should occur.
     */
    public LineWrapperOutputStream(OutputStream outputStream, int wrapAt)
    {
        super(outputStream);
        this.wrapAt = wrapAt;
        this.count = 0;
    }

    @Override
    public void write(byte[] bytes, int offset, int length) throws IOException
    {
        if ((offset | length | (bytes.length - (length + offset)) | (offset + length)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (length > 0) {
            if (this.count + length >= this.wrapAt) {
                int off = offset;
                int len = length;
                int curlen = this.wrapAt - this.count;
                do {
                    this.out.write(bytes, off, curlen);
                    this.out.write(NEWLINE, 0, NEWLINE.length);
                    off += curlen;
                    len -= curlen;
                    curlen = (len > this.wrapAt) ? this.wrapAt : len;
                } while (curlen == this.wrapAt);
                if (curlen > 0) {
                    this.out.write(bytes, off, curlen);
                }
                this.count = curlen;
            } else {
                this.count += length;
                this.out.write(bytes, offset, length);
            }
        }
    }

    @Override
    public void write(int i) throws IOException
    {
        this.oneByte[0] = (byte) i;
        write(this.oneByte, 0, 1);
    }
}
