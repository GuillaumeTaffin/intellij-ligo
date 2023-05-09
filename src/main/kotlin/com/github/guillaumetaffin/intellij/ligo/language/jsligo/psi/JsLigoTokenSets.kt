package com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

object JsLigoTokenSets {

    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)

    val STRING_LITERALS = TokenSet.create(JsLigoTypes.STRING_LITERAL)

}