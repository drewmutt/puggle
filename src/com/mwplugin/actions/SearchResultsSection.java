package com.mwplugin.actions;

import java.util.List;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public interface SearchResultsSection  extends com.intellij.util.xml.DomElement
{
	List<SearchResultsItem> getItems();
}
