package com.mwplugin.api;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.mwplugin.apitypes.Article;
import com.mwplugin.apitypes.ArticleFactory;
import com.mwplugin.apitypes.Citation;
import com.mwplugin.apitypes.INamedApiElement;
import com.mwplugin.apitypes.template.IApiResultFactory;
import com.mwplugin.apitypes.template.Template;
import com.mwplugin.apitypes.template.TemplateFactory;
import com.mwplugin.apitypes.template.TemplateSearchResult;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import static org.apache.commons.httpclient.params.HttpMethodParams.USER_AGENT;

/**
 * Created by andrewsimmons on 4/26/17.
 */
public class WPApiManager
{

	public static String getPageContent(String page) throws IOException
	{
		String url = "query&titles="+URLEncoder.encode(page, "UTF-8")+"&prop=revisions&rvprop=content&format=json";
		LinkedTreeMap<String, LinkedTreeMap> object = (LinkedTreeMap<String, LinkedTreeMap>) makeWPApiCall(url, new Object());
//		System.out.println(object);
		LinkedTreeMap<String, LinkedTreeMap> query = (LinkedTreeMap<String, LinkedTreeMap>) object.get("query");
		LinkedTreeMap<String, LinkedTreeMap> pages = query.get("pages");
		Object firstKey = pages.keySet().toArray()[0];
		LinkedTreeMap firstPageObject = pages.get(firstKey);
		ArrayList revisions = ((LinkedTreeMap<String, ArrayList>) firstPageObject).get("revisions");
		LinkedTreeMap<String, String> firstRevision = (LinkedTreeMap<String, String>) revisions.get(0);
		String pageContent = (String) firstRevision.get("*");
		return pageContent;
	}

	public static String getCitationFromURL(String url)
	{
		try
		{
			String apiUrl = "https://en.wikipedia.org/api/rest_v1/data/citation/mediawiki/" + URLEncoder.encode(url, "UTF-8");
//			ArrayList<Citation> citations = (ArrayList<Citation>) makeApiCall(apiUrl, new ArrayList<Citation>());
			String response = fetchResponseFromURL(apiUrl);

			Gson gson = new Gson();
			Type collectionType = new TypeToken<Collection<Citation>>(){}.getType();
			ArrayList<Citation> citations = gson.fromJson(response, collectionType);

			return citations.get(0).getMediaWikiText();

		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Template getTemplate(String name)
	{
		try
		{
			String url = "templatedata&format=json&redirects=1&titles=Template:"+URLEncoder.encode(name, "UTF-8");
			TemplateSearchResult searchResult = (TemplateSearchResult) makeWPApiCall(url, new TemplateSearchResult());
			Object[] keySet = searchResult.pages.keySet().toArray();
			Template template = searchResult.pages.get(keySet[0]);
			return template;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
//	public static <T extends PsiElement> T getParentOfType(@Nullable PsiElement element, @NotNull Class<T> aClass) {
	@Nullable
	@Contract("null, _ -> null")
	public static <T extends INamedApiElement> Collection<T> retrieveSuggestions(String inputText, IApiResultFactory factory, int numberResults, @NotNull Class<T> aClass)
	{
		try
		{
			String url = "opensearch&format=json&search="+inputText+"&limit="+numberResults;
			ArrayList results = (ArrayList) makeWPApiCall(url, new ArrayList());
			ArrayList<String> matches = (ArrayList<String>) results.get(1);
			ArrayList<T> items = new ArrayList<>();
			for(String name : matches)
			{
				T item = (T) factory.createInstance(name);
				items.add(item);
			}
			return items;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}


	public static Collection<Article> retriveArticleSuggestions(String input)
	{
		try
		{
			return retrieveSuggestions(URLEncoder.encode(input, "UTF-8"), new ArticleFactory(), 10, Article.class);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Collection<Template> retrieveTemplateSuggestions(String inputText)
	{
		try
		{
			Collection<Template> templates = retrieveSuggestions("Template:" + URLEncoder.encode(inputText, "UTF-8"), new TemplateFactory(), 10, Template.class);
			return templates;
		} catch (UnsupportedEncodingException e)
		{


		}
		return null;
	}

	public static Object makeApiCall(String fullQueryString, Object object) throws IOException
	{
		String response = fetchResponseFromURL(fullQueryString);


		Gson gson = new Gson();
		object = gson.fromJson(response, object.getClass());
		return object;
	}

	@NotNull
	private static String fetchResponseFromURL(String fullQueryString) throws IOException
	{
		HttpURLConnection con = null;
		URL obj = null;

		obj = new URL(fullQueryString);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + fullQueryString);
		System.out.println("Response Code : " + responseCode);
		Map<String, List<String>> headerFields = con.getHeaderFields();
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		return response.toString();
	}

	public static Object makeWPApiCall(String queryString, Object object) throws IOException
	{
		String url = "https://en.wikipedia.org/w/api.php?action=" + queryString;
		return makeApiCall(url, object);
	}

}
