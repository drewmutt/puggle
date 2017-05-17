package com.mwplugin.psi.impl;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.mwplugin.MediaWikiIcons;
import com.mwplugin.psi.*;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static com.mwplugin.psi.MediaWikiElementFactory.createFile;

public class MediaWikiPsiImplUtil {
	public static String getReferenceName(MediaWikiNamedReferenceBlock element) {
		MediaWikiReferenceName childOfType = PsiTreeUtil.findChildOfType(element, MediaWikiReferenceName.class);
		String text = childOfType.getText();
		return text;
//		if (keyNode != null) {
//			 IMPORTANT: Convert embedded escaped spaces to MediaWiki spaces
//			return keyNode.getText().replaceAll("\\\\ ", " ");
//		} else {
//			return null;
//		}
	}

	public static String getURL(IMediaWikiNamedElement element) {
		MediaWikiUrl urlNode = PsiTreeUtil.findChildOfType(element, MediaWikiUrl.class);
		return urlNode != null ? urlNode.getText() : null;
	}

/*
	public static String setURL(IMediaWikiNamedElement element) {
		ASTNode valueNode = element.getNode().findChildByType(MediaWikiTypes.URL);
		if (valueNode != null) {
			return valueNode.getText();
		} else {
			return null;
		}
	}

	public static String getName(IMediaWikiNamedElement element) {
		return "dude";
	}


	public static PsiElement setName(IMediaWikiNamedElement element, String newName) {
		ASTNode keyNode = element.getNode().findChildByType(MediaWikiTypes.URL);
		if (keyNode != null) {
			MediaWikiReference property = MediaWikiElementFactory.createReference(element.getProject(), newName);
			ASTNode newKeyNode = property.getFirstChild().getNode();
			element.getNode().replaceChild(keyNode, newKeyNode);
		}
		return element;
	}


	public static PsiElement getNameIdentifier(IMediaWikiNamedElement element) {
		ASTNode keyNode = element.getNode().findChildByType(MediaWikiTypes.URL);
		if (keyNode != null) {
			return keyNode.getPsi();
		} else {
			return null;
		}
	}

*/
	public static ItemPresentation getPresentation(final MediaWikiTemplateBlock element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				return element.getTemplateName().getText();
			}

			@Nullable
			@Override
			public String getLocationString() {
				PsiFile containingFile = element.getContainingFile();
				return containingFile == null ? null : containingFile.getName();
			}

			@Nullable
			@Override
			public Icon getIcon(boolean unused) {
				return AllIcons.Nodes.ExceptionClass;
			}
		};
	}

	public static ItemPresentation getPresentation(final MediaWikiSection element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				MediaWikiSectionName childOfType = PsiTreeUtil.findChildOfType(element, MediaWikiSectionName.class);
				return childOfType.getText();
			}

			@Nullable
			@Override
			public String getLocationString() {
				PsiFile containingFile = element.getContainingFile();
				return containingFile == null ? null : containingFile.getName();
			}

			@Nullable
			@Override
			public Icon getIcon(boolean unused) {
				return AllIcons.Nodes.NewFolder;
			}
		};
	}


	public static ItemPresentation getPresentation(final MediaWikiTable element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				MediaWikiCellContent childOfType = PsiTreeUtil.findChildOfType(element, MediaWikiCellContent.class);
				return childOfType.getText();
			}

			@Nullable
			@Override
			public String getLocationString() {
				PsiFile containingFile = element.getContainingFile();
				return containingFile == null ? null : containingFile.getName();
			}

			@Nullable
			@Override
			public Icon getIcon(boolean unused) {
				return AllIcons.Nodes.DataTables;
			}
		};
	}

	public static ItemPresentation getPresentation(final MediaWikiInternalLink element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				MediaWikiArticleLink childOfType = PsiTreeUtil.findChildOfType(element, MediaWikiArticleLink.class);
				return childOfType.getText();
			}

			@Nullable
			@Override
			public String getLocationString() {
				PsiFile containingFile = element.getContainingFile();
				return containingFile == null ? null : containingFile.getName();
			}

			@Nullable
			@Override
			public Icon getIcon(boolean unused) {
				return AllIcons.Nodes.Annotationtype;
			}
		};
	}

	public static ItemPresentation getPresentation(final MediaWikiExternalLink element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				MediaWikiUrl childOfType = PsiTreeUtil.findChildOfType(element, MediaWikiUrl.class);
				return childOfType.getText();
			}

			@Nullable
			@Override
			public String getLocationString() {
				PsiFile containingFile = element.getContainingFile();
				return containingFile == null ? null : containingFile.getName();
			}

			@Nullable
			@Override
			public Icon getIcon(boolean unused) {
				return AllIcons.Nodes.Deploy;
			}
		};
	}

}
