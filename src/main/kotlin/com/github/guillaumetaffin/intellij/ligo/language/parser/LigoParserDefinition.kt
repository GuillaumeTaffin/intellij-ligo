package com.github.guillaumetaffin.intellij.ligo.language.parser

import com.github.guillaumetaffin.intellij.ligo.language.LigoLanguage
import com.github.guillaumetaffin.intellij.ligo.language.parser.psi.LigoFile
import com.intellij.lexer.EmptyLexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.registry.Registry
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateHighlightingLexer
import org.jetbrains.plugins.textmate.psi.TextMateParserDefinition

class LigoParserDefinition : TextMateParserDefinition() {

    companion object {
        @JvmStatic
        val FILE = IFileElementType(LigoLanguage.INSTANCE)
    }

    override fun createLexer(project: Project): Lexer {
        val textmateService = project.service<TextMateService>()
        val languageDescriptor = textmateService.getLanguageDescriptorByExtension("jsligo") ?: return EmptyLexer()

        return TextMateHighlightingLexer(
            languageDescriptor,
            Registry.get("textmate.line.highlighting.limit").asInteger()
        )
    }

    override fun getFileNodeType(): IFileElementType = FILE

    override fun createFile(viewProvider: FileViewProvider): PsiFile = LigoFile(viewProvider)

}
