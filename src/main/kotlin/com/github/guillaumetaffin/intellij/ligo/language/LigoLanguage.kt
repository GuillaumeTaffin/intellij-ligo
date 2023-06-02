package com.github.guillaumetaffin.intellij.ligo.language

import com.intellij.lang.Language

class LigoLanguage : Language("Ligo") {

    companion object {
        @JvmField
        val INSTANCE = LigoLanguage()
    }

}
