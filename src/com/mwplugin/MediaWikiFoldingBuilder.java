package com.mwplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.*;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.mwplugin.psi.MediaWikiReference;
import com.mwplugin.psi.MediaWikiTypes;
import com.mwplugin.psi.ReferenceNode;
import com.mwplugin.psi.impl.MediaWikiReferenceImpl;
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
		Collection<MediaWikiReference> references = PsiTreeUtil.findChildrenOfType(root, MediaWikiReference.class);

		for (final MediaWikiReference reference : references)
		{
			descriptors.add(new FoldingDescriptor(reference.getNode(), new TextRange(reference.getTextRange().getStartOffset() + 1, reference.getTextRange().getEndOffset() - 1), group)
			{
				@Nullable
				@Override
				public String getPlaceholderText()
				{
					// IMPORTANT: keys can come with no values, so a test for null is needed
					// IMPORTANT: Convert embedded \n to backslash n, so that the string will look like it has LF embedded
					// in it and embedded " to escaped "
//					String valueOf = properties.get(0).getValue();
//					return valueOf == null ? "" : valueOf.replaceAll("\n", "\\n").replaceAll("\"", "\\\\\"");
					return "(ref)";
				}
			});
		}

//		for (final ReferenceNode literalExpression : references)
//		{
//			String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

			/*
			if (value != null && value.startsWith("MediaWiki:"))
			{
				Project project = literalExpression.getProject();
				String key = value.substring(7);
				final List<MediaWikiProperty> properties = MediaWikiUtil.findProperties(project, key);
				if (properties.size() == 1)
				{
					descriptors.add(new FoldingDescriptor(literalExpression.getNode(), new TextRange(literalExpression.getTextRange().getStartOffset() + 1, literalExpression.getTextRange().getEndOffset() - 1), group)
					{
						@Nullable
						@Override
						public String getPlaceholderText()
						{
							// IMPORTANT: keys can come with no values, so a test for null is needed
							// IMPORTANT: Convert embedded \n to backslash n, so that the string will look like it has LF embedded
							// in it and embedded " to escaped "
							String valueOf = properties.get(0).getValue();
							return valueOf == null ? "" : valueOf.replaceAll("\n", "\\n").replaceAll("\"", "\\\\\"");
						}
					});
				}
			}*/
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
