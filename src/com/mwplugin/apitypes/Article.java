package com.mwplugin.apitypes;

/**
 * Created by andrewsimmons on 5/8/17.
 */
public class Article implements INamedApiElement
{
	public String title;

	public Article(String name)
	{
		title = name;
	}

	@Override
	public void setName(String name)
	{
		title = name;
	}

	@Override
	public String getName()
	{
		return title;
	}
}
