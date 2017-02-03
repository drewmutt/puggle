package com.mwplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiFileType extends LanguageFileType
{
	public static final MediaWikiFileType INSTANCE = new MediaWikiFileType();

	private MediaWikiFileType()
	{
		super(MediaWikiLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName()
	{
		return "MediaWiki file";
	}

	@NotNull
	@Override
	public String getDescription()
	{
		return "MediaWiki Markup File";
	}

	@NotNull
	@Override
	public String getDefaultExtension()
	{
		return "mediawiki";
	}

	@Nullable
	@Override
	public Icon getIcon()
	{
		return MediaWikiIcons.FILE;
	}
}