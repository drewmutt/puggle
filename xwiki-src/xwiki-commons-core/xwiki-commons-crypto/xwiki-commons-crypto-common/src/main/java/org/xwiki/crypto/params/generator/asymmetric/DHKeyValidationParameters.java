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
package org.xwiki.crypto.params.generator.asymmetric;

/**
 * Validation parameters for DH key.
 *
 * @version $Id: dbfcc0ff9e1a9d77bc3dbe8ca9eb52ac5e8ee992 $
 * @since 5.4M1
 */
public class DHKeyValidationParameters
{
    private final int counter;

    private final byte[] seed;

    /**
     * Initialize DSA validation parameters for FIPS186.2.
     *
     * @param seed the seed value.
     * @param counter the counter value.
     */
    public DHKeyValidationParameters(byte[] seed, int counter)
    {
        this.seed = seed;
        this.counter = counter;
    }

    /**
     * @return the counter value;
     */
    public int getCounter()
    {
        return this.counter;
    }

    /**
     * @return the seed value.
     */
    public byte[] getSeed()
    {
        return this.seed;
    }
}
