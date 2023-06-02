// This is a generated file. Not intended for manual editing.
package com.github.guillaumetaffin.intellij.ligo.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.guillaumetaffin.intellij.ligo.language.parser.psi.LigoTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LigoParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ligoFile(b, l + 1);
  }

  /* ********************************************************** */
  // CHARACTER
  static boolean character(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "character")) return false;
    if (!nextTokenIs(b, CHARACTER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = consumeToken(b, CHARACTER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (text | white_space)*
  static boolean ligoFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ligoFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ligoFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ligoFile", c)) break;
    }
    return true;
  }

  // text | white_space
  private static boolean ligoFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ligoFile_0")) return false;
    boolean r;
    r = text(b, l + 1);
    if (!r) r = white_space(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // character +
  public static boolean text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text")) return false;
    if (!nextTokenIs(b, CHARACTER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = character(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!character(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text", c)) break;
    }
    exit_section_(b, m, TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // WHITE_SPACE +
  public static boolean white_space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "white_space")) return false;
    if (!nextTokenIs(b, WHITE_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "white_space", c)) break;
    }
    exit_section_(b, m, WHITE_SPACE, r);
    return r;
  }

}
