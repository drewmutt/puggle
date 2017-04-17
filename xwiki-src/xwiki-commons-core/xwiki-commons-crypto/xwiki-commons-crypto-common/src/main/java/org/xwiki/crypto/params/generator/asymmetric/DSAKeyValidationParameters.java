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
 * Validation parameters for DSA key.
 *
 * @version $Id: efac807a3d268273a9cb8fba1dd689ce4b3bf4cc $
 * @since 5.4M1
 */
public class DSAKeyValidationParameters extends DHKeyValidationParameters
{
    /** Definition of the usage of the key for FIPS186.3. */
    public enum Usage
    {
        /** Digital signature usage. */
        DIGITAL_SIGNATURE,

        /** Key exchange usage. */
        KEY_ESTABLISHMENT,

        /** Any usage. */
        ANY
    }

    private final Usage usage;

    /**
     * Initialize DSA validation parameters for FIPS186.2.
     *
     * @param seed the seed value.
     * @param counter the counter value.
     */
    public DSAKeyValidationParameters(byte[] seed, int counter)
    {
        this(seed, counter, Usage.ANY);
    }

    /**
     * Initialize DSA validation parameters for FIPS186.3.
     *
     * @param seed the seed value.
     * @param counter the counter value.
     * @param usage the usage.
     */
    public DSAKeyValidationParameters(byte[] seed, int counter, Usage usage)
    {
        super(seed, counter);
        this.usage = usage;
    }

    /**
     * @return the usage.
     */
    public Usage getUsage()
    {
        return this.usage;
    }
}
