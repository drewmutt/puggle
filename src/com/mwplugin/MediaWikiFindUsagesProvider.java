package com.mwplugin;

		import com.intellij.lang.cacheBuilder.*;
		import com.intellij.lang.findUsages.FindUsagesProvider;
		import com.intellij.psi.*;
		import com.intellij.psi.tree.TokenSet;
		import com.mwplugin.psi.IMediaWikiNamedElement;
		import com.mwplugin.psi.MediaWikiNamedReferenceBlockUrl;
		import com.mwplugin.psi.MediaWikiReferenceBlock;
		import com.mwplugin.psi.MediaWikiTypes;
		import org.jetbrains.annotations.*;

public class MediaWikiFindUsagesProvider implements FindUsagesProvider {
	@Nullable
	@Override
	public WordsScanner getWordsScanner() {
		return new DefaultWordsScanner(new MediaWikiLexerAdapter(),
				TokenSet.create(MediaWikiTypes.REFERENCE_BLOCK),
				TokenSet.create(MediaWikiTypes.REFERENCE_NAME),
				TokenSet.EMPTY);
	}

	@Override
	public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
		return psiElement instanceof IMediaWikiNamedElement;
	}

	@Nullable
	@Override
	public String getHelpId(@NotNull PsiElement psiElement) {
		return null;
	}

	@NotNull
	@Override
	public String getType(@NotNull PsiElement element) {
		if (element instanceof MediaWikiReferenceBlock) {
			return "MediaWiki reference";
		} else {
			return "";
		}
	}

	@NotNull
	@Override
	public String getDescriptiveName(@NotNull PsiElement element) {
		if (element instanceof MediaWikiNamedReferenceBlockUrl) {
			return ((MediaWikiNamedReferenceBlockUrl) element).getURL();
		} else {
			return "";
		}
	}

	@NotNull
	@Override
	public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
		if (element instanceof MediaWikiNamedReferenceBlockUrl) {
			return ((MediaWikiNamedReferenceBlockUrl) element).getReferenceName()+ ":" + ((MediaWikiNamedReferenceBlockUrl) element).getURL();
		} else {
			return "";
		}
	}
}