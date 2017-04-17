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
package org.xwiki.crypto.internal.digest.factory;

import org.junit.Before;
import org.junit.Rule;
import org.xwiki.crypto.BinaryStringEncoder;
import org.xwiki.crypto.DigestFactory;
import org.xwiki.crypto.internal.encoder.Base64BinaryStringEncoder;
import org.xwiki.test.annotation.ComponentList;
import org.xwiki.test.mockito.MockitoComponentMockingRule;

@ComponentList({Base64BinaryStringEncoder.class})
public class BcSHA512DigestFactoryTest extends AbstractDigestFactoryTest
{
    @Rule
    public final MockitoComponentMockingRule<DigestFactory> mocker =
        new MockitoComponentMockingRule<DigestFactory>(BcSHA512DigestFactory.class);

    @Before
    public void configure() throws Exception
    {
        factory = mocker.getComponentUnderTest();

        if (digestResult == null) {
            digestAlgo = "SHA-512";
            digestAlgId = SHA512_DIGEST_ALGO;
            digestSize = 64;

            BinaryStringEncoder base64encoder = mocker.getInstance(BinaryStringEncoder.class, "Base64");
            digestResult = base64encoder.decode(SHA512_DIGEST);
        }
    }
}
