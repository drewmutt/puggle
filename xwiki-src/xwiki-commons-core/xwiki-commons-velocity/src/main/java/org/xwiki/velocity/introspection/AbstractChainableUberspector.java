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
package org.xwiki.velocity.introspection;

/**
 * Default implementation of a {@link ChainableUberspector chainable uberspector} that forwards all calls to the wrapped
 * uberspector (when that is possible). It should be used as the base class for all chainable uberspectors.
 *
 * @version $Id: 0a41406ad078c592b0a07af81e4cf7e52f6641f9 $
 * @since 1.5M1
 * @see ChainableUberspector
 * @deprecated since 8.0M1; this is now part of the official Velocity library, use
 *             {@link org.apache.velocity.util.introspection.AbstractChainableUberspector} instead
 */
@Deprecated
public abstract class AbstractChainableUberspector
    extends org.apache.velocity.util.introspection.AbstractChainableUberspector implements ChainableUberspector
{
    @Override
    public void init()
    {
        // This method is kept because the version in Velocity 1.7 doesn't catch exceptions
        if (this.inner != null) {
            try {
                this.inner.init();
            } catch (Exception e) {
                this.log.error(e.getMessage(), e);
            }
        }
    }
}
