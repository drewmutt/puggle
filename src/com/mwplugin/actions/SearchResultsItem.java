package com.mwplugin.actions;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public interface SearchResultsItem  extends com.intellij.util.xml.DomElement
{
	String getText();
	String getUrl();
	String getDescription();
}
