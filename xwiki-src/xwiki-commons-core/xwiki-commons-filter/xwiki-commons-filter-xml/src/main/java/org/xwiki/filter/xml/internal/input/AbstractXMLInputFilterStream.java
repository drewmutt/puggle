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
package org.xwiki.filter.xml.internal.input;

import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;

import org.xwiki.filter.FilterException;
import org.xwiki.filter.input.InputFilterStream;
import org.xwiki.filter.input.InputSource;
import org.xwiki.filter.input.InputStreamInputSource;
import org.xwiki.filter.input.ReaderInputSource;
import org.xwiki.filter.xml.input.XMLInputProperties;

import javanet.staxutils.XMLStreamUtils;

/**
 * @param <P>
 * @version $Id: d9861c63d78b2d6b3d1c7f93fa367c93e61d8311 $
 * @since 6.2M1
 */
public abstract class AbstractXMLInputFilterStream<P extends XMLInputProperties> implements InputFilterStream
{
    private static final XMLInputFactory XML_INPUT_FACTORY = XMLInputFactory.newInstance();

    protected P parameters;

    public AbstractXMLInputFilterStream(P parameters)
    {
        this.parameters = parameters;
    }

    @Override
    public void read(Object listener) throws FilterException
    {
        try {
            InputSource source = this.parameters.getSource();

            XMLEventReader xmlEventReader;

            if (source instanceof ReaderInputSource) {
                xmlEventReader = XML_INPUT_FACTORY.createXMLEventReader(((ReaderInputSource) source).getReader());
            } else if (source instanceof InputStreamInputSource) {
                xmlEventReader = XML_INPUT_FACTORY.createXMLEventReader(((InputStreamInputSource) source).getInputStream());
            } else {
                throw new FilterException("Unknown source type [" + source.getClass() + "]");
            }

            XMLStreamUtils.copy(xmlEventReader, createXMLEventWriter(listener, this.parameters));
        } catch (Exception e) {
            throw new FilterException("Faild to parse XML source", e);
        }
    }

    protected abstract XMLEventWriter createXMLEventWriter(Object listener, P parameters);

    @Override
    public void close() throws IOException
    {
        this.parameters.getSource().close();
    }
}
