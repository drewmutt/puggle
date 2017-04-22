package com.mwplugin.actions;

import java.util.List;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public interface SearchResultsSearchSuggestion  extends com.intellij.util.xml.DomElement
{
	List<SearchResultsSection> getSections();
}
