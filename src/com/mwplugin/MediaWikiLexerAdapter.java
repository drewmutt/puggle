package com.mwplugin;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.LayeredLexer;

import java.io.Reader;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiLexerAdapter extends FlexAdapter
{
	public MediaWikiLexerAdapter()
	{
		super(new MediaWikiLexer((Reader) null));

	}
}
