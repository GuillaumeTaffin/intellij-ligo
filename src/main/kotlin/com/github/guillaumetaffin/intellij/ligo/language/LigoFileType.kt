package com.github.guillaumetaffin.intellij.ligo.language

import com.github.guillaumetaffin.intellij.ligo.language.common.LigoIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class LigoFileType: LanguageFileType(LigoLanguage.INSTANCE) {

    companion object {
        @JvmStatic
        val INSTANCE = LigoFileType()
    }

    override fun getName(): String = "Ligo File"

    override fun getDescription(): String = "Ligo language file"

    override fun getDefaultExtension(): String = "jsligo"

    override fun getIcon(): Icon = LigoIcons.LOGO
}
