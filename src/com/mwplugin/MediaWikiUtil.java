package com.mwplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.mwplugin.psi.*;

import java.util.*;

public class MediaWikiUtil
{
	/*
	public static List<MediaWikiProperty> findProperties(Project project, String key)
	{
		List<MediaWikiProperty> result = null;
		Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MediaWikiFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for (VirtualFile virtualFile : virtualFiles)
		{
			MediaWikiFile MediaWikiFile = (MediaWikiFile) PsiManager.getInstance(project).findFile(virtualFile);
			if (MediaWikiFile != null)
			{
				MediaWikiProperty[] properties = PsiTreeUtil.getChildrenOfType(MediaWikiFile, MediaWikiProperty.class);
				if (properties != null)
				{
					for (MediaWikiProperty property : properties)
					{
						if (key.equals(property.getKey()))
						{
							if (result == null)
							{
								result = new ArrayList<MediaWikiProperty>();
							}
							result.add(property);
						}
					}
				}
			}
		}
		return result != null ? result : Collections.<MediaWikiProperty>emptyList();
	}

	public static List<MediaWikiProperty> findProperties(Project project)
	{
		List<MediaWikiProperty> result = new ArrayList<MediaWikiProperty>();
		Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MediaWikiFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for (VirtualFile virtualFile : virtualFiles)
		{
			MediaWikiFile MediaWikiFile = (MediaWikiFile) PsiManager.getInstance(project).findFile(virtualFile);
			if (MediaWikiFile != null)
			{
				MediaWikiProperty[] properties = PsiTreeUtil.getChildrenOfType(MediaWikiFile, MediaWikiProperty.class);
				if (properties != null)
				{
					Collections.addAll(result, properties);
				}
			}
		}
		return result;
	}*/
}