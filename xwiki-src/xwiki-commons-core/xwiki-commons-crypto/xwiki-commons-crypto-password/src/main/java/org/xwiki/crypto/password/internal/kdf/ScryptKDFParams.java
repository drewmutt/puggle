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
package org.xwiki.crypto.password.internal.kdf;

import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/**
 * Scrypt parameters as defined in IETF expired draft draft-josefsson-scrypt-kdf-01.
 *
 * @version $Id: 20e9df1956a73592fd4e2a6ee008aaf39d08b052 $
 * @since 5.4M1
 */
public class ScryptKDFParams extends ASN1Object
{
    private ASN1OctetString salt;

    private ASN1Integer costParameter;

    private ASN1Integer blockSize;

    private ASN1Integer parallelizationParameter;

    private ASN1Integer keyLength;

    /**
     * Create Scrypt parameters without a key length.
     *
     * @param salt is the salt value.
     * @param costParameter is the CPU/Memory cost parameter N.
     * @param blockSize is the block size parameter r.
     * @param parallelizationParameter is the parallelization parameter.
     */
    public ScryptKDFParams(byte[] salt, int costParameter, int blockSize, int parallelizationParameter)
    {
        this(salt, costParameter, blockSize, parallelizationParameter, -1);
    }

    /**
     * Create Scrypt parameters with a key length.
     *
     * @param salt is the salt value.
     * @param costParameter is the CPU/Memory cost parameter N.
     * @param blockSize is the block size parameter r.
     * @param parallelizationParameter is the parallelization parameter.
     * @param keyLength is the length in octets of the derived key.
     */
    public ScryptKDFParams(byte[] salt, int costParameter, int blockSize, int parallelizationParameter, int keyLength)
    {
        this.salt = new DEROctetString(salt);
        this.costParameter = new ASN1Integer(costParameter);
        this.blockSize = new ASN1Integer(blockSize);
        this.parallelizationParameter = new ASN1Integer(parallelizationParameter);
        this.keyLength = (keyLength >= 0) ? new ASN1Integer(keyLength) : null;
    }

    /**
     * Create a new instance from a ASN.1 sequence.
     *
     * @param seq the ASN.1 sequence to parse.
     */
    private ScryptKDFParams(ASN1Sequence seq)
    {
        this.salt = (ASN1OctetString) seq.getObjectAt(0);
        this.costParameter = (ASN1Integer) seq.getObjectAt(1);
        this.blockSize = (ASN1Integer) seq.getObjectAt(2);
        this.parallelizationParameter = (ASN1Integer) seq.getObjectAt(3);
        if (seq.size() > 4) {
            this.keyLength = (ASN1Integer) seq.getObjectAt(4);
        }
    }

    /**
     * Get an instance from an ASN.1 object.
     *
     * @param obj an ASN.1 object.
     * @return an instance.
     */
    public static ScryptKDFParams getInstance(Object obj)
    {
        if (obj instanceof ScryptKDFParams) {
            return (ScryptKDFParams) obj;
        }
        if (obj != null) {
            return new ScryptKDFParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /**
     * @return the salt value.
     */
    public byte[] getSalt()
    {
        return this.salt.getOctets();
    }

    /**
     * @return the CPU/Memory cost parameter N.
     */
    public BigInteger getCostParameter()
    {
        return this.costParameter.getValue();
    }

    /**
     * @return the block size parameter r.
     */
    public BigInteger getBlockSize()
    {
        return this.blockSize.getValue();
    }

    /**
     * @return the parallelization parameter.
     */
    public BigInteger getParallelizationParameter()
    {
        return this.parallelizationParameter.getValue();
    }

    /**
     * @return the length in bytes of the derived key.
     */
    public BigInteger getKeyLength()
    {
        if (this.keyLength == null) {
            return null;
        }
        return this.keyLength.getValue();
    }

    /**
     * @return an ASN.1 structure representing these parameters.
     */
    @Override
    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(this.salt);
        v.add(this.costParameter);
        v.add(this.blockSize);
        v.add(this.parallelizationParameter);
        if (this.keyLength != null) {
            v.add(this.keyLength);
        }

        return new DERSequence(v);
    }
}
