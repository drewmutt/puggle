package com.mwplugin.wikiconversion;


import com.intellij.uiDesigner.compiler.Utils;
import org.junit.Assert;
import org.xwiki.component.descriptor.ComponentDescriptor;
import org.xwiki.component.embed.EmbeddableComponentManager;
import org.xwiki.component.internal.RoleHint;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.rendering.converter.ConversionException;
import org.xwiki.rendering.converter.Converter;
import org.xwiki.rendering.renderer.printer.DefaultWikiPrinter;
import org.xwiki.rendering.renderer.printer.WikiPrinter;
import org.xwiki.rendering.syntax.Syntax;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by andrewsimmons on 2/7/17.
 */
public class WikiParser
{
	public String renderWikiText(String wikiText, String title)
	{
		// Initialize Rendering components and allow getting instances
/*
		EmbeddableComponentManager componentManager = new EmbeddableComponentManager("Fun");
		componentManager.initialize(this.getClass().getClassLoader());
		// Use the Converter component to convert between one syntax to another.
		Converter converter = null;
		try
		{
			converter = componentManager.getInstance(Converter.class);
		} catch (ComponentLookupException e)
		{
			e.printStackTrace();
		}*/
/*
		boolean b = componentManager.hasComponent(Converter.class);
// Convert input in XWiki Syntax 2.1 into XHTML. The result is stored in the printer.

		WikiPrinter printer = new DefaultWikiPrinter();
		try
		{
			StringReader reader = new StringReader(wikiText);
			Syntax mediawiki10 = Syntax.MEDIAWIKI_1_0;
			Syntax xhtml10 = Syntax.XHTML_1_0;
			converter.convert(reader, mediawiki10, xhtml10, printer);
		} catch (ConversionException e)
		{
			e.printStackTrace();
		}
*/
//		return printer.toString();
		return "";
	}
}
