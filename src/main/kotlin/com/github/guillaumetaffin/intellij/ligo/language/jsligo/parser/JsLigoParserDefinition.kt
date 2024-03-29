package com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoLanguage
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.JsLigoLexerAdapter
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.lexer.TokenSets
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.psi.JsLigoFile
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.psi.JsLigoTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class JsLigoParserDefinition : ParserDefinition {

    companion object {
        @JvmStatic
        val FILE = IFileElementType(JsLigoLanguage.INSTANCE)
    }

    override fun createLexer(project: Project?): Lexer = JsLigoLexerAdapter()

    override fun createParser(project: Project?): PsiParser = JsLigoParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSets.STRING_LITERALS

    override fun createElement(node: ASTNode?): PsiElement = JsLigoTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = JsLigoFile(viewProvider)

}
