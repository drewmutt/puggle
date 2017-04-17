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
package org.xwiki.crypto.cipher.internal.asymmetric.factory;

import java.security.SecureRandom;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.xwiki.component.annotation.Component;

/**
 * Factory of cipher using RSA encryption algorithm with OAEP encoding.
 *
 * @version $Id: 9d653f77415de86ab0cb569f941377892cb4f57c $
 * @since 5.4M1
 */
@Component(hints = { "RSA/OAEP", "1.2.840.113549.1.1.6" })
@Singleton
public class BcRsaOaepCipherFactory extends AbstractBcOAEPEncodedCipherFactory
{
    @Inject
    private Provider<SecureRandom> random;

    @Override
    protected AsymmetricBlockCipher getEngineInstance()
    {
        return new RSABlindedEngine();
    }

    @Override
    protected SecureRandom getRandomSource()
    {
        return this.random.get();
    }
}
