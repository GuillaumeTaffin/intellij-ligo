package com.github.guillaumetaffin.intellij.ligo.language.jsligo.parser.psi

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoFileType
import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class JsLigoFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, JsLigoLanguage.INSTANCE) {
    override fun getFileType(): FileType = JsLigoFileType.INSTANCE

    override fun toString(): String {
        return "Ligo File"
    }

}
