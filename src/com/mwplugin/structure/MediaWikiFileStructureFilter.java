package com.mwplugin.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.FileStructureFilter;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.openapi.actionSystem.Shortcut;
import com.mwplugin.psi.impl.MediaWikiInternalLinkImpl;
import com.mwplugin.psi.impl.MediaWikiNamedElementImpl;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by andrewsimmons on 5/4/17.
 */
public class MediaWikiFileStructureFilter implements FileStructureFilter
{
	private String name;
	private Class  filterClass;
	private Icon icon;

	public MediaWikiFileStructureFilter(String name, Class filterClass, Icon icon)
	{
		this.name = name;
		this.filterClass = filterClass;
		this.icon = icon;
	}

	@NotNull
	@Override
	public String getCheckBoxText()
	{
		return name;
	}

	@NotNull
	@Override
	public Shortcut[] getShortcut()
	{
		return new Shortcut[0];
	}

	@Override
	public boolean isVisible(TreeElement treeNode)
	{
		Object value = ((MediaWikiStructureViewElement) treeNode).getValue();
		return !filterClass.isInstance(value);
	}

	@Override
	public boolean isReverted()
	{
		return true;
	}

	@NotNull
	@Override
	public ActionPresentation getPresentation()
	{
		return new ActionPresentation()
		{
			@NotNull
			@Override
			public String getText()
			{
				return name;
			}

			@Override
			public String getDescription()
			{
				return name;
			}

			@Override
			public Icon getIcon()
			{
				return icon;
			}
		};
	}

	@NotNull
	@Override
	public String getName()
	{
		return name;
	}
}
