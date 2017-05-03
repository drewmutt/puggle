package com.mwplugin.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by andrewsimmons on 4/26/17.
 */
public class TemplateUtil
{
	public static ArrayList<String> getNamesOfAllProperties(Template template)
	{
		Set<String> params = template.params.keySet();
		return new ArrayList<String>(params);
	}

	public static ArrayList<String> getNamesOfAllTemplates(Collection<Template> templates)
	{
		ArrayList<String> names = new ArrayList<>();
		for(Template template : templates)
		{
			names.add(template.title);
		}
		return names;
	}
}
