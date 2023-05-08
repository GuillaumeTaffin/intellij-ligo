package com.github.guillaumetaffin.intellij.ligo.language.jsligo.psi

import com.github.guillaumetaffin.intellij.ligo.language.jsligo.JsLigoLanguage
import com.intellij.psi.tree.IElementType

class JsLigoElementType(debugName: String): IElementType(debugName, JsLigoLanguage.INSTANCE)