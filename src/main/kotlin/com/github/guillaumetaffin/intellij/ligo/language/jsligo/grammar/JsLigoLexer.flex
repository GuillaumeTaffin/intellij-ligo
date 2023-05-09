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
SEMICOLON=";"
COLON=":"
EQ==
IDENTIFIER=[a-zA-Z][a-zA-Z_0-9]+
STRING_LITERAL=\"([^\"\r\n]|(\\\"))*\"

// keywords
TYPE_ALIAS_KW=type
CONST_KW=const
LET_KW=let

%state TYPE_ALIAS
%state VAR_ASSIGN

%%
<YYINITIAL> {
  {TYPE_ALIAS_KW}           { yybegin(TYPE_ALIAS); return TYPE_ALIAS_KW; }
  {LET_KW}                  { yybegin(VAR_ASSIGN); return LET_KW; }
  {CONST_KW}                { yybegin(VAR_ASSIGN); return CONST_KW; }
}

<TYPE_ALIAS> {
    {IDENTIFIER}            { return IDENTIFIER; }
    {EQ}                    { return EQ; }
}

<VAR_ASSIGN> {
    {IDENTIFIER}            { return IDENTIFIER; }
    {EQ}                    { return EQ; }
    {COLON}                 { return COLON; }
    {STRING_LITERAL}        { return STRING_LITERAL;}
}

{SEMICOLON}                 { yybegin(YYINITIAL); return SEMICOLON; }
{EOL}+                      { yybegin(YYINITIAL); return WHITE_SPACE; }
{WHITE_SPACE}+              { return WHITE_SPACE; }

[^] { return BAD_CHARACTER; }
