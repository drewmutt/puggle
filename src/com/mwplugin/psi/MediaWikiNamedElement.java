package com.mwplugin.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 2/3/17.
 */
public class MediaWikiNamedElement extends ASTWrapperPsiElement
{
	public MediaWikiNamedElement(@NotNull ASTNode node)
	{
		super(node);
	}
}
