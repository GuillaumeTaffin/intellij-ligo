package com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoTypes.*
import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

object JsLigoTokenSets {

    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)

    val STRING_LITERALS: TokenSet = TokenSet.create(STRING_LITERAL)

    val COMMENTS: TokenSet = TokenSet.create(LINE_COMMENT_START, COMMENT_TEXT, BLOCK_COMMENT_START, BLOCK_COMMENT_END)

}