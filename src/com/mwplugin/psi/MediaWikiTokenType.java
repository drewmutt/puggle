package com.mwplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.mwplugin.MediaWikiLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiTokenType extends IElementType
{
	public MediaWikiTokenType(@NotNull @NonNls String debugName)
	{
		super(debugName, MediaWikiLanguage.INSTANCE);
	}

	@Override
	public String toString()
	{
		return "MediaWikiTokenType." + super.toString();
	}
}
