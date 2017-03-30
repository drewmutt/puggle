// This is a generated file. Not intended for manual editing.
package com.mwplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MediaWikiVisitor extends PsiElementVisitor {

  public void visitLink(@NotNull MediaWikiLink o) {
    visitIMediaWikiNamedElement(o);
  }

  public void visitReference(@NotNull MediaWikiReference o) {
    visitIMediaWikiNamedElement(o);
  }

  public void visitUrl(@NotNull MediaWikiUrl o) {
    visitPsiElement(o);
  }

  public void visitIMediaWikiNamedElement(@NotNull IMediaWikiNamedElement o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
