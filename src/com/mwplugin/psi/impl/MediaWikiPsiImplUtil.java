package com.mwplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.mwplugin.MediaWikiIcons;
import com.mwplugin.psi.*;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

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


	public static ItemPresentation getPresentation(final MediaWikiReference element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				return element.getUrl().getText();
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
				return MediaWikiIcons.FILE;
			}
		};
	}
*/
}
