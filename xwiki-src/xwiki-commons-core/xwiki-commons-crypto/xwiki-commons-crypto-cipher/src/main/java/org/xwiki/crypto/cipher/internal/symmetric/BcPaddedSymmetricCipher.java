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
package org.xwiki.crypto.cipher.internal.symmetric;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;

/**
 * Base class for Bouncy Castle padded symmetric ciphers.
 *
 * @version $Id: d521dd634cf3472cd99fceefdc426fa0dcb20400 $
 */
public class BcPaddedSymmetricCipher extends BcSymmetricCipher
{
    private static final String SEPARATOR = "/";

    private static final String PADDING = "Padding";

    private static final String PKCS5_PADDING = "PKCS5" + PADDING;

    private static final String PKCS7_PADDING = "PKCS7" + PADDING;

    private String paddingName;

    /**
     * Generic Bouncy Castle based block cipher with padding.
     *
     * @param cipher the block cipher to encapsulate.
     * @param forEncryption true if the block cipher is setup for encryption.
     * @param parameters parameters to initialize the cipher.
     */
    public BcPaddedSymmetricCipher(BlockCipher cipher, boolean forEncryption, CipherParameters parameters)
    {
        super(new PaddedBufferedBlockCipher(cipher), forEncryption, parameters);
        this.paddingName = (getOutputBlockSize() <= 8) ? PKCS5_PADDING : PKCS7_PADDING;
    }

    /**
     * Generic Bouncy Castle based block cipher with padding.
     *
     * @param cipher the block cipher to encapsulate.
     * @param forEncryption true if the block cipher is setup for encryption.
     * @param padding the padding to apply.
     * @param parameters parameters to initialize the cipher.
     */
    public BcPaddedSymmetricCipher(BlockCipher cipher, boolean forEncryption, CipherParameters parameters,
        BlockCipherPadding padding)
    {
        super(new PaddedBufferedBlockCipher(cipher, padding), forEncryption, parameters);
        this.paddingName = padding.getPaddingName() + PADDING;
        if (PKCS7_PADDING.equals(this.paddingName) && getOutputBlockSize() <= 8) {
            this.paddingName = PKCS5_PADDING;
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + SEPARATOR + this.paddingName;
    }
}
