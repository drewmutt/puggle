package com.mwplugin;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.mwplugin.psi.MediaWikiTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by andrewsimmons on 5/2/17.
 */
public class MediaWikiPairedBraceMatcher implements PairedBraceMatcher
{
	@Override
	public BracePair[] getPairs()
	{
		BracePair[] pairs = new BracePair[4];
		pairs[0] = new BracePair(MediaWikiTypes.curlyopen2, MediaWikiTypes.curlyclose2, true);
		pairs[1] = new BracePair(MediaWikiTypes.tablestart, MediaWikiTypes.tableend, true);
		pairs[2] = new BracePair(MediaWikiTypes.refopencomplete, MediaWikiTypes.refclose, true);
		pairs[3] = new BracePair(MediaWikiTypes.openbracket2, MediaWikiTypes.closebracket2, true);
		return pairs;
	}

	@Override
	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType)
	{
		return false;
	}

	@Override
	public int getCodeConstructStart(PsiFile file, int openingBraceOffset)
	{
		return 0;
	}
}
