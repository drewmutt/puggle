package com.mwplugin;

		import com.intellij.lang.cacheBuilder.*;
		import com.intellij.lang.findUsages.FindUsagesProvider;
		import com.intellij.psi.*;
		import com.intellij.psi.tree.TokenSet;
		import com.mwplugin.psi.*;
		import org.jetbrains.annotations.*;

public class MediaWikiFindUsagesProvider implements FindUsagesProvider {
	@Nullable
	@Override
	public WordsScanner getWordsScanner() {

		return new DefaultWordsScanner(new MediaWikiLexerAdapter(),
				TokenSet.create(MediaWikiTypes.NAMED_REFERENCE_BLOCK),
				TokenSet.create(MediaWikiTypes.HTML_COMMENT),
				TokenSet.EMPTY);
	}

	@Override
	public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
		return psiElement instanceof MediaWikiNamedReferenceBlock;
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
		if (element instanceof MediaWikiNamedReferenceBlock) {
			return ((MediaWikiNamedReferenceBlock) element).getReferenceName();
		} else {
			return "";
		}
	}

	@NotNull
	@Override
	public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
		if (element instanceof MediaWikiNamedReferenceBlock) {
			return ((MediaWikiNamedReferenceBlock) element).getReferenceName();
		} else {
			return "";
		}
//		return "gey";
	}
}