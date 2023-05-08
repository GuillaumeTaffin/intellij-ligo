package com.github.guillaumetaffin.intellij.ligo.language.jsligo.syntax

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.JsLigoLexerAdapter
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JsLigoSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer = JsLigoLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when(tokenType) {
            JsLigoTypes.ASSIGNMENT_OPERATOR -> AttributeKeys.SEPARATOR_KEYS
            JsLigoTypes.TYPE_DEF_KEYWORD -> AttributeKeys.KEYWORD_KEYS
            JsLigoTypes.SEMICOLON -> AttributeKeys.SEMICOLON_KEYS
            TokenType.BAD_CHARACTER -> AttributeKeys.BAD_CHARACTER_KEYS
            else -> AttributeKeys.EMPTY_KEYS
        }
    }
}

object Token {
    val ASSIGNMENT_SEPARATOR = createTextAttributesKey("JSLIGO_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val KEYWORD = createTextAttributesKey("JSLIGO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val SEMICOLON = createTextAttributesKey("JSLIGO_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
    val BAD_CHARACTER = createTextAttributesKey("JSLIGO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
}

object AttributeKeys {
    val SEPARATOR_KEYS = arrayOf(Token.ASSIGNMENT_SEPARATOR)
    val KEYWORD_KEYS = arrayOf(Token.KEYWORD)
    val SEMICOLON_KEYS = arrayOf(Token.SEMICOLON)
    val BAD_CHARACTER_KEYS = arrayOf(Token.BAD_CHARACTER)
    val EMPTY_KEYS = arrayOf<TextAttributesKey>()
}
