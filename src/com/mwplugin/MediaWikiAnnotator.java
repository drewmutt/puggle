package com.mwplugin;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.containers.HashMap;
import com.mwplugin.psi.*;
import org.jetbrains.annotations.NotNull;

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
		keysMap.put(MediaWikiLink.class, DefaultLanguageHighlighterColors.STRING);
		keysMap.put(MediaWikiBoldText.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_BOLD"));
		keysMap.put(MediaWikiItalicText.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_ITALIC"));
		keysMap.put(MediaWikiBoldItalicText.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_BOLD_ITALIC"));
		keysMap.put(MediaWikiHtmlComment.class, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
		keysMap.put(MediaWikiReferenceBlock.class, DefaultLanguageHighlighterColors.CONSTANT);
		keysMap.put(MediaWikiTemplateBlock.class, DefaultLanguageHighlighterColors.NUMBER);
		keysMap.put(MediaWikiCategoryLink.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_CATEGORY"));

		keysMap.put(MediaWikiTableEnd.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableRowStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableHeaderRowStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableSectionStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableCellDoubleDelimitedStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));
		keysMap.put(MediaWikiTableHeaderDoubleDelimitedStart.class, TextAttributesKey.createTextAttributesKey("MEDIAWIKI_TABLE"));


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

/*
		MediaWikiTable table = PsiTreeUtil.getParentOfType(element, MediaWikiTable.class);
		if(table != null)
		{
			MediaWikiTableRow myRow = PsiTreeUtil.getParentOfType(element, MediaWikiTableRow.class);
			if(myRow != null)
			{
				MediaWikiTableBlock myBlock = PsiTreeUtil.getParentOfType(element, MediaWikiTableBlock.class);
				int childNumber = -1;
				PsiElement[] children = myBlock.getChildren();
				for (int i = 0; i < children.length; i++)
				{
					if (children[i] == myRow)
					{
						childNumber = i;
						break;
					}
				}

				MediaWikiTableBlock[] allBlocks = PsiTreeUtil.getChildrenOfType(table, MediaWikiTableBlock.class);
				for (int i = 0; i < allBlocks.length; i++)
				{
					MediaWikiTableBlock block = allBlocks[i];
					PsiElement[] blockChildren = block.getChildren();
					if (blockChildren.length >= childNumber)
					{
						PsiElement blockChild = blockChildren[childNumber];
						TextRange range = new TextRange(blockChild.getTextRange().getStartOffset(), blockChild.getTextRange().getEndOffset());
						Annotation annotation = holder.createInfoAnnotation(range, null);
						annotation.setTextAttributes(DefaultLanguageHighlighterColors.IDENTIFIER);
					}
				}
			}
		}*/
//				}
//				else if (properties.size() == 0)
//				{
//					TextRange range = new TextRange(element.getTextRange().getStartOffset() + 8, element.getTextRange().getEndOffset());
//					holder.createErrorAnnotation(range, "Unresolved property").
//							registerFix(new CreatePropertyQuickFix(key));
//		}
	}


}
