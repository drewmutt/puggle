package com.mwplugin.psi.impl;


import com.intellij.extapi.psi.ASTWrapperPsiElement;
		import com.intellij.lang.ASTNode;
		import com.mwplugin.psi.IMediaWikiNamedElement;
		import org.jetbrains.annotations.NotNull;

public abstract class MediaWikiNamedElementImpl extends ASTWrapperPsiElement implements IMediaWikiNamedElement
{
	public MediaWikiNamedElementImpl(@NotNull ASTNode node) {
		super(node);
	}
}
