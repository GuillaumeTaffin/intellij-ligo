package com.github.guillaumetaffin.intellij.ligo.language.jsligo.syntax

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.JsLigoLexerAdapter
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi.JsLigoTypes.*
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
        return when {
            tokenType.isSeparator() -> AttributeKeys.SEPARATOR_KEYS
            tokenType.isKeyWord() -> AttributeKeys.KEYWORD_KEYS
            tokenType.isSemicolon() -> AttributeKeys.SEMICOLON_KEYS
            tokenType.isStringLiteral() -> AttributeKeys.STRING_LITERAL_KEYS
            tokenType.isLineComment() -> AttributeKeys.LINE_COMMENT_KEYS
            tokenType.isNumberLiteral() -> AttributeKeys.NUMBER_LITERAL_KEYS
            tokenType.isBadCharacter() -> AttributeKeys.BAD_CHARACTER_KEYS
            else -> AttributeKeys.EMPTY_KEYS
        }
    }
}

private fun IElementType?.isBadCharacter() = this == TokenType.BAD_CHARACTER

private fun IElementType?.isSemicolon() = this == SEMICOLON

private fun IElementType?.isStringLiteral() = this == STRING_PATTERN

private fun IElementType?.isLineComment() =
    this == LINE_COMMENT_START
            || this == COMMENT_TEXT

private fun IElementType?.isNumberLiteral() = this == NUMBER_LITERAL

private fun IElementType?.isSeparator(): Boolean = this == EQ

private fun IElementType?.isKeyWord(): Boolean =
    this == TYPE_ALIAS_KW
            || this == LET_KW
            || this == CONST_KW
            || this == AS_KW


object Token {
    val ASSIGNMENT_SEPARATOR =
        createTextAttributesKey("JSLIGO_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val KEYWORD = createTextAttributesKey("JSLIGO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val SEMICOLON = createTextAttributesKey("JSLIGO_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
    val STRING_LITERAL = createTextAttributesKey("JSLIGO_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING)
    val LINE_COMMENT = createTextAttributesKey("JSLIGO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val NUMBER_LITERAL = createTextAttributesKey("JSLIGO_STRING_LITERAL", DefaultLanguageHighlighterColors.NUMBER)
    val BAD_CHARACTER = createTextAttributesKey("JSLIGO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
}

object AttributeKeys {
    val SEPARATOR_KEYS = arrayOf(Token.ASSIGNMENT_SEPARATOR)
    val KEYWORD_KEYS = arrayOf(Token.KEYWORD)
    val SEMICOLON_KEYS = arrayOf(Token.SEMICOLON)
    val STRING_LITERAL_KEYS = arrayOf(Token.STRING_LITERAL)
    val LINE_COMMENT_KEYS = arrayOf(Token.LINE_COMMENT)
    val NUMBER_LITERAL_KEYS = arrayOf(Token.NUMBER_LITERAL)
    val BAD_CHARACTER_KEYS = arrayOf(Token.BAD_CHARACTER)
    val EMPTY_KEYS = arrayOf<TextAttributesKey>()
}
