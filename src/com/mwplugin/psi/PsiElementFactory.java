package com.mwplugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

/**
 * Created by andrewsimmons on 3/27/17.
 */
public interface PsiElementFactory
{
	PsiElement createElement(ASTNode node);
}


/**
 * This interface supports constructing a {@link PsiElement} from an {@link ASTNode}.
 */
