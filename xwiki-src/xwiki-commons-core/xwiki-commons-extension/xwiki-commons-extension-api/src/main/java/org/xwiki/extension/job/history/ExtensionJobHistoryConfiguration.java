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
package org.xwiki.extension.job.history;

import java.io.File;

import org.xwiki.component.annotation.Role;

/**
 * Configuration for {@link ExtensionJobHistory}.
 * 
 * @version $Id: 61a8799ab5bc6fe64a8777f5acb7199ace240d34 $
 * @since 7.1RC1
 */
@Role
public interface ExtensionJobHistoryConfiguration
{
    /**
     * @return the folder where the extension job history is saved
     */
    File getStorage();
}
