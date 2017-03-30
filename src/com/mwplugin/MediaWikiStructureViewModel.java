package com.mwplugin;

import com.intellij.ide.structureView.*;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import com.mwplugin.psi.MediaWikiFile;
import org.jetbrains.annotations.NotNull;

public class MediaWikiStructureViewModel extends StructureViewModelBase implements
		StructureViewModel.ElementInfoProvider {
	public MediaWikiStructureViewModel(PsiFile psiFile) {
		super(psiFile, new MediaWikiStructureViewElement(psiFile));
	}

	@NotNull
	public Sorter[] getSorters() {
		return new Sorter[]{Sorter.ALPHA_SORTER};
	}


	@Override
	public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
		return false;
	}

	@Override
	public boolean isAlwaysLeaf(StructureViewTreeElement element) {
		return element instanceof MediaWikiFile;
	}
}