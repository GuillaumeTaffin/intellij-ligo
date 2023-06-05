package com.github.guillaumetaffin.intellij.ligo.language.parser.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.guillaumetaffin.intellij.ligo.language.parser.psi.LigoTypes.*;

%%

%{
  public LigoLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class LigoLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

WHITE_SPACE=[^\S\n\r]+

NEW_LINE=[\n\r]+
ID=@?[a-zA-Z][a-zA-Z_0-9]*
INT_LITERAL=[0-9][0-9_]*
STRING_LITERAL=\"([^\"\r\n]|(\\\"))*\"

%%
<YYINITIAL> {
  "const"            { return CONST; }
  "let"              { return LET; }
  ";"                { return SEMICOLON; }
  ":"                { return COLON; }
  "="                { return EQ; }

  {NEW_LINE}         { return NEW_LINE; }
  {ID}               { return ID; }
  {INT_LITERAL}      { return INT_LITERAL; }
  {STRING_LITERAL}   { return STRING_LITERAL; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }
