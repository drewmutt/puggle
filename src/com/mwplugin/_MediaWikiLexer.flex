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

newline=[\r\n]
lcaseletter=[a-z]
ucaseletter=[A-Z]
decimaldigit=[0-9]
tab=\t
%%
<YYINITIAL> {
    "<ref"             { return refopen; }
    "</ref>"             { return refclose; }
  "====="              { return equals5; }
  "===="              { return equals4; }
  "==="              { return equals3; }
  "=="              { return equals2; }
  "="              { return equals1; }
  "&"                 { return unescapedampersand; }
  "<"                 { return unescapedlessthan; }
  ">"                 { return unescapedgreaterthan; }
  "_"                 { return underscore; }
  " "                 { return space; }
  "\""                 { return doublequote; }

  {newline}           { return newline; }
  {lcaseletter}       { return lcaseletter; }
  {ucaseletter}       { return ucaseletter; }
  {decimaldigit}      { return decimaldigit; }
  {tab}               { return tab; }

}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
