package com.mwplugin;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.containers.HashMap;
import com.mwplugin.psi.MediaWikiLevel4Heading;
import com.mwplugin.psi.MediaWikiReferenceBlock;
import com.mwplugin.psi.impl.MediaWikiLevel4HeadingImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class MediaWikiAnnotator implements Annotator
{
	private HashMap<Class, TextAttributesKey> keysMap;
	public MediaWikiAnnotator()
	{
		super();
		keysMap = new HashMap<>();
		keysMap.put(MediaWikiLevel4Heading.class, DefaultLanguageHighlighterColors.NUMBER);
		keysMap.put(MediaWikiReferenceBlock.class, DefaultLanguageHighlighterColors.CONSTANT);


	}
	@Override
	public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder)
	{

//		if (element instanceof MediaWikiLevel4Heading)
//		{
//			PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
//			String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

//			if (value != null && value.startsWith("MediaWiki" + ":"))
//			{
//			Project project = element.getProject();
//				String key = value.substring(7);
//				List<MediaWikiProperty> properties = MediaWikiUtil.findProperties(project, key);
//				if (properties.size() == 1)
//				{
		for (Map.Entry<Class, TextAttributesKey> entry : keysMap.entrySet())
		{
			if(entry.getKey().isInstance(element))
			{
				TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
				Annotation annotation = holder.createInfoAnnotation(range, null);
				annotation.setTextAttributes(entry.getValue());
			}
		}
//				}
//				else if (properties.size() == 0)
//				{
//					TextRange range = new TextRange(element.getTextRange().getStartOffset() + 8, element.getTextRange().getEndOffset());
//					holder.createErrorAnnotation(range, "Unresolved property").
//							registerFix(new CreatePropertyQuickFix(key));
//		}
	}


}
