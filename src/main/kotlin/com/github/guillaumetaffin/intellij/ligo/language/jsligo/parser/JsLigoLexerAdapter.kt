package com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.grammar.JsLigoLexer
import com.intellij.lexer.FlexAdapter

class JsLigoLexerAdapter : FlexAdapter(JsLigoLexer())
