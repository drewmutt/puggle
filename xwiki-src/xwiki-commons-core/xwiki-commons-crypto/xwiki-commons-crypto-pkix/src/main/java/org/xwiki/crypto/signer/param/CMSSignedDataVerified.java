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
 * Signed Data.
 *
 * @version $Id: 8a08858704c353b7afaf734e10d811daabe93e34 $
 * @since 6.0M1
 */
public interface CMSSignedDataVerified
{
    /**
     * @return the collection of signer information.
     */
    Collection<CMSSignerVerifiedInformation> getSignatures();

    /**
     * @return the collection of certificates.
     */
    Collection<CertifiedPublicKey> getCertificates();

    /**
     * @return the type of the signed data.
     */
    String getContentType();

    /**
     * @return the data.
     */
    byte[] getContent();

    /**
     * @return true if all signatures are verified.
     */
    boolean isVerified();
}
