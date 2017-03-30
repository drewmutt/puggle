// This is a generated file. Not intended for manual editing.
package com.mwplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.mwplugin.psi.impl.*;

public interface MediaWikiTypes {

  IElementType LINK = new MediaWikiElementType("LINK");
  IElementType REFERENCE = new MediaWikiElementType("REFERENCE");
  IElementType URL = new MediaWikiElementType("URL");

  IElementType BOLD = new MediaWikiTokenType("bold");
  IElementType CLOSEBRACKET = new MediaWikiTokenType("]");
  IElementType COMMENT = new MediaWikiTokenType("COMMENT");
  IElementType CONTENT = new MediaWikiTokenType("content");
  IElementType CRLF = new MediaWikiTokenType("CRLF");
  IElementType EXTERNALLINK = new MediaWikiTokenType("externallink");
  IElementType HEADER = new MediaWikiTokenType("header");
  IElementType ITALIC = new MediaWikiTokenType("italic");
  IElementType OPENBRACKET = new MediaWikiTokenType("[");
  IElementType REFEND = new MediaWikiTokenType("</ref>");
  IElementType REFSTART = new MediaWikiTokenType("<ref>");
  IElementType SUBHEADER = new MediaWikiTokenType("subheader");
  IElementType SUBHEADER2 = new MediaWikiTokenType("subheader2");
  IElementType SUBHEADER3 = new MediaWikiTokenType("subheader3");
  IElementType TEMPLATE = new MediaWikiTokenType("template");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == LINK) {
        return new MediaWikiLinkImpl(node);
      }
      else if (type == REFERENCE) {
        return new MediaWikiReferenceImpl(node);
      }
      else if (type == URL) {
        return new MediaWikiUrlImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
