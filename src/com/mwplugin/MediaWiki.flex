package com.mwplugin;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.mwplugin.psi.MediaWikiTypes.*;

%%

%{
  public MediaWikiLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class MediaWikiLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s

CRLF=\R
CONTENT=[^><\[\]]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "<ref>"            { return REFSTART; }
  "</ref>"           { return REFEND; }
  "["                { return OPENBRACKET; }
  "]"                { return CLOSEBRACKET; }
  "header"           { return HEADER; }
  "comment"          { return COMMENT; }
  "subheader"        { return SUBHEADER; }
  "subheader2"       { return SUBHEADER2; }
  "subheader3"       { return SUBHEADER3; }
  "template"         { return TEMPLATE; }
  "bold"             { return BOLD; }
  "italic"           { return ITALIC; }
  "externallink"     { return EXTERNALLINK; }

  {CRLF}             { return CRLF; }
  {CONTENT}          { return CONTENT; }

}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
