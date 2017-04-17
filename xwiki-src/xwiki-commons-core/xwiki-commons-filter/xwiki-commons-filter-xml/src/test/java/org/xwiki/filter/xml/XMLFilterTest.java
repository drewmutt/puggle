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
package org.xwiki.filter.xml;

import java.awt.Color;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.filter.test.ExtendedTestData;
import org.xwiki.filter.test.TestFilter;
import org.xwiki.filter.xml.parser.XMLParserFactory;
import org.xwiki.filter.xml.serializer.XMLSerializerFactory;
import org.xwiki.test.annotation.AllComponents;
import org.xwiki.test.mockito.MockitoComponentManagerRule;

@AllComponents
public class XMLFilterTest
{
    @Rule
    public MockitoComponentManagerRule componentManager = new MockitoComponentManagerRule();

    private StringWriter stringWriter;

    private TestFilter createFilter() throws ComponentLookupException, XMLStreamException, FactoryConfigurationError
    {
        this.stringWriter = new StringWriter();

        XMLSerializerFactory serializerFactory = this.componentManager.getInstance(XMLSerializerFactory.class);
        return serializerFactory.createSerializer(TestFilter.class, new StreamResult(this.stringWriter), null);
    }

    private void assertParseAndSerialize(String inputexpect) throws Exception
    {
        assertParseAndSerialize(inputexpect, inputexpect);
    }

    private void assertParseAndSerialize(String expect, String input) throws Exception
    {
        TestFilter testFilter = createFilter();

        XMLParserFactory parserFactory = this.componentManager.getInstance(XMLParserFactory.class);
        parserFactory.parse(new StreamSource(new StringReader(input)), testFilter, null);

        assertSerialized(expect);
    }

    private void assertParseAndSerializeFromSAX(String inputexpect) throws Exception
    {
        assertParseAndSerializeFromSAX(inputexpect, inputexpect);
    }

    private void assertParseAndSerializeFromSAX(String expect, String input) throws Exception
    {
        TestFilter testFilter = createFilter();

        XMLParserFactory parserFactory = this.componentManager.getInstance(XMLParserFactory.class);
        ContentHandler parser = parserFactory.createContentHandler(testFilter, null);

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(parser);
        xmlReader.parse(new InputSource(new StringReader(input)));

        assertSerialized(expect);
    }

    private void assertSerialized(String expect)
    {
        Assert.assertEquals(expect, this.stringWriter.toString());
    }

    // Tests

    @Test
    public void testContainer() throws Exception
    {
        assertParseAndSerialize("<container></container>");
    }

    @Test
    public void testContainerAndChild() throws Exception
    {
        assertParseAndSerialize("<container><child></child></container>");
    }

    @Test
    public void testContainerWithParameters() throws Exception
    {
        assertParseAndSerialize("<containerWithParameters param0=\"value0\" param1=\"1\"></containerWithParameters>");
    }

    @Test
    public void testContainerWithNamedParameters() throws Exception
    {
        assertParseAndSerialize("<containerWithNamedParameters namedParam=\"value0\" param1=\"1\"></containerWithNamedParameters>");
    }

    @Test
    public void testContainerWithMap() throws Exception
    {
        assertParseAndSerialize("<containerWithMap><p><map><entry><string>key</string><int>1</int></entry></map></p></containerWithMap>");
        assertParseAndSerialize(
            "<containerWithMap><p><map><entry><string>key</string><int>1</int></entry></map></p></containerWithMap>",
            "<containerWithMap><p><_0><entry><string>key</string><int>1</int></entry></_0></p></containerWithMap>");
    }

    @Test
    public void testCustomData() throws Exception
    {
        assertParseAndSerializeFromSAX("<customData><p><custom><field1>5</field1></custom></p></customData>");
        assertParseAndSerializeFromSAX("<customData></customData>");
    }

    @Test
    public void testFromSAX() throws Exception
    {
        assertParseAndSerializeFromSAX("<containerWithNamedParameters namedParam=\"value0\" param1=\"1\"></containerWithNamedParameters>");
    }

    // Serialize

    @Test
    public void testSerializeExtendedTestData() throws ComponentLookupException, XMLStreamException,
        FactoryConfigurationError
    {
        TestFilter testFilter = createFilter();

        ExtendedTestData extendedTestData = new ExtendedTestData();

        testFilter.beginCustomData(extendedTestData);
        testFilter.endCustomData(extendedTestData);

        assertSerialized("<customData><p><custom><field1>1</field1></custom></p></customData>");
    }

    @Test
    public void testSerializeWithDefaultValue() throws ComponentLookupException, XMLStreamException,
        FactoryConfigurationError
    {
        TestFilter testFilter = createFilter();

        testFilter.onChildWithDefaultValue(42, "default value", Color.WHITE, Collections.EMPTY_MAP);

        assertSerialized("<childWithDefaultValue></childWithDefaultValue>");
    }

    @Test
    public void testSerializeWithNamedChild() throws ComponentLookupException, XMLStreamException,
        FactoryConfigurationError
    {
        TestFilter testFilter = createFilter();

        testFilter.onNamedChild();

        assertSerialized("<childwithname></childwithname>");
    }
}
