package com.mwplugin.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.*;
import com.intellij.ide.util.FileStructureFilter;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.mwplugin.psi.*;
import com.mwplugin.psi.impl.MediaWikiExternalLinkImpl;
import com.mwplugin.psi.impl.MediaWikiInternalLinkImpl;
import com.mwplugin.psi.impl.MediaWikiTableImpl;
import com.mwplugin.psi.impl.MediaWikiTemplateBlockImpl;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MediaWikiStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider, StructureViewModel.ExpandInfoProvider {
	public MediaWikiStructureViewModel(PsiFile psiFile) {
		super(psiFile, new MediaWikiStructureViewElement(psiFile));
	}

	@NotNull
	public Sorter[] getSorters() {
		return new Sorter[]{new MediaWikiStructureViewSorter()};
	}


	@Override
	public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
		return false;
	}

	@Override
	public boolean isAlwaysLeaf(StructureViewTreeElement element) {
		return element instanceof MediaWikiFile;
	}



	@NotNull
	@Override
	public Filter[] getFilters()
	{
		MediaWikiFileStructureFilter filter1 = new MediaWikiFileStructureFilter("Internal Links", MediaWikiInternalLinkImpl.class, AllIcons.Nodes.Annotationtype);
		MediaWikiFileStructureFilter filter2 = new MediaWikiFileStructureFilter("External Links", MediaWikiExternalLinkImpl.class, AllIcons.Nodes.Deploy);
		MediaWikiFileStructureFilter filter3 = new MediaWikiFileStructureFilter("Templates", MediaWikiTemplateBlockImpl.class, AllIcons.Nodes.ExceptionClass);
		MediaWikiFileStructureFilter filter4 = new MediaWikiFileStructureFilter("Tables", MediaWikiTableImpl.class, AllIcons.Nodes.DataTables);
		return new Filter[]{filter1, filter2, filter3, filter4};
	}

	@Override
	public boolean isAutoExpand(@NotNull StructureViewTreeElement element)
	{
		return element instanceof MediaWikiFile;
	}

	@Override
	public boolean isSmartExpand()
	{
		return false;
	}
}