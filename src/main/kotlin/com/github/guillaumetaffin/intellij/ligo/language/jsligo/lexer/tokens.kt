package com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoLanguage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.psi.tree.IElementType
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
    val EQ = token("=", "EQ" to Colors.OPERATION_SIGN)

    @JvmField
    val ID = token("ID", "ID" to Colors.IDENTIFIER)

    @JvmField
    val INT_LITERAL = token("INT_LITERAL", "INTEGER" to Colors.NUMBER)

    @JvmField
    val LET = keyword("let")

    @JvmField
    val NEW_LINE = token("NEW_LINE")

    @JvmField
    val SEMICOLON = token(";", "SEMICOLON" to Colors.SEMICOLON)

    @JvmField
    val STRING_LITERAL = token("STRING_LITERAL", " STRING" to Colors.STRING)
}

fun token(debugName: String, keys: Array<TextAttributesKey> = arrayOf()) = JsLigoTokenType(debugName, keys)

fun token(debugName: String, key: Pair<String, TextAttributesKey>) = token(debugName, arrayOf(createTextAttributesKey(key.first, key.second)))

fun keyword(debugName: String) = token(debugName, "KEYWORD" to Colors.KEYWORD)
