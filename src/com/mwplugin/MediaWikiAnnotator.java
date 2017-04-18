package com.mwplugin;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.containers.HashMap;
import com.mwplugin.psi.*;
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
		keysMap.put(MediaWikiLevel2Heading.class, DefaultLanguageHighlighterColors.KEYWORD);
		keysMap.put(MediaWikiLevel3Heading.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER"));
		keysMap.put(MediaWikiLevel4Heading.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER2"));
		keysMap.put(MediaWikiLevel5Heading.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER3"));
		keysMap.put(MediaWikiInternalLink.class, DefaultLanguageHighlighterColors.STRING);
		keysMap.put(MediaWikiBoldText.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_BOLD"));
		keysMap.put(MediaWikiItalicText.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_ITALIC"));
		keysMap.put(MediaWikiHtmlComment.class, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
		keysMap.put(MediaWikiReferenceBlock.class, DefaultLanguageHighlighterColors.CONSTANT);
		keysMap.put(MediaWikiTemplateBlock.class, DefaultLanguageHighlighterColors.NUMBER);

//				/		addNewKey(MediaWikiTypes.CONTENT, HighlighterColors.TEXT);
//		addNewKey(MediaWikiTypes.LINK, DefaultLanguageHighlighterColors.STRING);
//		addNewKey(MediaWikiTypes.TEMPLATE, DefaultLanguageHighlighterColors.CONSTANT);
//		addNewKey(MediaWikiTypes.BOLD, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_BOLD"));
//		addNewKey(MediaWikiTypes.COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
//		addNewKey(MediaWikiTypes.HEADER, DefaultLanguageHighlighterColors.KEYWORD);
//		keysMap.put(MediaWikiReferenceBlock.class, DefaultLanguageHighlighterColors.CONSTANT);


		//		addNewKey(MediaWikiTypes.SUBHEADER, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER"));
//		addNewKey(MediaWikiTypes.SUBHEADER2, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER2"));
//		addNewKey(MediaWikiTypes.SUBHEADER3, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_SUBHEADER3"));

//		addNewKey(MediaWikiTypes.REFERENCE_TOKEN, DefaultLanguageHighlighterColors.NUMBER);

//		TextAttributesKey MEDIAWIKI_ITALIC = TextAttributesKey.createTextAttributesKey("MEDIAWIKI_ITALIC");


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
