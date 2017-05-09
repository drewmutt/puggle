package com.mwplugin.apitypes.template;

import com.mwplugin.apitypes.INamedApiElement;

/**
 * Created by andrewsimmons on 5/8/17.
 */
public interface IApiResultFactory
{
	public INamedApiElement createInstance(String name);
}
