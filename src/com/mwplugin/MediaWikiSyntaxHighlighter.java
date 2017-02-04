package com.mwplugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.HashMap;
import com.mwplugin.psi.MediaWikiTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MediaWikiSyntaxHighlighter extends SyntaxHighlighterBase
{

	private HashMap<String, TextAttributesKey[]> keysMap;
	void addNewKey(IElementType type, TextAttributesKey textKey)
	{
		String name = type.toString();

		TextAttributesKey key = createTextAttributesKey("MW_"+name, textKey);
		TextAttributesKey[] keys = new TextAttributesKey[]{key};
		keysMap.put(type.toString(), keys);
	}

	TextAttributesKey[] getKeys(IElementType type)
	{
		return keysMap.get(type.toString());
	}

	public TextAttributesKey getKey(IElementType type)
	{
		return keysMap.get(type.toString())[0];
	}
	public MediaWikiSyntaxHighlighter()
	{
		keysMap = new HashMap<>();
		addNewKey(MediaWikiTypes.CONTENT, HighlighterColors.TEXT);
		addNewKey(MediaWikiTypes.LINK, DefaultLanguageHighlighterColors.STRING);
		addNewKey(MediaWikiTypes.TEMPLATE, DefaultLanguageHighlighterColors.CONSTANT);
		addNewKey(MediaWikiTypes.BOLD, DefaultLanguageHighlighterColors.METADATA);
		addNewKey(MediaWikiTypes.COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
		addNewKey(MediaWikiTypes.HEADER, DefaultLanguageHighlighterColors.KEYWORD);
		addNewKey(MediaWikiTypes.SUBHEADER, DefaultLanguageHighlighterColors.SEMICOLON);
		addNewKey(MediaWikiTypes.REFERENCE, DefaultLanguageHighlighterColors.NUMBER);

		TextAttributes defaultAttributes = DefaultLanguageHighlighterColors.KEYWORD.getDefaultAttributes().clone();
		defaultAttributes.setFontType(Font.ITALIC);
		TextAttributesKey key = createTextAttributesKey("hoogie boogie", defaultAttributes);
		addNewKey(MediaWikiTypes.ITALIC, key);
	}

	private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


	@NotNull
	@Override
	public Lexer getHighlightingLexer()
	{
		return new MediaWikiLexerAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		TextAttributesKey[] keys = getKeys(tokenType);
		if(keys == null)
			return EMPTY_KEYS;
		else
			return keys;
	}
}