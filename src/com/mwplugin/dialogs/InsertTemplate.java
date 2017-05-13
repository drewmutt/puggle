package com.mwplugin.dialogs;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBColor;
import com.intellij.ui.TextFieldWithAutoCompletion;
import com.intellij.ui.TextFieldWithAutoCompletionListProvider;
import com.intellij.ui.components.JBPanel;
import com.mwplugin.api.WPApiManager;
import com.mwplugin.apitypes.Article;
import com.mwplugin.apitypes.INamedApiElement;
import com.mwplugin.apitypes.template.Template;
import com.mwplugin.apitypes.template.TemplateSearchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;

import static com.mwplugin.api.WPApiManager.makeApiCall;

public class InsertTemplate extends DialogWrapper
{
	private JPanel contentPane;
	private Project project;
	private TextFieldWithAutoCompletion<Article> _textField;
	public Article selectedArticle;
	public InsertTemplate(Project pro)
	{
		super(pro);
		project = pro;
		init();
	}

	@Override
	protected void doOKAction()
	{
		super.doOKAction();
		try
		{
			selectedArticle = new Article(_textField.getText());
//			String url = "templatedata&format=json&titles=Template%3AUserbox";
//			TemplateSearchResult searchResult = (TemplateSearchResult) makeApiCall(url, new TemplateSearchResult());
//			selectedArticle
//			selectedTemplate.name = _textField.getText();
//			selectedTemplate.content = pageContent;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Nullable
	@Override
	public JComponent getPreferredFocusedComponent()
	{
		return _textField;
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel()
	{
		JBPanel panel = new JBPanel();

		Collection<Article> articles = new ArrayList<>();

		TextFieldWithAutoCompletionListProvider<Article> listprovider = new TextFieldWithAutoCompletionListProvider<Article>(null)
		{
			@NotNull
			@Override
			protected String getLookupString(@NotNull Article item)
			{
				return item.getName();
			}

			@Nullable
			@Override
			protected InsertHandler<LookupElement> createInsertHandler(@NotNull Article item)
			{
				return new InsertHandler<LookupElement>()
				{
					@Override
					public void handleInsert(InsertionContext context, LookupElement item)
					{
						_textField.setText(item.getLookupString());
					}
				};
			}
		};



		try
		{
//			contentPane.add(panel, BorderLayout.PAGE_START);
			TextFieldWithAutoCompletion<Article> textField = new TextFieldWithAutoCompletion<Article>(project, listprovider, false, null);
			_textField = textField;
			panel.add(textField, BorderLayout.PAGE_START);


			panel.setLayout(new GridLayout());
			panel.add(_textField, BorderLayout.CENTER);
			panel.setVisible(true);
			_textField.setPlaceholder("Article name");
			_textField.setToolTipText("Article name");

			textField.getDocument().addDocumentListener(new DocumentListener()
			{
				@Override
				public void beforeDocumentChange(DocumentEvent event)
				{

				}


				@Override
				public void documentChanged(DocumentEvent event)
				{
					Runnable r = new Runnable() {
						public void run() {
							if(textField.getText().length() > 2)
							{
								Collection<Article> templates1 = retrieveTemplateSuggestions(textField.getText());
								textField.setVariants(templates1);
							}
						}
					};

					new Thread(r).start();
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return panel;
	}


	private Collection<Article> retrieveTemplateSuggestions(String inputText)
	{
		try
		{
			Collection<Article> articles = WPApiManager.retriveArticleSuggestions(inputText);
			return articles;
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
