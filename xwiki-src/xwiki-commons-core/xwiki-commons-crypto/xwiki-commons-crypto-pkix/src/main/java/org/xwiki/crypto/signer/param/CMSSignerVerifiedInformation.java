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

package org.xwiki.crypto.signer.param;

import java.util.Collection;

import org.xwiki.crypto.pkix.params.CertifiedPublicKey;

/**
 * Signer information verifier results.
 *
 * @version $Id: ae6ddf183aa42ef869fc1e5e7fb524dc24d96f18 $
 * @since 6.0M1
 */
public interface CMSSignerVerifiedInformation extends CMSSignerInfo
{
    /**
     * @return true if the signature is verified against the data.
     */
    boolean isVerified();

    /**
     * @return the certificate chain of this signature, from the signer to the root.
     */
    Collection<CertifiedPublicKey> getCertificateChain();
}
