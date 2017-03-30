// This is a generated file. Not intended for manual editing.
package com.mwplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.mwplugin.psi.MediaWikiTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MediaWikiParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == LINK) {
      r = link(b, 0);
    }
    else if (t == REFERENCE) {
      r = reference(b, 0);
    }
    else if (t == URL) {
      r = url(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return item_(b, l + 1);
  }

  /* ********************************************************** */
  // (
  // link
  // |header
  // |comment
  // |subheader
  // |subheader2
  // |subheader3
  // |reference
  // |template
  // |bold
  // |italic
  // |content
  // |COMMENT
  // |CRLF
  // |externallink)*
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item__0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "item_", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // link
  // |header
  // |comment
  // |subheader
  // |subheader2
  // |subheader3
  // |reference
  // |template
  // |bold
  // |italic
  // |content
  // |COMMENT
  // |CRLF
  // |externallink
  private static boolean item__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = link(b, l + 1);
    if (!r) r = consumeToken(b, HEADER);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, SUBHEADER);
    if (!r) r = consumeToken(b, SUBHEADER2);
    if (!r) r = consumeToken(b, SUBHEADER3);
    if (!r) r = reference(b, l + 1);
    if (!r) r = consumeToken(b, TEMPLATE);
    if (!r) r = consumeToken(b, BOLD);
    if (!r) r = consumeToken(b, ITALIC);
    if (!r) r = consumeToken(b, CONTENT);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, EXTERNALLINK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[[' url ']]'
  public static boolean link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LINK, "<link>");
    r = consumeToken(b, "[[");
    p = r; // pin = 1
    r = r && report_error_(b, url(b, l + 1));
    r = p && consumeToken(b, "]]") && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // refstart url refend
  public static boolean reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference")) return false;
    if (!nextTokenIs(b, REFSTART)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE, null);
    r = consumeToken(b, REFSTART);
    p = r; // pin = 1
    r = r && report_error_(b, url(b, l + 1));
    r = p && consumeToken(b, REFEND) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // content
  public static boolean url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url")) return false;
    if (!nextTokenIs(b, CONTENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTENT);
    exit_section_(b, m, URL, r);
    return r;
  }

}
