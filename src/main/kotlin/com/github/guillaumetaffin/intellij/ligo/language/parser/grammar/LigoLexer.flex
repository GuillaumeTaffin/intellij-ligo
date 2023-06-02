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

WHITE_SPACE=[ \t\n\x0B\f\r]
CHARACTER=[^ \t\n\x0B\f\r]+

%%
<YYINITIAL> {

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {CHARACTER}        { return CHARACTER; }

}

[^] { return BAD_CHARACTER; }
