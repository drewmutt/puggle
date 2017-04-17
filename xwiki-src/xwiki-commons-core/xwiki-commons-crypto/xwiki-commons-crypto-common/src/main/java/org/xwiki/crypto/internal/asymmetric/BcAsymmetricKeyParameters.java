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
package org.xwiki.crypto.internal.asymmetric;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/**
 * Common internal interface for AsymmetricKeyParameters built from Bouncy Castle.
 *
 * @version $Id: fa179d505f9ab6cf92429aeabbc5147929dc862e $
 * @since 5.4M1
 */
public interface BcAsymmetricKeyParameters
{
    /**
     * @return the encapsulated Bouncy Castle asymmetric key parameter.
     */
    AsymmetricKeyParameter getParameters();
}
