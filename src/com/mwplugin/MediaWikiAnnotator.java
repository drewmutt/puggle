package com.mwplugin;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.mwplugin.psi.MediaWikiReference;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MediaWikiAnnotator implements Annotator
{
	@Override
	public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder)
	{
		if (element instanceof MediaWikiReference)
		{
//			PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
//			String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

//			if (value != null && value.startsWith("MediaWiki" + ":"))
//			{
//			Project project = element.getProject();
//				String key = value.substring(7);
//				List<MediaWikiProperty> properties = MediaWikiUtil.findProperties(project, key);
//				if (properties.size() == 1)
//				{
			TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
			Annotation annotation = holder.createInfoAnnotation(range, null);
			annotation.setTextAttributes(DefaultLanguageHighlighterColors.NUMBER);
//				}
//				else if (properties.size() == 0)
//				{
//					TextRange range = new TextRange(element.getTextRange().getStartOffset() + 8, element.getTextRange().getEndOffset());
//					holder.createErrorAnnotation(range, "Unresolved property").
//							registerFix(new CreatePropertyQuickFix(key));
		}
	}
}
