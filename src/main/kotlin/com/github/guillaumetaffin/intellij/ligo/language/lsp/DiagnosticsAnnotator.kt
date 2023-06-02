package com.github.guillaumetaffin.intellij.ligo.language.lsp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.wso2.lsp4intellij.editor.EditorEventManagerBase


class DiagnosticsAnnotator : ExternalAnnotator<Editor, Editor>(), DumbAware {

    override fun collectInformation(file: PsiFile, editor: Editor, hasErrors: Boolean): Editor {
        return editor
    }

    override fun doAnnotate(editor: Editor): Editor {
        return editor
    }

    override fun apply(file: PsiFile, editor: Editor, holder: AnnotationHolder) {
        EditorEventManagerBase
            .managersForUri(file.virtualFile.url)
            .flatMap { it.diagnostics }
            .forEach { diagnostic -> createAnnotation(holder, diagnostic, editor.document) }
    }

    private fun createAnnotation(holder: AnnotationHolder, diagnostic: Diagnostic, document: Document) =
        holder.newAnnotation(pickHighlight(diagnostic.severity), diagnostic.message)
            .range(document.textRange(diagnostic.range))
            .create()

    private fun Document.textRange(range: Range): TextRange {
        val rStart = offsetFrom(range.start)
        val rEnd = offsetFrom(range.end)
        return TextRange.create(rStart, rEnd)
    }

    private fun Document.offsetFrom(position: Position) = getLineStartOffset(position.line) + position.character

    private fun pickHighlight(severity: DiagnosticSeverity): HighlightSeverity = when (severity) {
        DiagnosticSeverity.Error -> HighlightSeverity.ERROR
        DiagnosticSeverity.Warning -> HighlightSeverity.WARNING
        DiagnosticSeverity.Information -> HighlightSeverity.WEAK_WARNING
        DiagnosticSeverity.Hint -> HighlightSeverity.INFORMATION
    }

}
