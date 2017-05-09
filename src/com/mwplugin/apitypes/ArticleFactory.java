package com.mwplugin.apitypes;

import com.mwplugin.apitypes.template.IApiResultFactory;

/**
 * Created by andrewsimmons on 5/8/17.
 */
public class ArticleFactory implements IApiResultFactory
{
	@Override
	public INamedApiElement createInstance(String name)
	{
		return new Article(name);
	}
}
