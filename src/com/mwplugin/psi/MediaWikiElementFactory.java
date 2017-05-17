package com.mwplugin.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.mwplugin.MediaWikiFileType;

public class MediaWikiElementFactory
{

	public static MediaWikiTemplateBlock createTemplate(Project project, String content)
	{
		final MediaWikiFile file = createFile(project, content);
		return (MediaWikiTemplateBlock) PsiTreeUtil.findChildOfAnyType(file, MediaWikiTemplateBlock.class);
	}

	public static MediaWikiReferenceBlock createEmptyNamedReference(Project project, String referenceName)
	{
		final MediaWikiFile file = createFile(project, "<ref name=\""+referenceName+"\"/>");
		return (MediaWikiReferenceBlock) PsiTreeUtil.findChildOfAnyType(file, MediaWikiReferenceBlock.class);
	}

	public static MediaWikiReferenceBlock createPopulatedNamedReference(Project project, String referenceName, String content)
	{
		final MediaWikiFile file = createFile(project, "<ref name=\""+referenceName+"\">"+content+"</ref>");
		return (MediaWikiReferenceBlock) PsiTreeUtil.findChildOfAnyType(file, MediaWikiReferenceBlock.class);
	}

	/*public static MediaWikiReference createReference(Project project, String name)
	{
		final MediaWikiFile file = createFile(project, name);
		return (MediaWikiReference) file.getFirstChild();
	}
*/
	public static PsiElement createCRLF(Project project)
	{
		final MediaWikiFile file = createFile(project, "\n");
		return file.getFirstChild();
	}

	public static MediaWikiFile createFile(Project project, String text)
	{
		String name = "dummy.mediawiki";
		return (MediaWikiFile) PsiFileFactory.getInstance(project).
				createFileFromText(name, MediaWikiFileType.INSTANCE, text);
	}
}