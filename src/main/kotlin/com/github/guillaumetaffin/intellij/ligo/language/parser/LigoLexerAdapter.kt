package com.github.guillaumetaffin.intellij.ligo.language.parser

import com.github.guillaumetaffin.intellij.ligo.language.parser.grammar.LigoLexer
import com.intellij.lexer.FlexAdapter

class LigoLexerAdapter : FlexAdapter(LigoLexer())
