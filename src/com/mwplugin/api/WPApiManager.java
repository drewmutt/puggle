package com.mwplugin.api;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mwplugin.template.Template;
import com.mwplugin.template.TemplateSearchResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String url = "query&titles=Template:"+URLEncoder.encode(page, "UTF-8")+"&prop=revisions&rvprop=content&format=json";
		LinkedTreeMap<String, LinkedTreeMap> object = (LinkedTreeMap<String, LinkedTreeMap>) makeApiCall(url, new Object());
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

	public static Template getTemplate(String name)
	{
		try
		{
			String url = "templatedata&format=json&redirects=1&titles=Template:"+URLEncoder.encode(name, "UTF-8");
			TemplateSearchResult searchResult = (TemplateSearchResult) makeApiCall(url, new TemplateSearchResult());
			Object[] keySet = searchResult.pages.keySet().toArray();
			Template template = searchResult.pages.get(keySet[0]);
			return template;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public static Collection<Template> retrieveTemplateSuggestions(String inputText)
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

	public static Object makeApiCall(String queryString, Object object) throws IOException
	{
		String url = "https://en.wikipedia.org/w/api.php?action=" + queryString;
		HttpURLConnection con = null;
		URL obj = null;

		obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		Map<String, List<String>> headerFields = con.getHeaderFields();
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();
		Gson gson = new Gson();
		object = gson.fromJson(response.toString(), object.getClass());
		return object;
	}

}
