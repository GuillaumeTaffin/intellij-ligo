package com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

object JsLigoTokenSets {

    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)

    val STRING_LITERALS: TokenSet = TokenSet.create(JsLigoTypes.STRING_LITERAL)

    val COMMENTS: TokenSet = TokenSet.create(JsLigoTypes.LINE_COMMENT)

}