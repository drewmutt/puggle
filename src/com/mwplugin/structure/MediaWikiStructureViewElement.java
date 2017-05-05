package com.mwplugin.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.*;
import com.intellij.navigation.*;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.mwplugin.psi.*;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MediaWikiStructureViewElement implements StructureViewTreeElement, SortableTreeElement
{
	private PsiElement element;

	public MediaWikiStructureViewElement(PsiElement element)
	{
		this.element = element;
	}

	@Override
	public Object getValue()
	{
		return element;
	}

	@Override
	public void navigate(boolean requestFocus)
	{
		if (element instanceof NavigationItem)
		{
			((NavigationItem) element).navigate(requestFocus);
		}
	}

	@Override
	public boolean canNavigate()
	{
		return element instanceof NavigationItem && ((NavigationItem) element).canNavigate();
	}

	@Override
	public boolean canNavigateToSource()
	{
		return element instanceof NavigationItem && ((NavigationItem) element).canNavigateToSource();
	}

	@Override
	public String getAlphaSortKey()
	{
		String s = String.valueOf(element.getTextOffset());
		return s;
	}

	@Override
	public ItemPresentation getPresentation()
	{
		if (element instanceof NavigationItem)
			return ((NavigationItem) element).getPresentation();
		else
			return null;
	}

	@Override
	public TreeElement[] getChildren()
	{
		if (element instanceof MediaWikiFile)
		{
			return getTreeElements(null, MediaWikiSection.class);
		}
		else
		{
			return getTreeElements(element, element.getClass());
		}
	}

	private TreeElement[] getTreeElements(PsiElement parent, Class<? extends PsiElement> parentType)
	{
		TreeElement[] sections = getElementsOfWhichFirstParentIs(MediaWikiSection.class, parentType, parent);

		TreeElement[] templates = getElementsOfWhichFirstParentIs(MediaWikiTemplateBlock.class, parentType, parent);
		TreeElement[] treeElements = ArrayUtils.addAll(sections, templates);

		TreeElement[] tables = getElementsOfWhichFirstParentIs(MediaWikiTable.class, parentType, parent);
		treeElements = ArrayUtils.addAll(treeElements, tables);

		TreeElement[] internalLinks = getElementsOfWhichFirstParentIs(MediaWikiInternalLink.class, parentType, parent);
		treeElements = ArrayUtils.addAll(treeElements, internalLinks);

		TreeElement[] externalLinks = getElementsOfWhichFirstParentIs(MediaWikiExternalLink.class, parentType, parent);
		treeElements = ArrayUtils.addAll(treeElements, externalLinks);
		return treeElements;
	}

	@NotNull
	private TreeElement[] getElementsOfWhichFirstParentIs(Class<? extends PsiElement> clazz, Class<? extends PsiElement> parentType,  PsiElement parent)
	{
		Collection<PsiElement> elements = PsiTreeUtil.findChildrenOfAnyType(element, clazz);
		List<TreeElement> treeElements = new ArrayList<TreeElement>(elements.size());
		for (PsiElement element : elements)
		{
			Condition<PsiElement> condition = new Condition<PsiElement>()
			{
				@Override
				public boolean value(PsiElement psiElement)
				{
					return parentType.isInstance(psiElement);
				}
			};
			PsiElement parentSection = PsiTreeUtil.findFirstParent(element.getParent(), condition);
			if(parentSection == parent)
			{
				int textOffset = element.getTextOffset();
				MediaWikiStructureViewElement e = new MediaWikiStructureViewElement(element);
				treeElements.add(e);
			}
		}


		return treeElements.toArray(new TreeElement[treeElements.size()]);
	}
}