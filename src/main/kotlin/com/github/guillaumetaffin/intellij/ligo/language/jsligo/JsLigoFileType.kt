package com.github.guillaumetaffin.intellij.ligo.language.jsligo

import com.github.guillaumetaffin.intellij.ligo.language.common.LigoIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class JsLigoFileType : LanguageFileType(JsLigoLanguage.INSTANCE) {

    companion object {
        @JvmStatic
        val INSTANCE = JsLigoFileType()
    }

    override fun getName(): String = "JsLigo File"

    override fun getDescription(): String = "JsLigo language file"

    override fun getDefaultExtension(): String = "jsligo"

    override fun getIcon(): Icon = LigoIcons.LOGO
}
