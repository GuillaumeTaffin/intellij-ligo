package com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

object JsLigoTokenSets {

    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)

    val STRING_LITERALS: TokenSet = TokenSet.create(JsLigoTypes.STRING_LITERAL)

    val COMMENTS: TokenSet = TokenSet.create(
        JsLigoCommentTokens.COMMENT_START,
        JsLigoCommentTokens.COMMENT_TEXT,
        JsLigoCommentTokens.COMMENT_END
    )

}

object JsLigoCommentTokens {
    @JvmField
    val COMMENT_START = JsLigoTokenType("COMMENT_START");

    @JvmField
    val COMMENT_TEXT = JsLigoTokenType("COMMENT_TEXT");

    @JvmField
    val COMMENT_END = JsLigoTokenType("COMMENT_END");
}