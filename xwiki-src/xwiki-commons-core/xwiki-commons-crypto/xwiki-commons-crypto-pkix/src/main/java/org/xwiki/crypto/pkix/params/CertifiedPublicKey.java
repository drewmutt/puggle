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
package org.xwiki.crypto.pkix.params;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.xwiki.crypto.params.cipher.asymmetric.PublicKeyParameters;

/**
 * Certified binding of a principal to a public key.
 *
 * @version $Id: 0b42b1520d441670a0a84997596959bb3cc26b6e $
 * @since 5.4
 */
public interface CertifiedPublicKey
{
    /**
     * @return the name of the issuer of the certificate.
     */
    PrincipalIndentifier getIssuer();

    /**
     * @return the name of the owner of the certified public key.
     */
    PrincipalIndentifier getSubject();

    /**
     * @return the certified public key parameters.
     */
    PublicKeyParameters getPublicKeyParameters();

    /**
     * Check that the key has been certified by the private key associated with the given public key.
     *
     * @param publicKey the public key of the signer.
     * @return true if the signature is verified.
     * @throws GeneralSecurityException if the signing algorithm is unable to proceed properly.
     */
    boolean isSignedBy(PublicKeyParameters publicKey) throws GeneralSecurityException;

    /**
     * @return true if this certificate is self signed.
     * @since 6.0M1
     */
    boolean isSelfSigned();

    /**
     * @return the ASN.1 encoded form of this certificate.
     * @throws IOException on encoding error.
     */
    byte[] getEncoded() throws IOException;
}
