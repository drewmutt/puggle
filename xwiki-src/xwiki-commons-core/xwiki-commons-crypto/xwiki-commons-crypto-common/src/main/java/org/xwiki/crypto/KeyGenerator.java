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
package org.xwiki.crypto;

import org.xwiki.component.annotation.Role;
import org.xwiki.crypto.params.generator.KeyGenerationParameters;

/**
 * Component role for a key pair generator.
 *
 * Component providing this role is usually tightly coupled with those implementing the AsymmetricKeyFactory for the
 * same hints. So, overriding one of these components usually requires to override both.
 *
 * @version $Id: 4a1ca6f4795a77b024f469c3c286999906d58502 $
 * @since 5.4M1
 */
@Role
public interface KeyGenerator
{
    /**
     * @return a new key based on default parameters.
     */
    byte[] generate();

    /**
     * Generate a new key based on given parameters.
     *
     * @param params the key generation parameters.
     * @return a new key pair based the given parameters.
     */
    byte[] generate(KeyGenerationParameters params);
}
