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
package org.xwiki.crypto.internal.symmetric.generator;

import javax.inject.Named;
import javax.inject.Singleton;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import org.xwiki.component.annotation.Component;
import org.xwiki.crypto.params.generator.symmetric.GenericKeyGenerationParameters;

/**
 * DESede key generator based on Bouncy Castle
 *
 * If strength is set to zero or not provided, the key generated will be 192 bits in size,
 * otherwise strength can be 128 or 192 (or 112 or 168 if you don't count parity bits), depending on whether you wish
 * to do 2-key or 3-key triple DES.
 *
 * @version $Id: 7fcf3910786d07eb8f57775d67d17d8f7240eeb7 $
 * @since 5.4M1
 */
@Component
@Singleton
@Named("DESede")
public class BcDESedeKeyGenerator extends DefaultKeyGenerator
{
    @Override
    public byte[] generate()
    {
        return generate(new GenericKeyGenerationParameters(24));
    }

    @Override
    protected CipherKeyGenerator getKeyGenerator()
    {
        return new DESedeKeyGenerator();
    }
}
