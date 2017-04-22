package com.mwplugin;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBColor;
import com.intellij.ui.TextFieldWithAutoCompletion;
import com.intellij.ui.TextFieldWithAutoCompletionListProvider;
import com.intellij.ui.components.JBPanel;
import com.intellij.util.xml.DomManager;
import com.mwplugin.actions.SearchResultsSearchSuggestion;
import com.mwplugin.actions.Template;
import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import static org.apache.commons.httpclient.params.HttpMethodParams.USER_AGENT;

public class InsertTemplate extends DialogWrapper
{
	private JPanel contentPane;
	private Project project;

	public InsertTemplate(Project pro)
	{
		super(pro);
		project = pro;
		init();
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
			template.name = "Hi " + i;
			templates.add(template);
		}

		TextFieldWithAutoCompletionListProvider<Template> listprovider = new TextFieldWithAutoCompletionListProvider<Template>(templates)
		{
			@NotNull
			@Override
			protected String getLookupString(@NotNull Template item)
			{
				return item.name;
			}
		};



		try
		{
			TextFieldWithAutoCompletion<Template> textField1 = new TextFieldWithAutoCompletion<>(project, listprovider, true, "HOT DAWG!");

			panel.add(textField1, new BorderLayout(0, 0));
			panel.setBackground(JBColor.BLUE);
			textField1.getDocument().addDocumentListener(new DocumentListener()
			{
				@Override
				public void beforeDocumentChange(DocumentEvent event)
				{

				}

				@Override
				public void documentChanged(DocumentEvent event)
				{
					retrieveTemplateSuggestions(textField1.getText());
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
		String url = "https://en.wikipedia.org/w/api.php?action=opensearch&format=xml&search=hey&limit=10";
		HttpURLConnection con = null;
		URL obj = null;
		try
		{
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			Map<String, java.util.List<String>> headerFields = con.getHeaderFields();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}


			in.close();

			InputSource source = new InputSource(new StringReader(response.toString()));

			DocumentBuilderFactoryImpl dbf =new DocumentBuilderFactoryImpl();

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(source);

			NodeList itemList = document.getElementsByTagName("Item");
			System.out.println(response.toString());
		} catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		} catch (ProtocolException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		} catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		} catch (SAXException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
