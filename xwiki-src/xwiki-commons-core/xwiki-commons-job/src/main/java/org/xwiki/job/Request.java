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
package org.xwiki.job;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * A {@link Job} request.
 *
 * @version $Id: 1aa63625c3b0cdb03a41f33bc9b190d546106c95 $
 * @since 4.0M1
 */
public interface Request extends Serializable
{
    /**
     * @see #isRemote()
     */
    String PROPERTY_REMOTE = "remote";

    /**
     * @see #isInteractive()
     */
    String PROPERTY_INTERACTIVE = "interactive";

    /**
     * @return list based identifier used to access the job. If none is provided the job will not be accessible by id
     *         and the status of the job will not be stored.
     * @since 4.1M2
     */
    List<String> getId();

    /**
     * @return indicate if the job has been triggered by a remote event
     */
    boolean isRemote();

    /**
     * @return indicate if the job is allowed to ask questions if it it should be fully automated (i.e. use default
     *         answers)
     */
    boolean isInteractive();

    /**
     * @param key the name of the property
     * @param <T> the type of the value
     * @return the value of the property
     */
    <T> T getProperty(String key);

    /**
     * @param key the name of the property
     * @param def the default value of the property
     * @param <T> the type of the value
     * @return the value of the property
     */
    <T> T getProperty(String key, T def);

    /**
     * @return the names of all the properties
     */
    Collection<String> getPropertyNames();

    /**
     * @param key the name of the property
     * @return <tt>true</tt> if this map contains a property for the specified key
     * @since 4.2M2
     */
    boolean containsProperty(String key);

    /**
     * @return true of the job should log informations about what is going on
     * @since 5.4RC1
     */
    boolean isVerbose();
}
