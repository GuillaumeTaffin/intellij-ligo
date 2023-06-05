package com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.highlighting

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.JsLigoLexerAdapter
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.JsLigoTokenType
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JsLigoSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        private val BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val BAD_CHAR_KEYS: Array<TextAttributesKey> = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS: Array<TextAttributesKey> = arrayOf()
    }

    override fun getHighlightingLexer(): Lexer = JsLigoLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType is JsLigoTokenType) {
            return tokenType.getHighlights()
        }
        if (tokenType == TokenType.BAD_CHARACTER) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}

