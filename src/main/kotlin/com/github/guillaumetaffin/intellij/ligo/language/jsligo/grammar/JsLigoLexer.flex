package com.github.guillaumetaffin.intellij.ligo.language.jsligo.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoTypes.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;

%%

%{
  public JsLigoLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class JsLigoLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\n
WHITE_SPACE=\s+

DOT=.
COMMA=,
TYPE_WILDCARD=_
SEMICOLON=;
COLON=:
EQ==
LINE_COMMENT_START="//"
LT=<
GT=>
PLUS="+"
MINUS="-"
OPENING_PARENS="("
CLOSING_PARENS=")"
IDENTIFIER=@?[a-zA-Z][a-zA-Z_0-9]*
STRING_PATTERN=\"([^\"\r\n]|(\\\"))*\"
NON_ZERO_NUMBER=[1-9][0-9_]*
ZERO_NUMBER=0

// keywords
TYPE_ALIAS_KW=type
CONST_KW=const
LET_KW=let
AS_KW=as

%state TYPE_ALIAS
%state VAR_ASSIGN
%state LINE_COMMENT
%state EXPRESSION

%%
<YYINITIAL> {
  {TYPE_ALIAS_KW}           { yybegin(TYPE_ALIAS); return TYPE_ALIAS_KW; }
  {LET_KW}                  { yybegin(VAR_ASSIGN); return LET_KW; }
  {CONST_KW}                { yybegin(VAR_ASSIGN); return CONST_KW; }
  {LINE_COMMENT_START}      { yybegin(LINE_COMMENT); return LINE_COMMENT_START; }
}

<TYPE_ALIAS> {
    {IDENTIFIER}            { return IDENTIFIER; }
    {EQ}                    { return EQ; }
    {LT}                    { return LT; }
    {GT}                    { return GT; }
    {COMMA}                 { return COMMA; }
}

<VAR_ASSIGN> {
    {IDENTIFIER}            { return IDENTIFIER; }
    {COLON}                 { return COLON; }
    {EQ}                    { yybegin(EXPRESSION); return EQ; }
}

<EXPRESSION>{
    {AS_KW}                 { return AS_KW; }
    {IDENTIFIER}            { return IDENTIFIER; }
    {ZERO_NUMBER}           { return ZERO_NUMBER;}
    {NON_ZERO_NUMBER}       { return NON_ZERO_NUMBER; }
    {PLUS}                  { return PLUS; }
    {MINUS}                 { return MINUS; }
    {OPENING_PARENS}        { return OPENING_PARENS; }
    {CLOSING_PARENS}        { return CLOSING_PARENS; }
    {STRING_PATTERN}        { return STRING_PATTERN; }
}

<LINE_COMMENT> {
    .*                      { return COMMENT_TEXT; }
}

{SEMICOLON}                 { yybegin(YYINITIAL); return SEMICOLON; }
{EOL}+                      { yybegin(YYINITIAL); return WHITE_SPACE; }
{WHITE_SPACE}+              { return WHITE_SPACE; }

[^] { return BAD_CHARACTER; }
