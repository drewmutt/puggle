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
package org.xwiki.crypto.internal;

import java.security.SecureRandom;

import javax.inject.Provider;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.phase.Initializable;
import org.xwiki.component.phase.InitializationException;

/**
 * Default PRNG provider based on default SecureRandom.
 *
 * @version $Id: 69d579d8a1a19499a30b4e9c608f98e5f9f364ac $
 * @since 5.4M1
 */
@Component
@Singleton
public class DefaultSecureRandomProvider implements Provider<SecureRandom>, Initializable
{
    private SecureRandom random;

    @Override
    public void initialize() throws InitializationException
    {
        this.random = new SecureRandom();
    }

    @Override
    public SecureRandom get()
    {
        return this.random;
    }
}
