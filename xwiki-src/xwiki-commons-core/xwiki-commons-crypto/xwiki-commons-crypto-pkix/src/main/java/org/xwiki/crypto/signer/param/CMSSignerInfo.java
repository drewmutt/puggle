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

import java.math.BigInteger;

import org.xwiki.crypto.pkix.params.PrincipalIndentifier;

/**
 * Signer information, including an already computed signature.
 *
 * @version $Id: 0712bd44e3e311de6e765858df0395fb27676e50 $
 * @since 6.0M1
 */
public interface CMSSignerInfo
{
    /**
     * @return the issuer of the certificate related to this signature.
     */
    PrincipalIndentifier getIssuer();

    /**
     * @return the serial number attributed to the certificate related to this signature by the issuer.
     */
    BigInteger getSerialNumber();

    /**
     * @return the subject key identifier.
     */
    byte[] getSubjectKeyIdentifier();
}
