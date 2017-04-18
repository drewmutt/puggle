package com.mwplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.*;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.mwplugin.psi.*;
import com.mwplugin.psi.impl.MediaWikiNamedReferenceBlockImpl;
import org.jetbrains.annotations.*;

import java.util.*;

public class MediaWikiFoldingBuilder extends FoldingBuilderEx
{
	@NotNull
	@Override
	public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick)
	{
		FoldingGroup group = FoldingGroup.newGroup("MediaWiki");

		List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
		Collection<MediaWikiReferenceBlock> referenceBlocks = PsiTreeUtil.findChildrenOfType(root, MediaWikiReferenceBlock.class);

		for (final MediaWikiReferenceBlock referenceBlock : referenceBlocks)
		{
			descriptors.add(new FoldingDescriptor(referenceBlock.getNode(), new TextRange(referenceBlock.getTextRange().getStartOffset() + 1, referenceBlock.getTextRange().getEndOffset() - 1), group)
			{
				@Nullable
				@Override
				public String getPlaceholderText()
				{
					Collection<MediaWikiNamedReferenceBlock> namedRefBlockList = PsiTreeUtil.findChildrenOfType(referenceBlock, MediaWikiNamedReferenceBlock.class);
					if (namedRefBlockList.size() > 0)
					{
						MediaWikiNamedReferenceBlock namedRefBlock = (MediaWikiNamedReferenceBlock) namedRefBlockList.toArray()[0];
						String refName = namedRefBlock.getReferenceName();
						return "ref:" + refName;
					}
					return "ref";
				}
			});
		}

		Collection<MediaWikiTemplateBlock> templateBlocks = PsiTreeUtil.findChildrenOfType(root, MediaWikiTemplateBlock.class);
		for (final MediaWikiTemplateBlock templateBlock : templateBlocks)
		{
			descriptors.add(new FoldingDescriptor(templateBlock.getNode(), new TextRange(templateBlock.getTextRange().getStartOffset() + 2, templateBlock.getTextRange().getEndOffset() - 2), group)
			{
				@Nullable
				@Override
				public String getPlaceholderText()
				{
					MediaWikiTemplateName templateNameBlock = PsiTreeUtil.findChildOfType(templateBlock, MediaWikiTemplateName.class);
					if (templateNameBlock != null)
					{
						String refName = templateNameBlock.getText();
						return refName;
					}
					return "template";
				}
			});
		}

		return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
	}

	@Nullable
	@Override
	public String getPlaceholderText(@NotNull ASTNode node)
	{
		return "...";
	}

	@Override
	public boolean isCollapsedByDefault(@NotNull ASTNode node)
	{
		return true;
	}
}
