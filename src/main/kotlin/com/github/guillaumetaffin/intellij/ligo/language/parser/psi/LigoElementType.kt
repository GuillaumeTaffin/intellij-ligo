package com.github.guillaumetaffin.intellij.ligo.language.parser.psi

import com.github.guillaumetaffin.intellij.ligo.language.LigoLanguage
import com.intellij.psi.tree.IElementType

class LigoElementType(debugName: String) : IElementType(debugName, LigoLanguage.INSTANCE) {
}
