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
package org.xwiki.crypto.pkix.internal;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bouncycastle.cert.X509CertificateHolder;
import org.xwiki.component.annotation.Component;
import org.xwiki.crypto.pkix.CertificateFactory;
import org.xwiki.crypto.pkix.params.CertifiedPublicKey;
import org.xwiki.crypto.signer.SignerFactory;

/**
 * X.509 Certificate factory.
 *
 * @version $Id: 0bab958acc206555d9a96c4f9eacf54bf56f0ec0 $
 * @since 5.4
 */
@Component
@Singleton
@Named("X509")
public class BcX509CertificateFactory implements CertificateFactory
{
    @Inject
    private SignerFactory factory;

    @Override
    public CertifiedPublicKey decode(byte[] encoded) throws IOException
    {
        return convert(new X509CertificateHolder(encoded));
    }

    /**
     * Convert Bouncy Castle certificate holder.
     *
     * @param cert a certificate holder.
     * @return a certified public key.
     * @since 6.0M1
     */
    public CertifiedPublicKey convert(X509CertificateHolder cert)
    {
        if (cert == null) {
            return null;
        }
        return new BcX509CertifiedPublicKey(cert, this.factory);
    }
}
