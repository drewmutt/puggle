package com.mwplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.*;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.mwplugin.psi.MediaWikiNamedReferenceBlock;
import com.mwplugin.psi.MediaWikiReferenceBlock;
import com.mwplugin.psi.MediaWikiTypes;
import com.mwplugin.psi.ReferenceNode;
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
		PsiElement psiElement = PsiTreeUtil.firstChild(root);
//		PsiTreeUtil.processElements(root, element -> {
//			if (element.getNode().getElementType() == MediaWikiTypes.REFERENCE) {
//				System.out.println("He");
//
//			}
//			return true;
//		});

		for (final MediaWikiReferenceBlock referenceBlock : referenceBlocks)
		{
//			String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;


//			if (value != null && value.startsWith("MediaWiki:"))
//			{
//				Project project = literalExpression.getProject();
//				String key = value.substring(7);
//				final List<MediaWikiProperty> properties = MediaWikiUtil.findProperties(project, key);
//				if (properties.size() == 1)
//				{
					descriptors.add(new FoldingDescriptor(referenceBlock.getNode(), new TextRange(referenceBlock.getTextRange().getStartOffset() + 1, referenceBlock.getTextRange().getEndOffset() - 1), group)
					{
						@Nullable
						@Override
						public String getPlaceholderText()
						{
							Collection<MediaWikiNamedReferenceBlock> namedRefBlockList = PsiTreeUtil.findChildrenOfType(referenceBlock, MediaWikiNamedReferenceBlock.class);
							if(namedRefBlockList.size() > 0)
							{
								MediaWikiNamedReferenceBlock namedRefBlock = (MediaWikiNamedReferenceBlock) namedRefBlockList.toArray()[0];
								String refName = namedRefBlock.getReferenceName();
								return "ref:"+refName;
							}
							return "ref";
						}
					});
				}
//			}*/
//		}
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
