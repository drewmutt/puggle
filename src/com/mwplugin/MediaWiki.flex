package com.mwplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.mwplugin.psi.MediaWikiTypes;
import com.intellij.psi.TokenType;

%%

%class MediaWikiLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
private int nestCount = 0;
%}



CRLF=\R
WHITE_SPACE=[\ \n\t\f]

%x template

%%

<YYINITIAL> {

    "[[" . ~"]]"                                    { return MediaWikiTypes.LINK; }
    "===" . ~"==="                                    { return MediaWikiTypes.HEADER; }
    "==" . ~"=="                                    { return MediaWikiTypes.SUBHEADER; }
    "{{"                                            { yybegin(template); return MediaWikiTypes.TEMPLATE; }
    "}}"                                            { return MediaWikiTypes.TEMPLATE; }
    "'''" . ~"'''"                                    { return MediaWikiTypes.BOLD; }
    "<!--" . ~"-->"                                    { return MediaWikiTypes.COMMENT; }
    "<ref" [.|] ~"</ref>"                                    { return MediaWikiTypes.REFERENCE; }

    //{SEPARATOR}                                     { yybegin(WAITING_VALUE); return MediaWikiTypes.SEPARATOR; }
}

<template>
{
//    "{{" {  yy_push_state(comment); return MediaWikiTypes.TEMPLATE;}
//    "}}" {  yy_pop_state(); return MediaWikiTypes.TEMPLATE;}

     "{{"           { ++nestCount; return MediaWikiTypes.TEMPLATE; }
      "}}"        { if (nestCount > 0) --nestCount;
                       else yybegin(YYINITIAL); return MediaWikiTypes.TEMPLATE;}
    .                                                           { return MediaWikiTypes.TEMPLATE; }
    ({CRLF}|{WHITE_SPACE})+                                     { return MediaWikiTypes.TEMPLATE; }
}
/*
<IN_LINK> {

    "]]"                                     { yybegin(YYINITIAL); return MediaWikiTypes.LINK; }
}*/
//<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

//<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return MediaWikiTypes.CONTENT; }

