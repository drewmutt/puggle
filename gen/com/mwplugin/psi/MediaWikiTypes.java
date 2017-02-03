// This is a generated file. Not intended for manual editing.
package com.mwplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.mwplugin.psi.impl.*;

public interface MediaWikiTypes {

  IElementType PROPERTY = new MediaWikiElementType("PROPERTY");

  IElementType BOLD = new MediaWikiTokenType("bold");
  IElementType COMMENT = new MediaWikiTokenType("COMMENT");
  IElementType CONTENT = new MediaWikiTokenType("content");
  IElementType CRLF = new MediaWikiTokenType("CRLF");
  IElementType HEADER = new MediaWikiTokenType("header");
  IElementType KEY = new MediaWikiTokenType("KEY");
  IElementType LINK = new MediaWikiTokenType("link");
  IElementType REFERENCE = new MediaWikiTokenType("reference");
  IElementType SEPARATOR = new MediaWikiTokenType("SEPARATOR");
  IElementType SUBHEADER = new MediaWikiTokenType("subheader");
  IElementType TEMPLATE = new MediaWikiTokenType("template");
  IElementType VALUE = new MediaWikiTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new MediaWikiPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
