package com.mwplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.mwplugin.MediaWikiIcons;
import com.mwplugin.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MediaWikiPsiImplUtil {
	/*
	public static String getKey(MediaWikiProperty element) {
		ASTNode keyNode = element.getNode().findChildByType(MediaWikiTypes.KEY);
		if (keyNode != null) {
			// IMPORTANT: Convert embedded escaped spaces to MediaWiki spaces
			return keyNode.getText().replaceAll("\\\\ ", " ");
		} else {
			return null;
		}
	}

	public static String getValue(MediaWikiProperty element) {
		ASTNode valueNode = element.getNode().findChildByType(MediaWikiTypes.VALUE);
		if (valueNode != null) {
			return valueNode.getText();
		} else {
			return null;
		}
	}

	public static String getName(MediaWikiProperty element) {
		return getKey(element);
	}

	public static PsiElement setName(MediaWikiProperty element, String newName) {
		ASTNode keyNode = element.getNode().findChildByType(MediaWikiTypes.KEY);
		if (keyNode != null) {
			MediaWikiProperty property = MediaWikiElementFactory.createProperty(element.getProject(), newName);
			ASTNode newKeyNode = property.getFirstChild().getNode();
			element.getNode().replaceChild(keyNode, newKeyNode);
		}
		return element;
	}

	public static PsiElement getNameIdentifier(MediaWikiProperty element) {
		ASTNode keyNode = element.getNode().findChildByType(MediaWikiTypes.KEY);
		if (keyNode != null) {
			return keyNode.getPsi();
		} else {
			return null;
		}
	}

	public static ItemPresentation getPresentation(final MediaWikiProperty element) {
		return new ItemPresentation() {
			@Nullable
			@Override
			public String getPresentableText() {
				return element.getKey();
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
