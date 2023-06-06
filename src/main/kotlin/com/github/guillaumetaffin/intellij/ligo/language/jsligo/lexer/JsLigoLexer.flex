package com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.Tokens.*;

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

WHITE_SPACE=\s+

ID=_?@?([a-zA-Z][a-zA-Z_0-9]*)?
INT_LITERAL=[0-9][0-9_]*
STRING_LITERAL=\"([^\"\r\n]|(\\\"))*\"

%%
<YYINITIAL> {
  "const"            { return CONST; }
  "let"              { return LET; }
  ";"                { return SEMICOLON; }
  ":"                { return COLON; }
  "="                { return EQ; }
  "<"                { return LEFT_ANGLE_BRACKET; }
  ">"                { return RIGHT_ANGLE_BRACKET; }
  ","                { return COMMA; }
  "("                { return OPEN_PAREN; }
  ")"                { return CLOSE_PAREN; }
  "["                { return OPEN_BRACKET; }
  "]"                { return CLOSE_BRACKET; }
  "."                { return DOT; }
  "as"               { return AS; }
  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "*"                { return MUL; }
  "/"                { return DIV; }
  "%"                { return MODULO; }
  "!"                { return BANG; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "&&"               { return AND; }
  "|"                { return PIPE; }

  {ID}               { return ID; }
  {INT_LITERAL}      { return INT_LITERAL; }
  {STRING_LITERAL}   { return STRING_LITERAL; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }