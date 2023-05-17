package com.github.guillaumetaffin.intellij.ligo.language.jsligo.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoTypes.*;
import static com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoCommentTokens.*;
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

EOL=[\n\r]+
WHITE_SPACE=\s+

SPREAD="..."
DOT="."
XOR="^"
BANG="!"
COMMA=,
WILDCARD=_
SEMICOLON=;
COLON=":"
EQ==
LINE_COMMENT_START="//"
BLOCK_COMMENT_START="/*"
BLOCK_COMMENT_END="*/"
LEFT_ANGLE_BRACKET=<
RIGHT_ANGLE_BRACKET=>
OPEN_BRACE="{"
CLOSE_BRACE="}"
OPEN_BRACKET="["
CLOSE_BRACKET="]"
PLUS="+"
MINUS="-"
MUL="*"
DIV="/"
MODULO="%"
OPEN_PARENS="("
CLOSE_PARENS=")"
IDENTIFIER=@?[a-zA-Z][a-zA-Z_0-9]*
STRING_PATTERN=\"([^\"\r\n]|(\\\"))*\"
NUMBER_PATTERN=[0-9][0-9_]*

// keywords
TYPE_ALIAS_KW=type
NAMESPACE_KW=namespace
CONST_KW=const
LET_KW=let
AS_KW=as
RETURN_KW=return

%state TYPE_ALIAS
%state VAR_ASSIGN
%state LINE_COMMENT
%state BLOCK_COMMENT
%state EXPRESSION

%%

<LINE_COMMENT> {
    .*                      { return COMMENT_TEXT; }
    {EOL}                   { yybegin(YYINITIAL); return COMMENT_END; }
}

<BLOCK_COMMENT> {
    [^*\/]*                 { return COMMENT_TEXT; }
    {BLOCK_COMMENT_END}     { yybegin(YYINITIAL); return COMMENT_END; }
}

<YYINITIAL> {
   {SPREAD}                  { return SPREAD_OP; }
   {TYPE_ALIAS_KW}           { return TYPE_ALIAS_KW; }
   {NAMESPACE_KW}            { return NAMESPACE_KW; }
   {EQ}                      { return EQ; }
   {WILDCARD}                { return WILDCARD; }
   {LEFT_ANGLE_BRACKET}      { return LEFT_ANGLE_BRACKET; }
   {RIGHT_ANGLE_BRACKET}     { return RIGHT_ANGLE_BRACKET; }
   {OPEN_BRACE}              { return OPEN_BRACE; }
   {CLOSE_BRACE}             { return CLOSE_BRACE; }
   {OPEN_BRACKET}            { return OPEN_BRACKET; }
   {CLOSE_BRACKET}           { return CLOSE_BRACKET; }
   {COMMA}                   { return COMMA; }
   {SEMICOLON}               { return SEMICOLON; }
   {COLON}                   { return COLON; }
   {DOT}                     { return DOT; }
   {BANG}                    { return BANG; }
   {XOR}                     { return XOR; }
   {PLUS}                    { return PLUS; }
   {MINUS}                   { return MINUS; }
   {MUL}                     { return MUL; }
   {DIV}                     { return DIV; }
   {MODULO}                  { return MODULO; }
   {OPEN_PARENS}             { return OPEN_PARENS; }
   {CLOSE_PARENS}            { return CLOSE_PARENS; }
   {AS_KW}                   { return AS_KW; }
   {LET_KW}                  { return LET_KW; }
   {CONST_KW}                { return CONST_KW; }
   {RETURN_KW}               { return RETURN_KW; }
   {LINE_COMMENT_START}      { yybegin(LINE_COMMENT); return COMMENT_START; }
   {BLOCK_COMMENT_START}     { yybegin(BLOCK_COMMENT); return COMMENT_START; }
   {NUMBER_PATTERN}          { return NUMBER_LITERAL;}
   {STRING_PATTERN}          { return STRING_LITERAL; }
   {IDENTIFIER}              { return IDENTIFIER; }
   {EOL}                     { return WHITE_SPACE; }
   {WHITE_SPACE}             { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }
