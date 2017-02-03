package com.mwplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.mwplugin.MediaWikiFileType;
import com.mwplugin.MediaWikiLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiFile extends PsiFileBase
{
	public MediaWikiFile(@NotNull FileViewProvider viewProvider) {
		super(viewProvider, MediaWikiLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public FileType getFileType() {
		return MediaWikiFileType.INSTANCE;
	}

	@Override
	public String toString() {
		return "Simple File";
	}

	@Override
	public Icon getIcon(int flags) {
		return super.getIcon(flags);
	}
}
