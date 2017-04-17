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
package org.xwiki.crypto.internal.digest;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.io.DigestInputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.xwiki.crypto.Digest;
import org.xwiki.crypto.params.DigestParameters;

/**
 * Base class for Bouncy Castle based Digest.
 *
 * @version $Id: a648a337572e5c010645ebf02bcefb4b9f05b6bf $
 * @since 5.4M1
 */
public class BouncyCastleDigest implements Digest, DigestCalculator
{
    private final org.bouncycastle.crypto.Digest digest;

    private AlgorithmIdentifier algId;

    private DigestParameters parameters;

    /**
     * Create a new digest based on the given Bouncy Castle digest engine.
     *
     * @param digest a bouncy castle digest.
     * @param algId the algorithm identifier of this digest.
     * @param parameters digest parameters if any.
     */
    public BouncyCastleDigest(org.bouncycastle.crypto.Digest digest, AlgorithmIdentifier algId,
        DigestParameters parameters)
    {
        this.digest = digest;
        this.algId = algId;
        this.parameters = parameters;
    }

    @Override
    public String getAlgorithmName()
    {
        return this.digest.getAlgorithmName();
    }

    @Override
    public int getDigestSize()
    {
        return this.digest.getDigestSize();
    }

    @Override
    public DigestParameters getParameters()
    {
        return this.parameters;
    }

    @Override
    public FilterInputStream getInputStream(InputStream is)
    {
        this.digest.reset();
        return new DigestInputStream(is, this.digest);
    }

    @Override
    public OutputStream getOutputStream()
    {
        this.digest.reset();
        return new org.bouncycastle.crypto.io.DigestOutputStream(this.digest);
    }

    @Override
    public void update(byte[] input)
    {
        update(input, 0, input.length);
    }

    @Override
    public void update(byte[] input, int inputOffset, int inputLen)
    {
        this.digest.update(input, inputOffset, inputLen);
    }

    @Override
    public byte[] digest()
    {
        byte[] dig = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(dig, 0);
        return dig;
    }

    @Override
    public byte[] digest(byte[] input)
    {
        update(input);
        return digest();
    }

    @Override
    public byte[] digest(byte[] input, int inputOffset, int inputLen)
    {
        update(input, inputOffset, inputLen);
        return digest();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.0M1
     */
    @Override
    public byte[] getDigest()
    {
        return digest();
    }

    /**
     * @return the algorithm identifier of this digest.
     */
    @Override
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
        return this.algId;
    }

    @Override
    public byte[] getEncoded() throws IOException
    {
        return getAlgorithmIdentifier().getEncoded();
    }
}
