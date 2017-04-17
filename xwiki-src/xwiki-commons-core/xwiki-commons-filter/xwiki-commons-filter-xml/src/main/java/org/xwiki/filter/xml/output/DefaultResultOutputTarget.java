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
package org.xwiki.filter.xml.output;

import java.io.IOException;

import javax.xml.transform.Result;

/**
 * Default implementation of {@link ResultOutputTarget}.
 *
 * @version $Id: 5993e3ae8a3913807d80cf746d812414d846afed $
 * @since 6.2M1
 */
public class DefaultResultOutputTarget implements ResultOutputTarget
{
    /**
     * @see #getResult()
     */
    private Result result;

    /**
     * @param result the {@link Result}
     */
    public DefaultResultOutputTarget(Result result)
    {
        this.result = result;
    }

    @Override
    public boolean restartSupported()
    {
        return false;
    }

    @Override
    public Result getResult()
    {
        return this.result;
    }

    @Override
    public void close() throws IOException
    {
        // Source is not closable
    }
}
