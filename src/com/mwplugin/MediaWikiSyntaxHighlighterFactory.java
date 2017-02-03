package com.mwplugin;

import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class MediaWikiSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
	@NotNull
	@Override
	public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
		return new MediaWikiSyntaxHighlighter();
	}
}