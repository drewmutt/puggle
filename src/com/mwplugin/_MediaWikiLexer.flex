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
otherletter=[\p{L}]
lcaseletter=[a-z]
ucaseletter=[A-Z]
decimaldigit=[0-9]
galleryopen=<gallery.*>
tab=\t
symboltoken = [\.,\(\)\-\:#\/';–\!%\?_—\+\$~·’†½\*@®−‘\^ᴥ•…`“‑§”、」「✋«』『。\"±‐×°′́aʿמָשִׁיחַמשיח[^\x00-\x7F]]
//okaysymbols = "regexp:[\(|\)|_|\.|\!|\/|\\|\-|\:|#]"

%%
<YYINITIAL> {
  "|-"                 { return pipedash; }
  "|+"                  {return pipeplus;}
  "|}"                 { return pipeclosecurly; }
  "{|"                 { return tablestart; }
  "||"                 { return doublepipe; }
  "!!"                 { return tableheaderdoubledelimiter; }
  "<!--"                {return htmlcommentopen;}
  "-->"                {return htmlcommentclose;}
  "'''''"                 { return quote5; }
  "'''"                 { return quote3; }
  "''"                 { return quote2; }
    "<ref>"             { return refopencomplete; }
    "<ref"             { return refopen; }
    "</ref>"             { return refclose; }
    "</gallery>" {return galleryclose;}
//    "<br/>"                 {return htmltagnewline;}
  "====="              { return equals5; }
  "===="              { return equals4; }
  "==="              { return equals3; }
  "=="              { return equals2; }
  "="              { return equals; }
  "/>"              { return htmltagselfclose; }
  "{{"              { return curlyopen2; }
  "[["              { return openbracket2; }
    "]]"              { return closebracket2; }
  "}}"              { return curlyclose2; }
  "|"              { return pipe; }
  "&"                 { return unescapedampersand; }
  "<"                 { return unescapedlessthan; }
  ">"                 { return unescapedgreaterthan; }
  "_"                 { return underscore; }
  " "                 { return space; }
  "\""                 { return doublequote; }
"["                 { return openbracket; }
"]"                 { return closebracket; }


//  {okaysymbols}              { return okaysymbols; }
  {newline}           { return newline; }
  {galleryopen}           { return galleryopen; }
  {lcaseletter}       { return lcaseletter; }
  {ucaseletter}       { return ucaseletter; }
  {decimaldigit}      { return decimaldigit; }
  {otherletter}      { return otherletter; }
  {tab}               { return tab; }
    {symboltoken}   {return symboltoken;}
}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
