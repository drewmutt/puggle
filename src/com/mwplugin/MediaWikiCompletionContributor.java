package com.mwplugin;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.mwplugin.api.WPApiManager;
import com.mwplugin.psi.MediaWikiTemplateBlock;
import com.mwplugin.psi.MediaWikiTemplateName;
import com.mwplugin.psi.MediaWikiTemplatePropertyName;
import com.mwplugin.psi.MediaWikiTypes;
import com.mwplugin.apitypes.template.Template;
import com.mwplugin.apitypes.template.TemplateCache;
import com.mwplugin.apitypes.template.TemplateParameter;
import com.mwplugin.apitypes.template.TemplateUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by andrewsimmons on 4/26/17.
 */
public class MediaWikiCompletionContributor extends CompletionContributor
{
	private static final char DUMMY_IDENTIFIER = ' ';
	@Override
	public void beforeCompletion(@NotNull CompletionInitializationContext context) {
		context.setDummyIdentifier(String.valueOf(DUMMY_IDENTIFIER));

//		context.getOffsetMap().addOffset(SELECTION_END_OFFSET, 0);
//		context.getOffsetMap().addOffset(START_OFFSET, 0);
//		context.getOffsetMap().addOffset(IDENTIFIER_END_OFFSET, 0);
//		context.setReplacementOffset();


		int replacementOffset = context.getReplacementOffset();
		int startOffset = context.getStartOffset();
		int selectionEndOffset = context.getSelectionEndOffset();
		int  identifierEndOffset = context.getIdentifierEndOffset();

//		System.out.println(replacementOffset );
//		System.out.println(startOffset );
//		System.out.println(selectionEndOffset );
//		System.out.println(identifierEndOffset );
	}


	public MediaWikiCompletionContributor()
	{
		extend(CompletionType.BASIC, PlatformPatterns.psiElement().inside(PlatformPatterns.psiElement(MediaWikiTypes.TEMPLATE_NAME)).withLanguage(MediaWikiLanguage.INSTANCE), new CompletionProvider<CompletionParameters>()
		{
			public void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet resultSet)
			{
				final PsiElement currentPsi = parameters.getPosition();
				MediaWikiTemplateName templateNamePsi = PsiTreeUtil.getParentOfType(currentPsi, MediaWikiTemplateName.class);
				String text = templateNamePsi.getText().trim();

				if(text.length() > 2)
				{
					Collection<Template> templates = WPApiManager.retrieveTemplateSuggestions(text);
					ArrayList<String> namesOfAllTemplates = TemplateUtil.getNamesOfAllTemplates(templates);
					for(String name : namesOfAllTemplates)
					{
						LookupElementBuilder element = LookupElementBuilder.create(name);
						LookupElementBuilder element2 = element.withInsertHandler(new BasicInsertHandler<LookupElement>()
						{
							@Override
							public void handleInsert(InsertionContext context, LookupElement item)
							{
								PsiElement elementAt = context.getFile().findElementAt(context.getStartOffset());

								MediaWikiTemplateName parentOfType = PsiTreeUtil.getParentOfType(elementAt, MediaWikiTemplateName.class);
								parentOfType.delete();


								EditorModificationUtil.insertStringAtCaret(context.getEditor(), item.getLookupString());
								context.commitDocument();
							}
						});
						resultSet.addElement(element2);
					}
				}
			}



		});


		extend(CompletionType.BASIC, PlatformPatterns.psiElement().inside(PlatformPatterns.psiElement(MediaWikiTypes.TEMPLATE_PROPERTY_NAME)).withLanguage(MediaWikiLanguage.INSTANCE), new CompletionProvider<CompletionParameters>()
		{
			public void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet resultSet)
			{
				MediaWikiTemplateBlock templateBlock = PsiTreeUtil.getParentOfType(parameters.getPosition(), MediaWikiTemplateBlock.class);
				MediaWikiTemplatePropertyName templatePropertyName = PsiTreeUtil.getParentOfType(parameters.getPosition(), MediaWikiTemplatePropertyName.class);
				MediaWikiTemplateName childOfType = PsiTreeUtil.getChildOfType(templateBlock, MediaWikiTemplateName.class);
				String templateName = childOfType.getText().trim();

				Template template = TemplateCache.getInstance().syncFetchTemplate(templateName);
				ArrayList<String> namesOfAllProperties = TemplateUtil.getNamesOfAllProperties(template);

				String text = templatePropertyName.getText();
				resultSet = resultSet.withPrefixMatcher(text);
				Set<String> params = template.params.keySet();
				for(String paramName : params)
				{
					Icon icon = null;
					TemplateParameter param = template.params.get(paramName);
					LookupElementBuilder lookupElement = LookupElementBuilder.create(paramName);
					if(param.required.equals("true"))
					{
						lookupElement = lookupElement.bold();
					}

					if(param.type.equals("string"))
					{
						icon=AllIcons.Nodes.Static;
					}
					else if(param.type.equals("number"))
					{
						icon=AllIcons.Nodes.Variable;
					}
					else if(param.type.equals("boolean"))
					{
						icon=AllIcons.Nodes.ClassInitializer;
					}

					lookupElement = lookupElement.withTypeText(param.type, icon, true);
					resultSet.addElement(lookupElement);
				}
			}

		});
	}


}