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

ID=_?([a-zA-Z][a-zA-Z_0-9]*)?
INT_LITERAL=[0-9][0-9_]*
STRING_LITERAL=\"([^\"\r\n]|(\\\"))*\"
LINE_COMMENT="//".*
BLOCK_COMMENT="/*"~"*/"

%%
<YYINITIAL> {
  "const"            { return CONST; }
  "let"              { return LET; }
  ";"                { return SEMICOLON; }
  ":"                { return COLON; }
  "=>"               { return ARROW; }
  "=="               { return IS_EQUAL; }
  "!="               { return NOT_EQUAL; }
  "="                { return EQ; }
  "<="               { return LESS_OR_EQUAL; }
  ">="               { return GREATER_OR_EQUAL; }
  "<"                { return LEFT_ANGLE_BRACKET; }
  ">"                { return RIGHT_ANGLE_BRACKET; }
  ","                { return COMMA; }
  "("                { return OPEN_PAREN; }
  ")"                { return CLOSE_PAREN; }
  "["                { return OPEN_BRACKET; }
  "]"                { return CLOSE_BRACKET; }
  "."                { return DOT; }
  "as"               { return AS; }
  "++"               { return INC; }
  "--"               { return DEC; }
  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "*"                { return MUL; }
  "/"                { return DIV; }
  "%"                { return MODULO; }
  "!"                { return BANG; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "&&"               { return AND; }
  "||"               { return OR; }
  "|"                { return PIPE; }
  "{"                { return OPEN_BRACE; }
  "}"                { return CLOSE_BRACE; }
  "..."              { return SPREAD; }
  "@"                { return AT; }
  "type"             { return TYPE; }
  "return"           { return RETURN; }
  "namespace"        { return NAMESPACE_KW; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "switch"           { return SWITCH; }
  "default"          { return DEFAULT; }
  "case"             { return CASE; }
  "break"            { return BREAK; }
  "for"              { return FOR; }
  "of"               { return OF; }
  "?"                { return QUESTION_MARK; }

  {ID}               { return ID; }
  {INT_LITERAL}      { return INT_LITERAL; }
  {STRING_LITERAL}   { return STRING_LITERAL; }
  {LINE_COMMENT}     { return LINE_COMMENT; }
  {BLOCK_COMMENT}    { return BLOCK_COMMENT; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }
