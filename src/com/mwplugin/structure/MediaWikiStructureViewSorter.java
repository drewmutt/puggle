package com.mwplugin.structure;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.ide.util.treeView.smartTree.SorterUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by andrewsimmons on 5/4/17.
 */
public class MediaWikiStructureViewSorter implements Sorter
{
	@Override
	public Comparator getComparator()
	{
		return (o1, o2) -> {
			String s1 = SorterUtil.getStringPresentation(o1);
			String s2 = SorterUtil.getStringPresentation(o2);
			return s1.compareToIgnoreCase(s2);
		};
	}

	@Override
	public boolean isVisible()
	{
		return false;
	}

	@NotNull
	@Override
	public ActionPresentation getPresentation()
	{
		return null;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Location";
	}
}
