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
import java.io.Writer;

/**
 * @version $Id: eb5ff7bff266f789b807626936d71094a405e7fc $
 * @since 6.2M1
 */
public abstract class AbstractWriterOutputTarget implements WriterOutputTarget
{
    protected Writer writer;

    protected abstract Writer openWriter();

    @Override
    public boolean restartSupported()
    {
        return true;
    }

    @Override
    public Writer getWriter()
    {
        if (this.writer == null) {
            this.writer = openWriter();
        }

        return this.writer;
    }

    @Override
    public void close() throws IOException
    {
        if (this.writer != null) {
            this.writer.close();
        }
        this.writer = null;
    }

    @Override
    public String toString()
    {
        return this.writer != null ? this.writer.toString() : "";
    }
}
