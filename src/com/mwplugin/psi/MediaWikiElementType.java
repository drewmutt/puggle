package com.mwplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.mwplugin.MediaWikiLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiElementType extends IElementType
{
	public MediaWikiElementType(@NotNull @NonNls String debugName)
	{
		super(debugName, MediaWikiLanguage.INSTANCE);
	}
}
