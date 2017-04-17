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
package org.xwiki.crypto.internal.digest.factory;

import javax.inject.Singleton;

import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.xwiki.component.annotation.Component;

/**
 * Factory creating SHA-384 message digest processor.
 *
 * @version $Id: 5325fdb7d4325f7a14e972b09cd3a06fe61dfadf $
 * @since 5.4M1
 */
@Component(hints = { "SHA-384", "2.16.840.1.101.3.4.2.2" })
@Singleton
public class BcSHA384DigestFactory extends AbstractBcDigestFactory
{
    private static final AlgorithmIdentifier ALG_ID = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384,
        DERNull.INSTANCE);

    @Override
    public Digest getDigestInstance()
    {
        return new SHA384Digest();
    }

    @Override
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
        return ALG_ID;
    }
}
