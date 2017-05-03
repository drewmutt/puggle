package com.mwplugin.dialogs;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBColor;
import com.intellij.ui.TextFieldWithAutoCompletion;
import com.intellij.ui.TextFieldWithAutoCompletionListProvider;
import com.intellij.ui.components.JBPanel;
import com.mwplugin.template.Template;
import com.mwplugin.template.TemplateSearchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.net.URLEncoder;
import java.util.*;

import javax.swing.*;

import static com.mwplugin.api.WPApiManager.makeApiCall;

public class InsertTemplate extends DialogWrapper
{
	private JPanel contentPane;
	private Project project;
	private TextFieldWithAutoCompletion<Template> _textField;
	public Template selectedTemplate;
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
			String url = "templatedata&format=json&titles=Template%3AUserbox";
			TemplateSearchResult searchResult = (TemplateSearchResult) makeApiCall(url, new TemplateSearchResult());
			selectedTemplate = searchResult.pages.get(0);
//			selectedTemplate.name = _textField.getText();
//			selectedTemplate.content = pageContent;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel()
	{
		JBPanel panel = new JBPanel();

		Collection<Template> templates = new ArrayList<>();
		for(int i = 0; i < 20; i++)
		{
			Template template = new Template();
			template.title = "Hi " + i;
			templates.add(template);
		}

		TextFieldWithAutoCompletionListProvider<Template> listprovider = new TextFieldWithAutoCompletionListProvider<Template>(templates)
		{
			@NotNull
			@Override
			protected String getLookupString(@NotNull Template item)
			{
				return item.title;
			}


		};



		try
		{
			TextFieldWithAutoCompletion<Template> textField = new TextFieldWithAutoCompletion<>(project, listprovider, true, "HOT DAWG!");
			_textField = textField;
			panel.add(textField, new BorderLayout(0, 0));
			panel.setBackground(JBColor.BLUE);
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
							Collection<Template> templates1 = retrieveTemplateSuggestions(textField.getText());
							textField.setVariants(templates1);
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


	private Collection<Template> retrieveTemplateSuggestions(String inputText)
	{
		try
		{
			String url = "opensearch&format=json&search=Template:"+ URLEncoder.encode(inputText, "UTF-8")+"&limit=10";
			ArrayList results = (ArrayList) makeApiCall(url, new ArrayList());
			ArrayList<String> matches = (ArrayList<String>) results.get(1);
			ArrayList<Template> templates = new ArrayList<>();
			for(String name : matches)
			{
				Template template = new Template();
				//Strip out "Template:"
				template.title = name.substring(9);
				templates.add(template);
			}
			return templates;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
