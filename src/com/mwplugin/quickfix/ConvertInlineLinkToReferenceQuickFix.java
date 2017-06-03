package com.mwplugin.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 5/26/17.
 */
public class ConvertInlineLinkToReferenceQuickFix extends BaseIntentionAction
{
	@Nls
	@NotNull
	@Override
	public String getFamilyName()
	{
		return null;
	}

	@Override
	public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file)
	{
		return false;
	}

	@Override
	public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException
	{

	}
}
