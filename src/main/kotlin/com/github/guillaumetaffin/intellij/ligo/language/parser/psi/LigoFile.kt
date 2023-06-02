package com.github.guillaumetaffin.intellij.ligo.language.parser.psi

import com.github.guillaumetaffin.intellij.ligo.language.LigoFileType
import com.github.guillaumetaffin.intellij.ligo.language.LigoLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class LigoFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LigoLanguage.INSTANCE) {
    override fun getFileType(): FileType = LigoFileType.INSTANCE

    override fun toString(): String {
        return "Ligo File"
    }

}
