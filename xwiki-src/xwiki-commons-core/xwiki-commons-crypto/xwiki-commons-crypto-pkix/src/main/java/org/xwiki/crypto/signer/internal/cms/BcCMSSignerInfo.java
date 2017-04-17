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

package org.xwiki.crypto.signer.internal.cms;

import java.math.BigInteger;

import org.bouncycastle.cms.SignerInformation;
import org.xwiki.crypto.pkix.params.PrincipalIndentifier;
import org.xwiki.crypto.pkix.params.x509certificate.DistinguishedName;
import org.xwiki.crypto.signer.param.CMSSignerInfo;

/**
 * Bouncy Castle based implementation of {@link CMSSignerInfo}.
 *
 * @version $Id: 747f7ba22d63b74bf14f9b2ae1e52ee5e8f67bc6 $
 * @since 6.0M1
 */
public class BcCMSSignerInfo implements CMSSignerInfo
{
    private SignerInformation signerInfo;

    BcCMSSignerInfo(SignerInformation signerInfo)
    {
        this.signerInfo = signerInfo;
    }

    /**
     * @return the embedded signer information.
     */
    SignerInformation getSignerInfo()
    {
        return this.signerInfo;
    }

    @Override
    public PrincipalIndentifier getIssuer()
    {
        return new DistinguishedName(this.signerInfo.getSID().getIssuer());
    }

    @Override
    public BigInteger getSerialNumber()
    {
        return this.signerInfo.getSID().getSerialNumber();
    }

    @Override
    public byte[] getSubjectKeyIdentifier()
    {
        return this.signerInfo.getSID().getSubjectKeyIdentifier();
    }
}
