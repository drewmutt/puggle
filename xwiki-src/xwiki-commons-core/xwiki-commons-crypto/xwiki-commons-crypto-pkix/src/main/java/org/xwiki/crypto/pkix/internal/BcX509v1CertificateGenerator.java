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

import java.security.SecureRandom;

import org.xwiki.crypto.pkix.params.x509certificate.X509CertificateGenerationParameters;
import org.xwiki.crypto.signer.Signer;
import org.xwiki.crypto.signer.SignerFactory;

/**
 * Bouncy Castle based X.509 version 1 certificate generator.
 *
 * @version $Id: 700be8e0860ed42d91352aeb64b890548903b5d7 $
 * @since 5.4
 */
public class BcX509v1CertificateGenerator extends AbstractBcX509CertificateGenerator
{
    /**
     * Create a initialized certificate generator.
     *
     * @param signer a certifying signer initialized with the certified key pair of the issuer
     *               or a signer initialized with the private key of the subject for creating a self sign certificate.
     * @param parameters the common parameters for all certificate generated by this generator.
     * @param signerFactory the signer factory to be used by the certificate to verify signature.
     * @param random a random source.
     */
    public BcX509v1CertificateGenerator(Signer signer, X509CertificateGenerationParameters parameters,
        SignerFactory signerFactory, SecureRandom random)
    {
        super(signer, parameters, signerFactory, random);
    }

    @Override
    protected BcX509TBSCertificateBuilder getTBSCertificateBuilder()
    {
        return new BcX509v1TBSCertificateBuilder();
    }
}
