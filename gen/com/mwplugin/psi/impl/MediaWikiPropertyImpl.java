// This is a generated file. Not intended for manual editing.
package com.mwplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.mwplugin.psi.MediaWikiTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.mwplugin.psi.*;

public class MediaWikiPropertyImpl extends ASTWrapperPsiElement implements MediaWikiProperty {

  public MediaWikiPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MediaWikiVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MediaWikiVisitor) accept((MediaWikiVisitor)visitor);
    else super.accept(visitor);
  }

}
