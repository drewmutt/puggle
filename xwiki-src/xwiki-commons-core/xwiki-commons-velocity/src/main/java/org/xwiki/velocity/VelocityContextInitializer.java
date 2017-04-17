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
package org.xwiki.velocity;

import org.apache.velocity.VelocityContext;
import org.xwiki.component.annotation.Role;

/**
 * Populates new Velocity contexts with custom entries.
 *
 * @version $Id: 1490af4b3b7682f78d4ab2c0e940b6457a419a62 $
 * @since 1.5M1
 */
@Role
public interface VelocityContextInitializer
{
    /**
     * Allow initializing the Velocity Context by putting objects into it.
     *
     * @param context the Velocity context to initialize
     */
    void initialize(VelocityContext context);
}
