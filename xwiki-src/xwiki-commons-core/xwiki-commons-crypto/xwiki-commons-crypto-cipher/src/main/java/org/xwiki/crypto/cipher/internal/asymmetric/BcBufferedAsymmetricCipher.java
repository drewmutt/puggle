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
package org.xwiki.crypto.cipher.internal.asymmetric;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.BufferedAsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.xwiki.crypto.cipher.AsymmetricCipher;

/**
 * Base class for Bouncy Castle asymmetric ciphers.
 *
 * @version $Id: 907c7f3ed206955fda8f81881289cb3370ba13d3 $
 * @since 5.4M1
 */
public class BcBufferedAsymmetricCipher implements AsymmetricCipher
{
    private static final RuntimeException NO_STREAMING_ERROR =
        new UnsupportedOperationException("Asymmetric cipher does not support being streamed.");

    private final BufferedAsymmetricBlockCipher cipher;

    private final boolean forEncryption;

    private final String algorithmName;

    /**
     * Create a new Bouncy Castle based asymmetric cipher.
     *
     * @param cipher the native cipher to encapsulate.
     * @param forEncryption true is the cipher should be initialized for encryption.
     * @param parameters the cipher parameters in bouncy castle format.
     * @param algorithmName the name to report for the algorithm of this cipher.
     */
    public BcBufferedAsymmetricCipher(AsymmetricBlockCipher cipher, boolean forEncryption, CipherParameters parameters,
        String algorithmName)
    {
        this.cipher = new BufferedAsymmetricBlockCipher(cipher);
        this.forEncryption = forEncryption;
        this.algorithmName = algorithmName;
        this.cipher.init(forEncryption, parameters);
    }

    @Override
    public String getAlgorithmName()
    {
        return this.algorithmName;
    }

    @Override
    public int getInputBlockSize()
    {
        return this.cipher.getInputBlockSize();
    }

    @Override
    public int getOutputBlockSize()
    {
        return this.cipher.getOutputBlockSize();
    }

    @Override
    public boolean isForEncryption()
    {
        return this.forEncryption;
    }

    @Override
    public FilterInputStream getInputStream(InputStream is)
    {
        throw NO_STREAMING_ERROR;
    }

    @Override
    public FilterOutputStream getOutputStream(OutputStream os)
    {
        throw NO_STREAMING_ERROR;
    }

    @Override
    public byte[] update(byte[] input)
    {
        if (input != null) {
            return update(input, 0, input.length);
        }
        return null;
    }

    @Override
    public byte[] update(byte[] input, int inputOffset, int inputLen)
    {
        this.cipher.processBytes(input, inputOffset, inputLen);
        return null;
    }

    @Override
    public byte[] doFinal() throws GeneralSecurityException
    {
        return doFinal(null, 0, 0);
    }

    @Override
    public byte[] doFinal(byte[] input) throws GeneralSecurityException
    {
        if (input != null) {
            return doFinal(input, 0, input.length);
        } else {
            return doFinal(null, 0, 0);
        }
    }

    @Override
    public byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws GeneralSecurityException
    {
        if (input != null) {
            this.cipher.processBytes(input, inputOffset, inputLen);
        }
        try {
            return this.cipher.doFinal();
        } catch (InvalidCipherTextException e) {
            throw new GeneralSecurityException("Cipher failed to process data.", e);
        }
    }
}
