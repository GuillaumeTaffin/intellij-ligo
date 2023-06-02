package com.github.guillaumetaffin.intellij.ligo.language.lsp

import com.intellij.openapi.application.PreloadingActivity
import org.wso2.lsp4intellij.IntellijLanguageClient
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.RawCommandServerDefinition

class LspPreloadingActivity : PreloadingActivity() {

    override fun preload() {
        IntellijLanguageClient.addServerDefinition(RawCommandServerDefinition(
            "jsligo,mligo",
            arrayOf("/opt/homebrew/bin/ligo", "lsp")
        ))

    }
}
