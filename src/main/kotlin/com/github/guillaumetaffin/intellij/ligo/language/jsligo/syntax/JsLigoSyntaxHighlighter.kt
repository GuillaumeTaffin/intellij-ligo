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
        return when (tokenType) {
            ASSIGNMENT_OPERATOR -> AttributeKeys.SEPARATOR_KEYS
            TYPE_DEF_KW, LET_KW, CONST_KW -> AttributeKeys.KEYWORD_KEYS
            SEMICOLON -> AttributeKeys.SEMICOLON_KEYS
            STRING_LITERAL -> AttributeKeys.STRING_LITERAL_KEYS
            TokenType.BAD_CHARACTER -> AttributeKeys.BAD_CHARACTER_KEYS
            else -> AttributeKeys.EMPTY_KEYS
        }
    }
}

object Token {
    val ASSIGNMENT_SEPARATOR =
        createTextAttributesKey("JSLIGO_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val KEYWORD = createTextAttributesKey("JSLIGO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val SEMICOLON = createTextAttributesKey("JSLIGO_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
    val STRING_LITERAL = createTextAttributesKey("JSLIGO_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING)
    val BAD_CHARACTER = createTextAttributesKey("JSLIGO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
}

object AttributeKeys {
    val SEPARATOR_KEYS = arrayOf(Token.ASSIGNMENT_SEPARATOR)
    val KEYWORD_KEYS = arrayOf(Token.KEYWORD)
    val SEMICOLON_KEYS = arrayOf(Token.SEMICOLON)
    val STRING_LITERAL_KEYS = arrayOf(Token.STRING_LITERAL)
    val BAD_CHARACTER_KEYS = arrayOf(Token.BAD_CHARACTER)
    val EMPTY_KEYS = arrayOf<TextAttributesKey>()
}
