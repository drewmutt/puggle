package com.mwplugin.psi;



import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.mwplugin.MediaWikiLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 3/27/17.
 */
public class ReferenceNode extends IElementType
{
	public ReferenceNode(@NotNull @NonNls String debugName)
	{
		super(debugName, MediaWikiLanguage.INSTANCE);
	}

	@Override
	public String toString()
	{
		return "ReferenceNode." + super.toString();
	}
}


