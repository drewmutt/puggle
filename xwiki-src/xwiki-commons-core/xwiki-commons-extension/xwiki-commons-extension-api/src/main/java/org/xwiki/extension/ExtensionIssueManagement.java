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
package org.xwiki.extension;

/**
 * Describe the issue management system used for this extension.
 *
 * @version $Id: 54a564d0ec549be0dde02e6e62fe3b5811d08c1d $
 * @since 6.3M1
 */
public interface ExtensionIssueManagement
{
    /**
     * @return the name of the issue management system (jira, bugzilla, etc.)
     */
    String getSystem();

    /**
     * @return the URL of that extension in the issues management system
     */
    String getURL();
}
