package com.mwplugin.apitypes.template;

import java.util.HashMap;

import static com.mwplugin.api.WPApiManager.getTemplate;

/**
 * Created by andrewsimmons on 4/26/17.
 */
public class TemplateCache
{
	private HashMap<String, Template> templateMap = new HashMap<>();

	private static TemplateCache instance = new TemplateCache();

	private TemplateCache() { }

	public static TemplateCache getInstance( ) {
		return instance;
	}

	public Template getTemplateFromCacheByKey(String key)
	{
		return templateMap.get(key);
	}

	public void commitTemplate(Template template)
	{
		templateMap.put(template.title, template);
	}

	public Template syncFetchTemplate(String templateName)
	{
		Template templateFromCacheByKey = getTemplateFromCacheByKey(templateName);
		if(templateFromCacheByKey != null)
			return templateFromCacheByKey;

		Template template = getTemplate(templateName);
		commitTemplate(template);
		return template;
	}
}
