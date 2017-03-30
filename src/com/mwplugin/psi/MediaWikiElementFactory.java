package com.mwplugin.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.mwplugin.MediaWikiFileType;

public class MediaWikiElementFactory
{
	public static MediaWikiReference createReference(Project project, String name, String value)
	{
		final MediaWikiFile file = createFile(project, name + " = " + value);
		return (MediaWikiReference) file.getFirstChild();
	}

	public static MediaWikiReference createReference(Project project, String name)
	{
		final MediaWikiFile file = createFile(project, name);
		return (MediaWikiReference) file.getFirstChild();
	}

	public static PsiElement createCRLF(Project project)
	{
		final MediaWikiFile file = createFile(project, "\n");
		return file.getFirstChild();
	}

	public static MediaWikiFile createFile(Project project, String text)
	{
		String name = "dummy.MediaWiki";
		return (MediaWikiFile) PsiFileFactory.getInstance(project).
				createFileFromText(name, MediaWikiFileType.INSTANCE, text);
	}
}