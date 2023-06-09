package com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoLanguage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Colors


open class JsLigoTokenType(debugName: String, private val keys: Array<TextAttributesKey>) :
    IElementType(debugName, JsLigoLanguage.INSTANCE) {

    fun getHighlights(): Array<TextAttributesKey> = keys
}

object Tokens {
    @JvmField
    val COLON = token(":")

    @JvmField
    val CONST = keyword("const")

    @JvmField
    val EQ = operator("=")

    @JvmField
    val ID = token("ID", "ID" to Colors.IDENTIFIER)

    @JvmField
    val INT_LITERAL = token("INT_LITERAL", "INTEGER" to Colors.NUMBER)

    @JvmField
    val LET = keyword("let")

    @JvmField
    val SEMICOLON = token(";", "SEMICOLON" to Colors.SEMICOLON)

    @JvmField
    val STRING_LITERAL = token("STRING_LITERAL", " STRING" to Colors.STRING)

    @JvmField
    val LEFT_ANGLE_BRACKET = token("<", "LEFT_ANGLE_BRACKET" to Colors.PARENTHESES)

    @JvmField
    val RIGHT_ANGLE_BRACKET = token(">", "RIGHT_ANGLE_BRACKET" to Colors.PARENTHESES)

    @JvmField
    val COMMA = token(",", " COMMA" to Colors.COMMA)

    @JvmField
    val OPEN_PAREN = token("(", "OPEN_PAREN" to Colors.PARENTHESES)

    @JvmField
    val CLOSE_PAREN = token(")", "CLOSE_PAREN" to Colors.PARENTHESES)

    @JvmField
    val OPEN_BRACKET = token("[", "OPEN_BRACKET" to Colors.BRACKETS)

    @JvmField
    val CLOSE_BRACKET = token("]", "CLOSE_BRACKET" to Colors.BRACKETS)

    @JvmField
    val DOT = token(".", "DOT" to Colors.DOT)

    @JvmField
    val AS = keyword("as")

    @JvmField
    val PLUS = operator("+")

    @JvmField
    val MINUS = operator("-")

    @JvmField
    val MUL = operator("*")

    @JvmField
    val DIV = operator("/")

    @JvmField
    val MODULO = operator("%")

    @JvmField
    val BANG = operator("!")

    @JvmField
    val TRUE = keyword("true")

    @JvmField
    val FALSE = keyword("false")

    @JvmField
    val AND = operator("&&")

    @JvmField
    val PIPE = operator("|")

    @JvmField
    val LINE_COMMENT = token("inline comment", "LINE_COMMENT" to Colors.LINE_COMMENT)

    @JvmField
    val BLOCK_COMMENT = token("block comment", "BLOCK_COMMENT" to Colors.BLOCK_COMMENT)

    @JvmField
    val OPEN_BRACE = token("{", "OPEN_BRACE" to Colors.BRACES)

    @JvmField
    val CLOSE_BRACE = token("}", "CLOSE_BRACE" to Colors.BRACES)

    @JvmField
    val SPREAD = operator("...")

    @JvmField
    val AT = token("@", "AT" to Colors.METADATA)
}

object TokenSets {
    val COMMENTS = TokenSet.create(Tokens.LINE_COMMENT, Tokens.BLOCK_COMMENT)
    val STRING_LITERALS = TokenSet.create(Tokens.STRING_LITERAL)
}

fun token(debugName: String, keys: Array<TextAttributesKey> = arrayOf()) = JsLigoTokenType(debugName, keys)

fun token(debugName: String, key: Pair<String, TextAttributesKey>) = token(debugName, arrayOf(createTextAttributesKey(key.first, key.second)))

fun keyword(debugName: String) = token(debugName, "KEYWORD" to Colors.KEYWORD)

fun operator(debugName: String) = token(debugName, "OPERATOR" to Colors.OPERATION_SIGN)
