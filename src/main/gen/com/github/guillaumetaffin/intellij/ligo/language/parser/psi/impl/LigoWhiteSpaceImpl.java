// This is a generated file. Not intended for manual editing.
package com.github.guillaumetaffin.intellij.ligo.language.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.guillaumetaffin.intellij.ligo.language.parser.psi.LigoTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.guillaumetaffin.intellij.ligo.language.parser.psi.*;

public class LigoWhiteSpaceImpl extends ASTWrapperPsiElement implements LigoWhiteSpace {

  public LigoWhiteSpaceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LigoVisitor visitor) {
    visitor.visitWhiteSpace(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LigoVisitor) accept((LigoVisitor)visitor);
    else super.accept(visitor);
  }

}
