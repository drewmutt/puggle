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
package org.xwiki.logging.marker;

import org.xwiki.logging.event.LogEvent;

/**
 * A {@link org.xwiki.logging.TranslationMarker} with a {@link LogEvent#MARKER_END} marker.
 *
 * @version $Id: 6a36cac763ca7feb73139cd21230f699437e146e $
 * @since 5.4M1
 */
public class EndTranslationMarker extends TranslationMarker
{
    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param translationKey the translation key to associate to the log
     */
    public EndTranslationMarker(String translationKey)
    {
        super(translationKey, LogEvent.MARKER_END);
    }
}
