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

import java.io.Closeable;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.stax.StAXResult;

import org.xwiki.filter.FilterException;
import org.xwiki.filter.output.OutputFilterStream;
import org.xwiki.filter.output.OutputStreamOutputTarget;
import org.xwiki.filter.output.OutputTarget;
import org.xwiki.filter.output.WriterOutputTarget;
import org.xwiki.filter.xml.output.ResultOutputTarget;
import org.xwiki.filter.xml.output.XMLOutputProperties;

import javanet.staxutils.IndentingXMLStreamWriter;

/**
 * @param <P>
 * @version $Id: e68c101dee2e49806c4075b644ae0adcea33203e $
 * @since 6.2M1
 */
public abstract class AbstractXMLOutputFilterStream<P extends XMLOutputProperties> implements OutputFilterStream
{
    protected final P properties;

    protected final Result result;

    protected Object filter;

    public AbstractXMLOutputFilterStream(P properties) throws FilterException, XMLStreamException, IOException
    {
        this.properties = properties;
        this.result = createResult(this.properties);
    }

    protected Result createResult(P properties) throws FilterException, XMLStreamException, IOException
    {
        OutputTarget target = properties.getTarget();

        Result result;

        if (target instanceof ResultOutputTarget) {
            result = ((ResultOutputTarget) target).getResult();
        } else {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();

            XMLStreamWriter xmlStreamWriter;

            if (target instanceof WriterOutputTarget) {
                xmlStreamWriter = factory.createXMLStreamWriter(((WriterOutputTarget) target).getWriter());
            } else if (target instanceof OutputStreamOutputTarget) {
                xmlStreamWriter =
                    factory.createXMLStreamWriter(((OutputStreamOutputTarget) target).getOutputStream(),
                        properties.getEncoding());
            } else {
                throw new FilterException("Unknown target type [" + target.getClass() + "]");
            }

            if (properties.isFormat()) {
                xmlStreamWriter = new IndentingXMLStreamWriter(xmlStreamWriter);
            }

            result = new StAXResult(xmlStreamWriter);
        }

        return result;
    }

    @Override
    public Object getFilter() throws FilterException
    {
        if (this.filter == null) {
            try {
                this.filter = createFilter(this.properties);
            } catch (Exception e) {
                throw new FilterException("Failed to create filter", e);
            }
        }

        return this.filter;
    }

    protected abstract Object createFilter(P parameters) throws XMLStreamException, FactoryConfigurationError,
        FilterException;

    @Override
    public void close() throws IOException
    {
        if (this.filter instanceof Closeable) {
            ((Closeable) this.filter).close();
        }

        this.properties.getTarget().close();
    }
}
