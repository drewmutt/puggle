package com.mwplugin.apitypes.template;

import com.mwplugin.apitypes.INamedApiElement;

/**
 * Created by andrewsimmons on 5/8/17.
 */
public class TemplateFactory implements IApiResultFactory
{
	@Override
	public INamedApiElement createInstance(String name)
	{
		//Trim "Template:"
		Template template = new Template(name.substring(9));
		return template;
	}
}
