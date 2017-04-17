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
package org.xwiki.extension.internal;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.xwiki.extension.CoreExtension;
import org.xwiki.extension.Extension;
import org.xwiki.extension.ExtensionDependency;
import org.xwiki.extension.InstalledExtension;
import org.xwiki.extension.LocalExtension;
import org.xwiki.extension.MutableExtension;
import org.xwiki.extension.RemoteExtension;
import org.xwiki.extension.rating.RatingExtension;
import org.xwiki.extension.wrap.WrappingCoreExtension;
import org.xwiki.extension.wrap.WrappingExtension;
import org.xwiki.extension.wrap.WrappingInstalledExtension;
import org.xwiki.extension.wrap.WrappingLocalExtension;
import org.xwiki.extension.wrap.WrappingRatingExtension;
import org.xwiki.extension.wrap.WrappingRemoteExtension;
import org.xwiki.properties.converter.ConversionException;

/**
 * Various extension related utilities.
 * 
 * @version $Id: d9a77f14b3fcb68bd8748f4207abda0ce3e0608c $
 * @since 8.2RC1
 */
public final class ExtensionUtils
{
    private ExtensionUtils()
    {
        // Utility class
    }

    /**
     * @param dependency the initial dependency
     * @param managedDependencies the managed dependencies
     * @param extension the extension with the passed dependency
     * @return the actual dependency to resolve
     */
    public static ExtensionDependency getDependency(ExtensionDependency dependency,
        Map<String, ExtensionDependency> managedDependencies, Extension extension)
    {
        ExtensionDependency managedDependency = managedDependencies.get(dependency.getId());

        // If the dependency does not have any version try to find it in extension managed dependencies
        if (managedDependency == null && dependency.getVersionConstraint() == null) {
            for (ExtensionDependency extensionManagedDependency : extension.getManagedDependencies()) {
                if (extensionManagedDependency.getId().equals(dependency.getId())) {
                    managedDependency = extensionManagedDependency;
                }
            }
        }

        return managedDependency != null ? managedDependency : dependency;
    }

    /**
     * @param managedDependencies the managed dependencies
     * @param extension the extension for which to append managed dependencies
     * @return the new map of managed dependencies
     */
    public static Map<String, ExtensionDependency> append(Map<String, ExtensionDependency> managedDependencies,
        Extension extension)
    {
        Map<String, ExtensionDependency> newManagedDependencies =
            managedDependencies != null ? new HashMap<>(managedDependencies) : new HashMap<>();

        for (ExtensionDependency dependency : extension.getManagedDependencies()) {
            newManagedDependencies.put(dependency.getId(), dependency);
        }

        return newManagedDependencies;
    }

    /**
     * Delete and return the value of the passed special property.
     * 
     * @param <T> type of the property value
     * @param extension the extension from which to extract custom property
     * @param propertySuffix the property suffix
     * @return the value
     * @ @since 8.3M1
     */
    public static <T> T importProperty(MutableExtension extension, String propertySuffix)
    {
        return extension.removeProperty(Extension.IKEYPREFIX + propertySuffix);
    }

    /**
     * Delete and return the value of the passed special property.
     * 
     * @param extension the extension from which to extract custom property
     * @param propertySuffix the property suffix
     * @param def the default value
     * @return the value or {@code def} if none was found
     * @since 8.3M1
     */
    public static String importProperty(MutableExtension extension, String propertySuffix, String def)
    {
        return StringUtils.defaultString(importProperty(extension, propertySuffix), def);
    }

    /**
     * Delete and return the value of the passed special property as a Collection of Strings.
     * 
     * @param extension the extension from which to extract custom property
     * @param propertySuffix the property suffix
     * @param def the default value
     * @return the value or {@code def} if none was found
     * @since 8.3M1
     */
    public static Collection<String> importProperty(MutableExtension extension, String propertySuffix,
        Collection<String> def)
    {
        Object obj = importProperty(extension, propertySuffix);

        if (obj == null) {
            return def;
        } else if (obj instanceof Collection) {
            return (Collection) obj;
        } else if (obj instanceof String[]) {
            return Arrays.asList((String[]) obj);
        } else {
            return importPropertyStringList(obj.toString(), true);
        }
    }

    /**
     * @param str the String to parse
     * @param trim true if the passed String should be trimmed
     * @return the collection of Strings extracted from the passed String
     * @since 8.3M1
     */
    public static List<String> importPropertyStringList(String str, boolean trim)
    {
        try {
            String cleanedString = str;

            // Trim
            if (trim) {
                cleanedString = cleanedString.trim();
            }

            // Set up a StreamTokenizer on the characters in this String
            StreamTokenizer st = new StreamTokenizer(new StringReader(cleanedString));

            // Everything is word
            st.ordinaryChars(0, 255);
            st.wordChars(0, 255);

            // Except quote chars
            st.quoteChar('"');
            st.quoteChar('\'');

            // And delimiters
            st.whitespaceChars(',', ',');
            st.whitespaceChars(' ', ' ');
            st.whitespaceChars('\t', '\t');
            st.whitespaceChars('\n', '\n');
            st.whitespaceChars('\r', '\r');

            // Split comma-delimited tokens into a List
            List<String> collection = new ArrayList<>();
            while (true) {
                int ttype = st.nextToken();
                if (ttype == StreamTokenizer.TT_WORD || ttype > 0) {
                    if (st.sval != null) {
                        collection.add(st.sval);
                    }
                } else if (ttype == StreamTokenizer.TT_EOF) {
                    break;
                } else {
                    throw new ConversionException("Encountered token of type " + ttype + " parsing elements.");
                }
            }

            // Return the completed list
            return collection;
        } catch (Exception e) {
            // Log ?
        }

        return Collections.emptyList();
    }

    /**
     * @param <T> the type
     * @param extension the extension to wrap
     * @return the wrapped version
     * @since 8.4.2
     * @since 9.0RC1
     */
    public static <T extends Extension> WrappingExtension<T> wrap(Extension extension)
    {
        WrappingExtension<?> wrapper;

        if (extension instanceof CoreExtension) {
            wrapper = new WrappingCoreExtension<>((CoreExtension) extension);
        } else if (extension instanceof InstalledExtension) {
            wrapper = new WrappingInstalledExtension<>((InstalledExtension) extension);
        } else if (extension instanceof LocalExtension) {
            wrapper = new WrappingLocalExtension<>((LocalExtension) extension);
        } else if (extension instanceof RatingExtension) {
            wrapper = new WrappingRatingExtension<>((RatingExtension) extension);
        } else if (extension instanceof RemoteExtension) {
            wrapper = new WrappingRemoteExtension<>((RemoteExtension) extension);
        } else {
            wrapper = new WrappingExtension<>(extension);
        }

        return (WrappingExtension<T>) wrapper;
    }
}
