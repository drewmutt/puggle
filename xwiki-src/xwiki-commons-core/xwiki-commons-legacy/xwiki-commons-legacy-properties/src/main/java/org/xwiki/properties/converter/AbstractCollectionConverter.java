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
package org.xwiki.properties.converter;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.xwiki.properties.ConverterManager;

/**
 * Base class for all {@link java.util.Collection} converters.
 * 
 * @version $Id: 1b11aae2fd6b31491be176b653cad7a45b1e148c $
 * @since 3.0M1
 */
@Deprecated
public abstract class AbstractCollectionConverter extends AbstractConverter
{
    /**
     * Quote char.
     */
    protected static final char QUOTECHAR = '"';

    /**
     * Quote string.
     */
    protected static final String QUOTESTRING = "\"";

    /**
     * Used to convert collection elements.
     */
    @Inject
    private ConverterManager converterManager;

    /**
     * @see #setDelimiters(String)
     */
    private String delimiters = ", ";

    /**
     * @return the converter manager.
     */
    public ConverterManager getConverterManager()
    {
        return this.converterManager;
    }

    /**
     * Set the delimiter to be used for parsing a delimited String.
     * 
     * @param delimiter The delimiter [default ", "]
     * since 3.2M3
     */
    public void setDelimiters(String delimiter)
    {
        this.delimiters = delimiter;
    }

    /**
     * @return the delimiters
     * @since 3.2M3
     */
    public String getDelimiters()
    {
        return this.delimiters;
    }

    @Override
    protected Object convertToType(Type targetType, Object value)
    {
        Type genericType = null;
        if (targetType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) targetType).getActualTypeArguments()[0];
        }

        return parseElements(value.toString(), genericType);
    }

    /**
     * <p>
     * Parse an incoming String of the form similar to an array initializer in the Java language into a
     * <code>List</code> individual Strings for each element, according to the following rules.
     * </p>
     * <ul>
     * <li>The string is expected to be a comma-separated list of values.</li>
     * <li>The string may optionally have matching '{' and '}' delimiters around the list.</li>
     * <li>Whitespace before and after each element is stripped.</li>
     * <li>Elements in the list may be delimited by single or double quotes. Within a quoted elements, the normal Java
     * escape sequences are valid.</li>
     * </ul>
     * 
     * @param value String value to be parsed
     * @param genericType the generic type
     * @return List of parsed elements.
     * @throws ConversionException if the syntax of <code>value</code> is not syntactically valid
     * @throws NullPointerException if <code>value</code> is <code>null</code>
     */
    protected Collection parseElements(String value, Type genericType)
    {
        String cleanedValue = cleanValue(value);

        try {
            // Set up a StreamTokenizer on the characters in this String
            StreamTokenizer st = createStreamTokenizer(cleanedValue);

            // Split comma-delimited tokens into a List
            Collection collection = newCollection();
            while (true) {
                int ttype = st.nextToken();
                if (ttype == StreamTokenizer.TT_WORD || ttype > 0) {
                    if (st.sval != null) {
                        Object objValue = st.sval;
                        if (genericType != null && genericType != String.class) {
                            objValue = this.converterManager.convert(genericType, objValue);
                        }

                        collection.add(objValue);
                    }
                } else if (ttype == StreamTokenizer.TT_EOF) {
                    break;
                } else {
                    throw new ConversionException("Encountered token of type " + ttype + " parsing elements.");
                }
            }

            // Return the completed list
            return collection;
        } catch (IOException e) {
            throw new ConversionException("Error converting from String: " + e.getMessage(), e);
        }
    }

    /**
     * @return the modifiable {@link Collection} to fill
     */
    protected Collection newCollection()
    {
        return new ArrayList();
    }

    /**
     * @param value the string to cleanup
     * @return the clean version of the string
     */
    private String cleanValue(String value)
    {
        // Trim any matching '{' and '}' delimiters
        String cleanedValue = value.trim();
        if (cleanedValue.startsWith("{") && cleanedValue.endsWith("}")) {
            cleanedValue = cleanedValue.substring(1, cleanedValue.length() - 1);
        }

        return cleanedValue;
    }

    /**
     * Create and initializer a {@link StreamTokenizer} to parse the value.
     * 
     * @param value the string to parse
     * @return the {@link StreamTokenizer} used to parse the string
     */
    protected StreamTokenizer createStreamTokenizer(String value)
    {
        // Set up a StreamTokenizer on the characters in this String
        StreamTokenizer st = new StreamTokenizer(new StringReader(value));

        // Everything is word
        st.ordinaryChars(0, 255);
        st.wordChars(0, 255);

        // Except quote chars
        st.quoteChar('"');
        st.quoteChar('\'');

        // And delimiters
        for (char c : getDelimiters().toCharArray()) {
            st.whitespaceChars(c, c);
        }

        return st;
    }

    @Override
    protected String convertToString(Object value)
    {
        StringBuilder sb = new StringBuilder();

        Collection collection = (Collection) value;

        for (Object element : collection) {
            if (sb.length() > 0) {
                sb.append(getDelimiters());
            }

            String elementString = getConverterManager().convert(String.class, element);

            if (elementString != null) {
                boolean containsDelimiter = StringUtils.contains(elementString, getDelimiters());

                if (containsDelimiter) {
                    sb.append(QUOTESTRING);
                }
                sb.append(elementString.replace("\\", "\\\\").replace(QUOTESTRING, "\\\"").replace("'", "\\'"));
                if (containsDelimiter) {
                    sb.append(QUOTESTRING);
                }
            }
        }

        return sb.toString();
    }

    // deprecated

    /**
     * @return the delimiter
     * @deprecated since 3.2M3 use {@link #getDelimiters()} instead
     */
    @Deprecated
    public char getDelimiter()
    {
        return this.delimiters.charAt(0);
    }

    /**
     * @param allowedChars allowed characters
     * @deprecated since 3.2M3 use {@link #setDelimiters(String)} instead
     */
    @Deprecated
    public void setAllowedChars(char[] allowedChars)
    {
        // do nothing anymore
    }

    /**
     * @param delimiter the delimiter
     * @deprecated since 3.2M3 use {@link #setDelimiters(String)} instead
     */
    @Deprecated
    public void setDelimiter(char delimiter)
    {
        setDelimiters(String.valueOf(delimiter));
    }
}
