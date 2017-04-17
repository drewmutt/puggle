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
package org.xwiki.crypto.cipher;

import org.xwiki.component.annotation.Role;
import org.xwiki.crypto.params.cipher.CipherParameters;

/**
 * Factory creating block ciphers for encryption and decryption.
 *
 * @version $Id: 864c091a788b14f331b54143cd8ce63de448fd5f $
 * @since 5.4M1
 */
@Role
public interface CipherFactory extends CipherSpecifications
{
    /**
     * @param forEncryption if true the cipher is initialised for encryption, if false for decryption.
     * @param parameters the key and other data required by the cipher.
     * @return an initialized cipher ready to process data.
     */
    Cipher getInstance(boolean forEncryption, CipherParameters parameters);
}
