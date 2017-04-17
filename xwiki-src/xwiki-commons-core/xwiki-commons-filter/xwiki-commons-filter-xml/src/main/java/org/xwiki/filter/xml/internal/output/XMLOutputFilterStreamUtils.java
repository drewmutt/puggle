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
package org.xwiki.filter.xml.internal.output;

import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xwiki.filter.FilterException;
import org.xwiki.filter.output.OutputStreamOutputTarget;
import org.xwiki.filter.output.OutputTarget;
import org.xwiki.filter.output.WriterOutputTarget;
import org.xwiki.filter.xml.output.ResultOutputTarget;
import org.xwiki.filter.xml.output.XMLOutputProperties;
import org.xwiki.xml.stax.StAXUtils;

import javanet.staxutils.IndentingXMLStreamWriter;

/**
 * @version $Id: 4b475b3de8c178e7b4fe963b68ac190eb3392ea5 $
 * @since 6.2M1
 */
public final class XMLOutputFilterStreamUtils
{
    public static XMLStreamWriter createXMLStreamWriter(XMLOutputProperties properties) throws XMLStreamException,
        IOException, FilterException
    {
        XMLStreamWriter xmlStreamWriter;

        OutputTarget target = properties.getTarget();

        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        if (target instanceof WriterOutputTarget) {
            xmlStreamWriter = factory.createXMLStreamWriter(((WriterOutputTarget) target).getWriter());
        } else if (target instanceof OutputStreamOutputTarget) {
            xmlStreamWriter =
                factory.createXMLStreamWriter(((OutputStreamOutputTarget) target).getOutputStream(),
                    properties.getEncoding());
        } else if (target instanceof ResultOutputTarget) {
            xmlStreamWriter = StAXUtils.getXMLStreamWriter(((ResultOutputTarget) target).getResult());
        } else {
            throw new FilterException("Unknown target type [" + target.getClass() + "]");
        }

        if (properties.isFormat()) {
            xmlStreamWriter = new IndentingXMLStreamWriter(xmlStreamWriter);
        }

        return xmlStreamWriter;
    }
}
