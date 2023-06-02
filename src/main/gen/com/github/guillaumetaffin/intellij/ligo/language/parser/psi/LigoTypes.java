// This is a generated file. Not intended for manual editing.
package com.github.guillaumetaffin.intellij.ligo.language.parser.psi;

import com.github.guillaumetaffin.intellij.ligo.language.parser.psi.impl.LigoTextImpl;
import com.github.guillaumetaffin.intellij.ligo.language.parser.psi.impl.LigoWhiteSpaceImpl;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface LigoTypes {

    IElementType TEXT = new LigoElementType("TEXT");
    IElementType WHITE_SPACE = new LigoElementType("WHITE_SPACE");

    IElementType CHARACTER = new LigoTokenType("CHARACTER");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == TEXT) {
                return new LigoTextImpl(node);
            } else if (type == WHITE_SPACE) {
                return new LigoWhiteSpaceImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
