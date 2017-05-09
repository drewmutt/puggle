// This is a generated file. Not intended for manual editing.
package com.mwplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.mwplugin.psi.MediaWikiTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MediaWikiParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == CSS) {
      r = CSS(b, 0);
    }
    else if (t == EOF) {
      r = EOF(b, 0);
    }
    else if (t == LEGAL_URL_ENTITY) {
      r = LEGAL_URL_ENTITY(b, 0);
    }
    else if (t == WHITESPACES) {
      r = Whitespaces(b, 0);
    }
    else if (t == ALL_INLINE_ELEMENTS) {
      r = consumeToken(b, all_inline_elements);
    }
    else if (t == ANY_SUPPORTED_UNICODE_CHARACTER) {
      r = consumeToken(b, any_supported_unicode_character);
    }
    else if (t == ARTICLE) {
      r = article(b, 0);
    }
    else if (t == ARTICLE_LINK) {
      r = consumeToken(b, article_link);
    }
    else if (t == ARTICLE_TITLE) {
      r = consumeToken(b, article_title);
    }
    else if (t == BAD_TITLE_CHARACTERS) {
      r = consumeToken(b, bad_title_characters);
    }
    else if (t == BEHAVIOUR_SWITCH) {
      r = consumeToken(b, behaviour_switch);
    }
    else if (t == BEHAVIOURSWITCH_FORCETOC) {
      r = consumeToken(b, behaviourswitch_forcetoc);
    }
    else if (t == BEHAVIOURSWITCH_NOEDITSECTION) {
      r = consumeToken(b, behaviourswitch_noeditsection);
    }
    else if (t == BEHAVIOURSWITCH_NOGALLERY) {
      r = consumeToken(b, behaviourswitch_nogallery);
    }
    else if (t == BEHAVIOURSWITCH_NOTOC) {
      r = consumeToken(b, behaviourswitch_notoc);
    }
    else if (t == BEHAVIOURSWITCH_TOC) {
      r = consumeToken(b, behaviourswitch_toc);
    }
    else if (t == BOLD_ITALIC_TEXT) {
      r = consumeToken(b, bold_italic_text);
    }
    else if (t == BOLD_TEXT) {
      r = consumeToken(b, bold_text);
    }
    else if (t == BULLET_ITEM) {
      r = consumeToken(b, bullet_item);
    }
    else if (t == CANONICAL_PAGE_CHAR) {
      r = consumeToken(b, canonical_page_char);
    }
    else if (t == CAPTION) {
      r = caption(b, 0);
    }
    else if (t == CATEGORY_LINK) {
      r = consumeToken(b, category_link);
    }
    else if (t == CATEGORY_NAMESPACE) {
      r = consumeToken(b, category_namespace);
    }
    else if (t == CELL_CONTENT) {
      r = consumeToken(b, cell_content);
    }
    else if (t == CELL_FORMATTING) {
      r = consumeToken(b, cell_formatting);
    }
    else if (t == CHARACTER) {
      r = character(b, 0);
    }
    else if (t == CHARACTERS) {
      r = characters(b, 0);
    }
    else if (t == CONTENT_NON_PIPE) {
      r = consumeToken(b, content_non_pipe);
    }
    else if (t == DASHES) {
      r = dashes(b, 0);
    }
    else if (t == DECIMAL_NUMBER) {
      r = consumeToken(b, decimal_number);
    }
    else if (t == DEFINED_TERM) {
      r = consumeToken(b, defined_term);
    }
    else if (t == DEFINITION) {
      r = definition(b, 0);
    }
    else if (t == DIGITS) {
      r = digits(b, 0);
    }
    else if (t == ENUMERATED_ITEM) {
      r = consumeToken(b, enumerated_item);
    }
    else if (t == EXTERNAL_LINK) {
      r = consumeToken(b, external_link);
    }
    else if (t == EXTRA_DESCRIPTION) {
      r = consumeToken(b, extra_description);
    }
    else if (t == FORMATTED_TEXT) {
      r = consumeToken(b, formatted_text);
    }
    else if (t == FRIENDLY_REF_LINK_CHAR) {
      r = consumeToken(b, friendly_ref_link_char);
    }
    else if (t == GALLERY_BLOCK) {
      r = consumeToken(b, gallery_block);
    }
    else if (t == GALLERY_IMAGE) {
      r = consumeToken(b, gallery_image);
    }
    else if (t == HEX_DIGIT) {
      r = consumeToken(b, hex_digit);
    }
    else if (t == HEX_NUMBER) {
      r = consumeToken(b, hex_number);
    }
    else if (t == HORIZONTAL_RULE) {
      r = consumeToken(b, horizontal_rule);
    }
    else if (t == HTML_BLOCK) {
      r = consumeToken(b, html_block);
    }
    else if (t == HTML_BODY) {
      r = consumeToken(b, html_body);
    }
    else if (t == HTML_CLOSING_TAG) {
      r = consumeToken(b, html_closing_tag);
    }
    else if (t == HTML_COMMENT) {
      r = consumeToken(b, html_comment);
    }
    else if (t == HTML_ENTITY) {
      r = consumeToken(b, html_entity);
    }
    else if (t == HTML_OPENING_TAG) {
      r = consumeToken(b, html_opening_tag);
    }
    else if (t == HTML_TAG) {
      r = consumeToken(b, html_tag);
    }
    else if (t == HTML_TAG_CLOSE) {
      r = consumeToken(b, html_tag_close);
    }
    else if (t == HTML_TAG_CONTENT) {
      r = consumeToken(b, html_tag_content);
    }
    else if (t == HTML_TAG_NAME) {
      r = consumeToken(b, html_tag_name);
    }
    else if (t == HTML_TAG_PROPERTIES) {
      r = consumeToken(b, html_tag_properties);
    }
    else if (t == HTML_UNSAFE_SYMBOL) {
      r = consumeToken(b, html_unsafe_symbol);
    }
    else if (t == IMAGE_ALIGN_CENTER) {
      r = consumeToken(b, image_align_center);
    }
    else if (t == IMAGE_ALIGN_LEFT) {
      r = consumeToken(b, image_align_left);
    }
    else if (t == IMAGE_ALIGN_NONE) {
      r = consumeToken(b, image_align_none);
    }
    else if (t == IMAGE_ALIGN_PARAMETER) {
      r = consumeToken(b, image_align_parameter);
    }
    else if (t == IMAGE_ALIGN_RIGHT) {
      r = consumeToken(b, image_align_right);
    }
    else if (t == IMAGE_EXTENSION) {
      r = consumeToken(b, image_extension);
    }
    else if (t == IMAGE_INLINE) {
      r = consumeToken(b, image_inline);
    }
    else if (t == IMAGE_MODE_AUTO_THUMB) {
      r = consumeToken(b, image_mode_auto_thumb);
    }
    else if (t == IMAGE_MODE_FRAME) {
      r = consumeToken(b, image_mode_frame);
    }
    else if (t == IMAGE_MODE_FRAMELESS) {
      r = consumeToken(b, image_mode_frameless);
    }
    else if (t == IMAGE_MODE_MANUAL_THUMB) {
      r = consumeToken(b, image_mode_manual_thumb);
    }
    else if (t == IMAGE_MODE_PARAMETER) {
      r = consumeToken(b, image_mode_parameter);
    }
    else if (t == IMAGE_NAME) {
      r = consumeToken(b, image_name);
    }
    else if (t == IMAGE_OPTION) {
      r = consumeToken(b, image_option);
    }
    else if (t == IMAGE_OTHER_PARAMETER) {
      r = consumeToken(b, image_other_parameter);
    }
    else if (t == IMAGE_PARAM_BORDER) {
      r = consumeToken(b, image_param_border);
    }
    else if (t == IMAGE_PARAM_PAGE) {
      r = consumeToken(b, image_param_page);
    }
    else if (t == IMAGE_PARAM_UPRIGHT) {
      r = consumeToken(b, image_param_upright);
    }
    else if (t == IMAGE_SIZE_PARAMETER) {
      r = consumeToken(b, image_size_parameter);
    }
    else if (t == IMAGE_VALIGN_BASELINE) {
      r = consumeToken(b, image_valign_baseline);
    }
    else if (t == IMAGE_VALIGN_BOTTOM) {
      r = consumeToken(b, image_valign_bottom);
    }
    else if (t == IMAGE_VALIGN_MIDDLE) {
      r = consumeToken(b, image_valign_middle);
    }
    else if (t == IMAGE_VALIGN_PARAMETER) {
      r = consumeToken(b, image_valign_parameter);
    }
    else if (t == IMAGE_VALIGN_SUB) {
      r = consumeToken(b, image_valign_sub);
    }
    else if (t == IMAGE_VALIGN_SUPER) {
      r = consumeToken(b, image_valign_super);
    }
    else if (t == IMAGE_VALIGN_TEXT_BOTTOM) {
      r = consumeToken(b, image_valign_text_bottom);
    }
    else if (t == IMAGE_VALIGN_TEXT_TOP) {
      r = consumeToken(b, image_valign_text_top);
    }
    else if (t == IMAGE_VALIGN_TOP) {
      r = consumeToken(b, image_valign_top);
    }
    else if (t == INDENT_ITEM) {
      r = consumeToken(b, indent_item);
    }
    else if (t == INLINE_ELEMENT) {
      r = consumeToken(b, inline_element);
    }
    else if (t == INLINE_ELEMENT_SANS_PIPE) {
      r = consumeToken(b, inline_element_sans_pipe);
    }
    else if (t == INLINE_TEXT) {
      r = consumeToken(b, inline_text);
    }
    else if (t == INTERNAL_LINK) {
      r = consumeToken(b, internal_link);
    }
    else if (t == INTERNAL_LINK_END) {
      r = consumeToken(b, internal_link_end);
    }
    else if (t == INTERNAL_LINK_PROPERTY) {
      r = consumeToken(b, internal_link_property);
    }
    else if (t == INTERNAL_LINK_START) {
      r = consumeToken(b, internal_link_start);
    }
    else if (t == INTERNAL_LINK_UNASSIGNED_PROPERTY) {
      r = consumeToken(b, internal_link_unassigned_property);
    }
    else if (t == INTERWIKI) {
      r = interwiki(b, 0);
    }
    else if (t == INTERWIKI_PREFIX) {
      r = consumeToken(b, interwiki_prefix);
    }
    else if (t == ISBN) {
      r = isbn(b, 0);
    }
    else if (t == ITALIC_TEXT) {
      r = consumeToken(b, italic_text);
    }
    else if (t == ITEM_BODY) {
      r = consumeToken(b, item_body);
    }
    else if (t == LETTER) {
      r = letter(b, 0);
    }
    else if (t == LEVEL_2_HEADING) {
      r = consumeToken(b, level_2_heading);
    }
    else if (t == LEVEL_2_SECTION) {
      r = consumeToken(b, level_2_section);
    }
    else if (t == LEVEL_3_HEADING) {
      r = consumeToken(b, level_3_heading);
    }
    else if (t == LEVEL_3_SECTION) {
      r = consumeToken(b, level_3_section);
    }
    else if (t == LEVEL_4_HEADING) {
      r = consumeToken(b, level_4_heading);
    }
    else if (t == LEVEL_4_SECTION) {
      r = consumeToken(b, level_4_section);
    }
    else if (t == LEVEL_5_HEADING) {
      r = consumeToken(b, level_5_heading);
    }
    else if (t == LEVEL_5_SECTION) {
      r = consumeToken(b, level_5_section);
    }
    else if (t == LINE) {
      r = line(b, 0);
    }
    else if (t == LINES_OF_TEXT) {
      r = consumeToken(b, lines_of_text);
    }
    else if (t == LINK) {
      r = link(b, 0);
    }
    else if (t == LINK_DESCRIPTION) {
      r = consumeToken(b, link_description);
    }
    else if (t == LIST_ITEM) {
      r = consumeToken(b, list_item);
    }
    else if (t == MAGIC_LINK) {
      r = consumeToken(b, magic_link);
    }
    else if (t == MEDIA_EXTENSION) {
      r = consumeToken(b, media_extension);
    }
    else if (t == MEDIA_INLINE) {
      r = consumeToken(b, media_inline);
    }
    else if (t == NAMED_REFERENCE_BLOCK) {
      r = consumeToken(b, named_reference_block);
    }
    else if (t == NAMED_REFERENCE_BLOCK_SELF_CLOSING) {
      r = consumeToken(b, named_reference_block_self_closing);
    }
    else if (t == NAMED_REFERENCE_BLOCK_URL) {
      r = consumeToken(b, named_reference_block_url);
    }
    else if (t == NAMESPACE) {
      r = namespace(b, 0);
    }
    else if (t == NAMESPACE_PREFIX) {
      r = consumeToken(b, namespace_prefix);
    }
    else if (t == NON_WHITESPACE_CHAR) {
      r = consumeToken(b, non_whitespace_char);
    }
    else if (t == NOPARSE_BLOCK) {
      r = consumeToken(b, noparse_block);
    }
    else if (t == NOWIKI_BLOCK) {
      r = consumeToken(b, nowiki_block);
    }
    else if (t == NOWIKI_BODY) {
      r = consumeToken(b, nowiki_body);
    }
    else if (t == NOWIKI_CLOSING_TAG) {
      r = consumeToken(b, nowiki_closing_tag);
    }
    else if (t == NOWIKI_OPENING_TAG) {
      r = consumeToken(b, nowiki_opening_tag);
    }
    else if (t == PAGE) {
      r = page(b, 0);
    }
    else if (t == PAGE_CHAR) {
      r = consumeToken(b, page_char);
    }
    else if (t == PAGE_FIRST_CHAR) {
      r = consumeToken(b, page_first_char);
    }
    else if (t == PAGE_NAME) {
      r = consumeToken(b, page_name);
    }
    else if (t == PARAGRAPH) {
      r = paragraph(b, 0);
    }
    else if (t == PARAGRAPH_AND_MORE) {
      r = consumeToken(b, paragraph_and_more);
    }
    else if (t == PLAIN_TEXT) {
      r = consumeToken(b, plain_text);
    }
    else if (t == PMID_NUMBER) {
      r = consumeToken(b, pmid_number);
    }
    else if (t == PRE_BLOCK) {
      r = consumeToken(b, pre_block);
    }
    else if (t == PRE_BODY) {
      r = consumeToken(b, pre_body);
    }
    else if (t == PRE_CLOSING_TAG) {
      r = consumeToken(b, pre_closing_tag);
    }
    else if (t == PRE_OPENING_TAG) {
      r = consumeToken(b, pre_opening_tag);
    }
    else if (t == PROPERTY_ASSIGNMENT) {
      r = consumeToken(b, property_assignment);
    }
    else if (t == PROTOCOL) {
      r = protocol(b, 0);
    }
    else if (t == REFERENCE_BLOCK) {
      r = consumeToken(b, reference_block);
    }
    else if (t == REFERENCE_CLOSING_TAG) {
      r = consumeToken(b, reference_closing_tag);
    }
    else if (t == REFERENCE_CONTENT) {
      r = consumeToken(b, reference_content);
    }
    else if (t == REFERENCE_NAME) {
      r = consumeToken(b, reference_name);
    }
    else if (t == REFERENCE_OPENING_TAG) {
      r = consumeToken(b, reference_opening_tag);
    }
    else if (t == REFERENCE_OPENING_TAG_COMPLETE) {
      r = consumeToken(b, reference_opening_tag_complete);
    }
    else if (t == RFC_NUMBER) {
      r = consumeToken(b, rfc_number);
    }
    else if (t == SECTION) {
      r = section(b, 0);
    }
    else if (t == SECTION_ID) {
      r = consumeToken(b, section_id);
    }
    else if (t == SECTION_NAME) {
      r = consumeToken(b, section_name);
    }
    else if (t == SINGLE_LINE_ANY_CONTENT) {
      r = consumeToken(b, single_line_any_content);
    }
    else if (t == SORT_KEY) {
      r = consumeToken(b, sort_key);
    }
    else if (t == SPACE_TAB) {
      r = consumeToken(b, space_tab);
    }
    else if (t == SPACE_TABS) {
      r = consumeToken(b, space_tabs);
    }
    else if (t == SPACES) {
      r = spaces(b, 0);
    }
    else if (t == SPECIAL_BLOCK) {
      r = consumeToken(b, special_block);
    }
    else if (t == SPECIAL_BLOCK_AND_MORE) {
      r = consumeToken(b, special_block_and_more);
    }
    else if (t == SUB_PAGE) {
      r = consumeToken(b, sub_page);
    }
    else if (t == SUB_PAGE_SEPARATOR) {
      r = consumeToken(b, sub_page_separator);
    }
    else if (t == SYMBOL) {
      r = symbol(b, 0);
    }
    else if (t == TABLE) {
      r = table(b, 0);
    }
    else if (t == TABLE_BLOCK) {
      r = consumeToken(b, table_block);
    }
    else if (t == TABLE_CELL) {
      r = consumeToken(b, table_cell);
    }
    else if (t == TABLE_CELL_DOUBLE_DELIMITED) {
      r = consumeToken(b, table_cell_double_delimited);
    }
    else if (t == TABLE_CELL_DOUBLE_DELIMITED_START) {
      r = consumeToken(b, table_cell_double_delimited_start);
    }
    else if (t == TABLE_END) {
      r = consumeToken(b, table_end);
    }
    else if (t == TABLE_HEADER) {
      r = consumeToken(b, table_header);
    }
    else if (t == TABLE_HEADER_DOUBLE_DELIMITED) {
      r = consumeToken(b, table_header_double_delimited);
    }
    else if (t == TABLE_HEADER_DOUBLE_DELIMITED_START) {
      r = consumeToken(b, table_header_double_delimited_start);
    }
    else if (t == TABLE_HEADER_ROW_START) {
      r = consumeToken(b, table_header_row_start);
    }
    else if (t == TABLE_PARAMETERS) {
      r = consumeToken(b, table_parameters);
    }
    else if (t == TABLE_ROW) {
      r = consumeToken(b, table_row);
    }
    else if (t == TABLE_ROW_START) {
      r = consumeToken(b, table_row_start);
    }
    else if (t == TABLE_SECTION_START) {
      r = consumeToken(b, table_section_start);
    }
    else if (t == TABLE_START) {
      r = consumeToken(b, table_start);
    }
    else if (t == TEMPLATE_BLOCK) {
      r = consumeToken(b, template_block);
    }
    else if (t == TEMPLATE_BLOCK_END) {
      r = consumeToken(b, template_block_end);
    }
    else if (t == TEMPLATE_BLOCK_START) {
      r = consumeToken(b, template_block_start);
    }
    else if (t == TEMPLATE_NAME) {
      r = consumeToken(b, template_name);
    }
    else if (t == TEMPLATE_PROPERTY_NAME) {
      r = consumeToken(b, template_property_name);
    }
    else if (t == TEMPLATE_PROPERTY_NAMED) {
      r = consumeToken(b, template_property_named);
    }
    else if (t == TEMPLATE_PROPERTY_UNASSIGNED) {
      r = consumeToken(b, template_property_unassigned);
    }
    else if (t == TEMPLATE_PROPERTY_VALUE) {
      r = consumeToken(b, template_property_value);
    }
    else if (t == TEXT_CONTENT) {
      r = consumeToken(b, text_content);
    }
    else if (t == TEXT_WITH_FORMATTING) {
      r = consumeToken(b, text_with_formatting);
    }
    else if (t == TITLE_CHARACTER) {
      r = consumeToken(b, title_character);
    }
    else if (t == TITLE_LEGAL_CHAR) {
      r = consumeToken(b, title_legal_char);
    }
    else if (t == UNICODE_CHARACTER) {
      r = consumeToken(b, unicode_character);
    }
    else if (t == UNICODE_WIKI) {
      r = consumeToken(b, unicode_wiki);
    }
    else if (t == URL) {
      r = url(b, 0);
    }
    else if (t == URL_CHAR) {
      r = consumeToken(b, url_char);
    }
    else if (t == URL_PATH) {
      r = consumeToken(b, url_path);
    }
    else if (t == URL_REFERENCE_BLOCK) {
      r = consumeToken(b, url_reference_block);
    }
    else if (t == VARIABLE_NAME) {
      r = consumeToken(b, variable_name);
    }
    else if (t == WHITESPACE) {
      r = whitespace(b, 0);
    }
    else if (t == WHITESPACE_CHAR) {
      r = consumeToken(b, whitespace_char);
    }
    else if (t == WIKI_MARKUP_CHARACTERS) {
      r = consumeToken(b, wiki_markup_characters);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return wiki_page(b, l + 1);
  }

  /* ********************************************************** */
  // "CSS"
  public static boolean CSS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CSS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CSS, "<css>");
    r = consumeToken(b, "CSS");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "EOF"
  public static boolean EOF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EOF")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EOF, "<eof>");
    r = consumeToken(b, "EOF");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (letter|decimal-number|"."|"/"|":"|"?"|"&"|"%"|"="|"-"|"_"|")"|"("|"'"|"~"|"+"|","|"#"|"@")+
  public static boolean LEGAL_URL_ENTITY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LEGAL_URL_ENTITY")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LEGAL_URL_ENTITY, "<legal url entity>");
    r = LEGAL_URL_ENTITY_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!LEGAL_URL_ENTITY_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LEGAL_URL_ENTITY", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter|decimal-number|"."|"/"|":"|"?"|"&"|"%"|"="|"-"|"_"|")"|"("|"'"|"~"|"+"|","|"#"|"@"
  private static boolean LEGAL_URL_ENTITY_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LEGAL_URL_ENTITY_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = decimal_number(b, l + 1);
    if (!r) r = consumeToken(b, ".");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, "?");
    if (!r) r = consumeToken(b, unescapedampersand);
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, equals);
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, underscore);
    if (!r) r = consumeToken(b, ")");
    if (!r) r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, "'");
    if (!r) r = consumeToken(b, "~");
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, "#");
    if (!r) r = consumeToken(b, "@");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // newline|
  // 	TAB|
  // 	space
  public static boolean Whitespaces(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Whitespaces")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHITESPACES, "<whitespaces>");
    r = consumeToken(b, newline);
    if (!r) r = consumeToken(b, tab);
    if (!r) r = consumeToken(b, space);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // letter|symbol|decimaldigit|whitespace-char|inline-element|special-block
  public static boolean all_inline_elements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "all_inline_elements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALL_INLINE_ELEMENTS, "<all - inline - elements>");
    r = letter(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = whitespace_char(b, l + 1);
    if (!r) r = inline_element(b, l + 1);
    if (!r) r = special_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // letter
  public static boolean any_supported_unicode_character(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_supported_unicode_character")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANY_SUPPORTED_UNICODE_CHARACTER, "<any - supported - unicode - character>");
    r = letter(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (special-block-and-more | paragraph-and-more)+
  public static boolean article(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARTICLE, "<article>");
    r = article_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!article_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "article", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // special-block-and-more | paragraph-and-more
  private static boolean article_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = special_block_and_more(b, l + 1);
    if (!r) r = paragraph_and_more(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (interwiki-prefix | ":")? namespace-prefix? content-non-pipe
  public static boolean article_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_link")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARTICLE_LINK, "<article - link>");
    r = article_link_0(b, l + 1);
    r = r && article_link_1(b, l + 1);
    r = r && content_non_pipe(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (interwiki-prefix | ":")?
  private static boolean article_link_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_link_0")) return false;
    article_link_0_0(b, l + 1);
    return true;
  }

  // interwiki-prefix | ":"
  private static boolean article_link_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_link_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = interwiki_prefix(b, l + 1);
    if (!r) r = consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // namespace-prefix?
  private static boolean article_link_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_link_1")) return false;
    namespace_prefix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // page sub-page*
  public static boolean article_title(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_title")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARTICLE_TITLE, "<article - title>");
    r = page(b, l + 1);
    r = r && article_title_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // sub-page*
  private static boolean article_title_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "article_title_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sub_page(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "article_title_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // "<"|
  // 	">"|
  // //	"_"|
  // //	"|"|
  // 	"#"
  public static boolean bad_title_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bad_title_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BAD_TITLE_CHARACTERS, "<bad - title - characters>");
    r = consumeToken(b, unescapedlessthan);
    if (!r) r = consumeToken(b, unescapedgreaterthan);
    if (!r) r = consumeToken(b, "#");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // behaviourswitch-toc|
  // 	behaviourswitch-forcetoc|
  // 	behaviourswitch-notoc|
  // 	behaviourswitch-noeditsection|
  // 	behaviourswitch-nogallery
  public static boolean behaviour_switch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviour_switch")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOUR_SWITCH, "<behaviour - switch>");
    r = behaviourswitch_toc(b, l + 1);
    if (!r) r = behaviourswitch_forcetoc(b, l + 1);
    if (!r) r = behaviourswitch_notoc(b, l + 1);
    if (!r) r = behaviourswitch_noeditsection(b, l + 1);
    if (!r) r = behaviourswitch_nogallery(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "__FORCETOC__"
  public static boolean behaviourswitch_forcetoc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviourswitch_forcetoc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOURSWITCH_FORCETOC, "<behaviourswitch - forcetoc>");
    r = consumeToken(b, "__FORCETOC__");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "__NOEDITSECTION__"
  public static boolean behaviourswitch_noeditsection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviourswitch_noeditsection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOURSWITCH_NOEDITSECTION, "<behaviourswitch - noeditsection>");
    r = consumeToken(b, "__NOEDITSECTION__");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "__NOGALLERY__"
  public static boolean behaviourswitch_nogallery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviourswitch_nogallery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOURSWITCH_NOGALLERY, "<behaviourswitch - nogallery>");
    r = consumeToken(b, "__NOGALLERY__");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "__NOTOC__"
  public static boolean behaviourswitch_notoc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviourswitch_notoc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOURSWITCH_NOTOC, "<behaviourswitch - notoc>");
    r = consumeToken(b, "__NOTOC__");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "__TOC__"
  public static boolean behaviourswitch_toc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behaviourswitch_toc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOURSWITCH_TOC, "<behaviourswitch - toc>");
    r = consumeToken(b, "__TOC__");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // quote5 inline-text  quote5
  public static boolean bold_italic_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bold_italic_text")) return false;
    if (!nextTokenIs(b, quote5)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, quote5);
    r = r && inline_text(b, l + 1);
    r = r && consumeToken(b, quote5);
    exit_section_(b, m, BOLD_ITALIC_TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // quote3 inline-text quote3
  public static boolean bold_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bold_text")) return false;
    if (!nextTokenIs(b, quote3)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, quote3);
    r = r && inline_text(b, l + 1);
    r = r && consumeToken(b, quote3);
    exit_section_(b, m, BOLD_TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // "*" (list-item | item-body)?
  public static boolean bullet_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bullet_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BULLET_ITEM, "<bullet - item>");
    r = consumeToken(b, "*");
    r = r && bullet_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (list-item | item-body)?
  private static boolean bullet_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bullet_item_1")) return false;
    bullet_item_1_0(b, l + 1);
    return true;
  }

  // list-item | item-body
  private static boolean bullet_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bullet_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_item(b, l + 1);
    if (!r) r = item_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // letter|
  // 	decimaldigit|
  // 	symbol
  public static boolean canonical_page_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_page_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CANONICAL_PAGE_CHAR, "<canonical - page - char>");
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = symbol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // inline-text
  public static boolean caption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caption")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAPTION, "<caption>");
    r = inline_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // internal-link-start category-namespace ":" article-title (pipe sort-key)* internal-link-end
  public static boolean category_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "category_link")) return false;
    if (!nextTokenIs(b, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = internal_link_start(b, l + 1);
    r = r && category_namespace(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && article_title(b, l + 1);
    r = r && category_link_4(b, l + 1);
    r = r && internal_link_end(b, l + 1);
    exit_section_(b, m, CATEGORY_LINK, r);
    return r;
  }

  // (pipe sort-key)*
  private static boolean category_link_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "category_link_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!category_link_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "category_link_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // pipe sort-key
  private static boolean category_link_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "category_link_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    r = r && sort_key(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "Category"
  public static boolean category_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "category_namespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CATEGORY_NAMESPACE, "<category - namespace>");
    r = consumeToken(b, "Category");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ((!tableheaderdoubledelimiter !tablecelldoubledelimiter !(newline whitespace? (tablesectionstart | tablesectionstartcaptionable))) (!(newline whitespace? "|}")) !(newline whitespace? "|") (!(newline whitespace? "!")) all-inline-elements)*
  public static boolean cell_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, CELL_CONTENT, "<cell - content>");
    int c = current_position_(b);
    while (true) {
      if (!cell_content_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cell_content", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // (!tableheaderdoubledelimiter !tablecelldoubledelimiter !(newline whitespace? (tablesectionstart | tablesectionstartcaptionable))) (!(newline whitespace? "|}")) !(newline whitespace? "|") (!(newline whitespace? "!")) all-inline-elements
  private static boolean cell_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cell_content_0_0(b, l + 1);
    r = r && cell_content_0_1(b, l + 1);
    r = r && cell_content_0_2(b, l + 1);
    r = r && cell_content_0_3(b, l + 1);
    r = r && all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !tableheaderdoubledelimiter !tablecelldoubledelimiter !(newline whitespace? (tablesectionstart | tablesectionstartcaptionable))
  private static boolean cell_content_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cell_content_0_0_0(b, l + 1);
    r = r && cell_content_0_0_1(b, l + 1);
    r = r && cell_content_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !tableheaderdoubledelimiter
  private static boolean cell_content_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, tableheaderdoubledelimiter);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !tablecelldoubledelimiter
  private static boolean cell_content_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, tablecelldoubledelimiter);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !(newline whitespace? (tablesectionstart | tablesectionstartcaptionable))
  private static boolean cell_content_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !cell_content_0_0_2_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline whitespace? (tablesectionstart | tablesectionstartcaptionable)
  private static boolean cell_content_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && cell_content_0_0_2_0_1(b, l + 1);
    r = r && cell_content_0_0_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean cell_content_0_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_2_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // tablesectionstart | tablesectionstartcaptionable
  private static boolean cell_content_0_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_0_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tablesectionstart);
    if (!r) r = consumeToken(b, tablesectionstartcaptionable);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(newline whitespace? "|}")
  private static boolean cell_content_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !cell_content_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline whitespace? "|}"
  private static boolean cell_content_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && cell_content_0_1_0_1(b, l + 1);
    r = r && consumeToken(b, tableend);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean cell_content_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_1_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // !(newline whitespace? "|")
  private static boolean cell_content_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !cell_content_0_2_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline whitespace? "|"
  private static boolean cell_content_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && cell_content_0_2_0_1(b, l + 1);
    r = r && consumeToken(b, pipe);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean cell_content_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_2_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // !(newline whitespace? "!")
  private static boolean cell_content_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !cell_content_0_3_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline whitespace? "!"
  private static boolean cell_content_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && cell_content_0_3_0_1(b, l + 1);
    r = r && consumeToken(b, "!");
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean cell_content_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_content_0_3_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // cell-content
  public static boolean cell_formatting(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_formatting")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CELL_FORMATTING, "<cell - formatting>");
    r = cell_content(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // whitespace-char|
  // 	non-whitespace-char|
  // 	html-entity|
  // 	symbol
  public static boolean character(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "character")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHARACTER, "<character>");
    r = whitespace_char(b, l + 1);
    if (!r) r = non_whitespace_char(b, l + 1);
    if (!r) r = html_entity(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // character+
  public static boolean characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHARACTERS, "<characters>");
    r = character(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!character(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "characters", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (!"|" (letter | decimaldigit | newline | whitespace | symbol | inline-element))*
  public static boolean content_non_pipe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_non_pipe")) return false;
    Marker m = enter_section_(b, l, _NONE_, CONTENT_NON_PIPE, "<content - non - pipe>");
    int c = current_position_(b);
    while (true) {
      if (!content_non_pipe_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "content_non_pipe", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !"|" (letter | decimaldigit | newline | whitespace | symbol | inline-element)
  private static boolean content_non_pipe_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_non_pipe_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = content_non_pipe_0_0(b, l + 1);
    r = r && content_non_pipe_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean content_non_pipe_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_non_pipe_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter | decimaldigit | newline | whitespace | symbol | inline-element
  private static boolean content_non_pipe_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_non_pipe_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = consumeToken(b, newline);
    if (!r) r = whitespace(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = inline_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "-"+
  public static boolean dashes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dashes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DASHES, "<dashes>");
    r = consumeToken(b, "-");
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, "-")) break;
      if (!empty_element_parsed_guard_(b, "dashes", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // decimaldigit+
  public static boolean decimal_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_number")) return false;
    if (!nextTokenIs(b, decimaldigit)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, decimaldigit);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, decimaldigit)) break;
      if (!empty_element_parsed_guard_(b, "decimal_number", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, DECIMAL_NUMBER, r);
    return r;
  }

  /* ********************************************************** */
  // ";" text-content definition?
  public static boolean defined_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defined_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINED_TERM, "<defined - term>");
    r = consumeToken(b, ";");
    r = r && text_content(b, l + 1);
    r = r && defined_term_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // definition?
  private static boolean defined_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defined_term_2")) return false;
    definition(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ":" inline-text
  public static boolean definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = consumeToken(b, ":");
    r = r && inline_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // decimaldigit+
  public static boolean digits(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digits")) return false;
    if (!nextTokenIs(b, decimaldigit)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, decimaldigit);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, decimaldigit)) break;
      if (!empty_element_parsed_guard_(b, "digits", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, DIGITS, r);
    return r;
  }

  /* ********************************************************** */
  // "#" (list-item | item-body)?
  public static boolean enumerated_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumerated_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUMERATED_ITEM, "<enumerated - item>");
    r = consumeToken(b, "#");
    r = r && enumerated_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (list-item | item-body)?
  private static boolean enumerated_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumerated_item_1")) return false;
    enumerated_item_1_0(b, l + 1);
    return true;
  }

  // list-item | item-body
  private static boolean enumerated_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumerated_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_item(b, l + 1);
    if (!r) r = item_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // openbracket url whitespace? (inline-element)* closebracket
  public static boolean external_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_link")) return false;
    if (!nextTokenIs(b, openbracket)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, openbracket);
    r = r && url(b, l + 1);
    r = r && external_link_2(b, l + 1);
    r = r && external_link_3(b, l + 1);
    r = r && consumeToken(b, closebracket);
    exit_section_(b, m, EXTERNAL_LINK, r);
    return r;
  }

  // whitespace?
  private static boolean external_link_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_link_2")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (inline-element)*
  private static boolean external_link_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_link_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!external_link_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "external_link_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (inline-element)
  private static boolean external_link_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_link_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inline_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // letter+
  public static boolean extra_description(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extra_description")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTRA_DESCRIPTION, "<extra - description>");
    r = letter(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!letter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extra_description", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bold-italic-text|
  // 	bold-text|
  // 	italic-text
  public static boolean formatted_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formatted_text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FORMATTED_TEXT, "<formatted - text>");
    r = bold_italic_text(b, l + 1);
    if (!r) r = bold_text(b, l + 1);
    if (!r) r = italic_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "!"|"$"|"%"|"&"|"("")"|"*"|","|"-"|"."|":"|";"|"<"|"@"|"["|"]"|"^"|"_"|"`"|"{"|"|"|"}"|"~"|letter|decimaldigit|"–"|"'"
  public static boolean friendly_ref_link_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "friendly_ref_link_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FRIENDLY_REF_LINK_CHAR, "<friendly - ref - link - char>");
    r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "$");
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, unescapedampersand);
    if (!r) r = friendly_ref_link_char_4(b, l + 1);
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, ".");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, unescapedlessthan);
    if (!r) r = consumeToken(b, "@");
    if (!r) r = consumeToken(b, openbracket);
    if (!r) r = consumeToken(b, closebracket);
    if (!r) r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, underscore);
    if (!r) r = consumeToken(b, "`");
    if (!r) r = consumeToken(b, "{");
    if (!r) r = consumeToken(b, pipe);
    if (!r) r = consumeToken(b, "}");
    if (!r) r = consumeToken(b, "~");
    if (!r) r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = consumeToken(b, "–");
    if (!r) r = consumeToken(b, "'");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "("")"
  private static boolean friendly_ref_link_char_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "friendly_ref_link_char_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "<gallery>" newline? gallery-image (newline? gallery-image)* newline? "</gallery>"
  public static boolean gallery_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GALLERY_BLOCK, "<gallery - block>");
    r = consumeToken(b, "<gallery>");
    r = r && gallery_block_1(b, l + 1);
    r = r && gallery_image(b, l + 1);
    r = r && gallery_block_3(b, l + 1);
    r = r && gallery_block_4(b, l + 1);
    r = r && consumeToken(b, "</gallery>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline?
  private static boolean gallery_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block_1")) return false;
    consumeToken(b, newline);
    return true;
  }

  // (newline? gallery-image)*
  private static boolean gallery_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!gallery_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gallery_block_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // newline? gallery-image
  private static boolean gallery_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gallery_block_3_0_0(b, l + 1);
    r = r && gallery_image(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean gallery_block_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block_3_0_0")) return false;
    consumeToken(b, newline);
    return true;
  }

  // newline?
  private static boolean gallery_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_block_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // image-name ("|" caption)?
  public static boolean gallery_image(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_image")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GALLERY_IMAGE, "<gallery - image>");
    r = image_name(b, l + 1);
    r = r && gallery_image_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("|" caption)?
  private static boolean gallery_image_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_image_1")) return false;
    gallery_image_1_0(b, l + 1);
    return true;
  }

  // "|" caption
  private static boolean gallery_image_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gallery_image_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    r = r && caption(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // decimaldigit|
  // 	"A"|
  // 	"B"|
  // 	"C"|
  // 	"D"|
  // 	"E"|
  // 	"F"|
  // 	"a"|
  // 	"b"|
  // 	"c"|
  // 	"d"|
  // 	"e"|
  // 	"f"
  public static boolean hex_digit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex_digit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEX_DIGIT, "<hex - digit>");
    r = consumeToken(b, decimaldigit);
    if (!r) r = consumeToken(b, "A");
    if (!r) r = consumeToken(b, "B");
    if (!r) r = consumeToken(b, "C");
    if (!r) r = consumeToken(b, "D");
    if (!r) r = consumeToken(b, "E");
    if (!r) r = consumeToken(b, "F");
    if (!r) r = consumeToken(b, "a");
    if (!r) r = consumeToken(b, "b");
    if (!r) r = consumeToken(b, "c");
    if (!r) r = consumeToken(b, "d");
    if (!r) r = consumeToken(b, "e");
    if (!r) r = consumeToken(b, "f");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // hex-digit+
  public static boolean hex_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex_number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEX_NUMBER, "<hex - number>");
    r = hex_digit(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!hex_digit(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hex_number", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "----" dashes? inline-text? newline
  public static boolean horizontal_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "horizontal_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HORIZONTAL_RULE, "<horizontal - rule>");
    r = consumeToken(b, "----");
    r = r && horizontal_rule_1(b, l + 1);
    r = r && horizontal_rule_2(b, l + 1);
    r = r && consumeToken(b, newline);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // dashes?
  private static boolean horizontal_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "horizontal_rule_1")) return false;
    dashes(b, l + 1);
    return true;
  }

  // inline-text?
  private static boolean horizontal_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "horizontal_rule_2")) return false;
    inline_text(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // html-opening-tag whitespace? html-body whitespace? html-closing-tag?
  public static boolean html_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_BLOCK, "<html - block>");
    r = html_opening_tag(b, l + 1);
    r = r && html_block_1(b, l + 1);
    r = r && html_body(b, l + 1);
    r = r && html_block_3(b, l + 1);
    r = r && html_block_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean html_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_block_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean html_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_block_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // html-closing-tag?
  private static boolean html_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_block_4")) return false;
    html_closing_tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // characters
  public static boolean html_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_BODY, "<html - body>");
    r = characters(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "</html" whitespace? ">"
  public static boolean html_closing_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_closing_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_CLOSING_TAG, "<html - closing - tag>");
    r = consumeToken(b, "</html");
    r = r && html_closing_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean html_closing_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_closing_tag_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // htmlcommentopen whitespace? paragraph whitespace? htmlcommentclose
  public static boolean html_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_comment")) return false;
    if (!nextTokenIs(b, htmlcommentopen)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, htmlcommentopen);
    r = r && html_comment_1(b, l + 1);
    r = r && paragraph(b, l + 1);
    r = r && html_comment_3(b, l + 1);
    r = r && consumeToken(b, htmlcommentclose);
    exit_section_(b, m, HTML_COMMENT, r);
    return r;
  }

  // whitespace?
  private static boolean html_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_comment_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean html_comment_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_comment_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "&#" decimal-number ";"|
  // 	"&#x" hex-number ";"
  public static boolean html_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_entity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_ENTITY, "<html - entity>");
    r = html_entity_0(b, l + 1);
    if (!r) r = html_entity_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "&#" decimal-number ";"
  private static boolean html_entity_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_entity_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "&#");
    r = r && decimal_number(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // "&#x" hex-number ";"
  private static boolean html_entity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_entity_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "&#x");
    r = r && hex_number(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "<html" (whitespace characters?)? ">"
  public static boolean html_opening_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_opening_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_OPENING_TAG, "<html - opening - tag>");
    r = consumeToken(b, "<html");
    r = r && html_opening_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace characters?)?
  private static boolean html_opening_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_opening_tag_1")) return false;
    html_opening_tag_1_0(b, l + 1);
    return true;
  }

  // whitespace characters?
  private static boolean html_opening_tag_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_opening_tag_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = whitespace(b, l + 1);
    r = r && html_opening_tag_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // characters?
  private static boolean html_opening_tag_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_opening_tag_1_0_1")) return false;
    characters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "<!" html-tag-name html-tag-properties? ((">" html-tag-content html-tag-close)|"/>")
  public static boolean html_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG, "<html - tag>");
    r = consumeToken(b, "<!");
    r = r && html_tag_name(b, l + 1);
    r = r && html_tag_2(b, l + 1);
    r = r && html_tag_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // html-tag-properties?
  private static boolean html_tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_2")) return false;
    html_tag_properties(b, l + 1);
    return true;
  }

  // (">" html-tag-content html-tag-close)|"/>"
  private static boolean html_tag_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_tag_3_0(b, l + 1);
    if (!r) r = consumeToken(b, "/>");
    exit_section_(b, m, null, r);
    return r;
  }

  // ">" html-tag-content html-tag-close
  private static boolean html_tag_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, unescapedgreaterthan);
    r = r && html_tag_content(b, l + 1);
    r = r && html_tag_close(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "</" html-tag-name ">"
  public static boolean html_tag_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_close")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG_CLOSE, "<html - tag - close>");
    r = consumeToken(b, "</");
    r = r && html_tag_name(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // paragraph
  public static boolean html_tag_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG_CONTENT, "<html - tag - content>");
    r = paragraph(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (letter | decimaldigit)+
  public static boolean html_tag_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG_NAME, "<html - tag - name>");
    r = html_tag_name_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!html_tag_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_tag_name", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter | decimaldigit
  private static boolean html_tag_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (!">" (letter | decimaldigit | symbol | whitespace))*
  public static boolean html_tag_properties(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_properties")) return false;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG_PROPERTIES, "<html - tag - properties>");
    int c = current_position_(b);
    while (true) {
      if (!html_tag_properties_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_tag_properties", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !">" (letter | decimaldigit | symbol | whitespace)
  private static boolean html_tag_properties_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_properties_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_tag_properties_0_0(b, l + 1);
    r = r && html_tag_properties_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !">"
  private static boolean html_tag_properties_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_properties_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter | decimaldigit | symbol | whitespace
  private static boolean html_tag_properties_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag_properties_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = whitespace(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unescapedampersand|
  // 	unescapedlessthan|
  // 	unescapedgreaterthan
  public static boolean html_unsafe_symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_unsafe_symbol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_UNSAFE_SYMBOL, "<html - unsafe - symbol>");
    r = consumeToken(b, unescapedampersand);
    if (!r) r = consumeToken(b, unescapedlessthan);
    if (!r) r = consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "center"|
  // 	"centre"
  public static boolean image_align_center(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_align_center")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_ALIGN_CENTER, "<image - align - center>");
    r = consumeToken(b, "center");
    if (!r) r = consumeToken(b, "centre");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "left"
  public static boolean image_align_left(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_align_left")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_ALIGN_LEFT, "<image - align - left>");
    r = consumeToken(b, "left");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "none"
  public static boolean image_align_none(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_align_none")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_ALIGN_NONE, "<image - align - none>");
    r = consumeToken(b, "none");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // image-align-left|
  // 	image-align-center|
  // 	image-align-right|
  // 	image-align-none
  public static boolean image_align_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_align_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_ALIGN_PARAMETER, "<image - align - parameter>");
    r = image_align_left(b, l + 1);
    if (!r) r = image_align_center(b, l + 1);
    if (!r) r = image_align_right(b, l + 1);
    if (!r) r = image_align_none(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "right"
  public static boolean image_align_right(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_align_right")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_ALIGN_RIGHT, "<image - align - right>");
    r = consumeToken(b, "right");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "jpg"|
  // 	"jpeg"|
  // 	"png"|
  // 	"svg"|
  // 	"gif"|
  // 	"bmp"
  public static boolean image_extension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_extension")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_EXTENSION, "<image - extension>");
    r = consumeToken(b, "jpg");
    if (!r) r = consumeToken(b, "jpeg");
    if (!r) r = consumeToken(b, "png");
    if (!r) r = consumeToken(b, "svg");
    if (!r) r = consumeToken(b, "gif");
    if (!r) r = consumeToken(b, "bmp");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "[[" "Image:" page-name "." image-extension (pipe image-option)* "]]"
  public static boolean image_inline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_inline")) return false;
    if (!nextTokenIs(b, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, openbracket2);
    r = r && consumeToken(b, "Image:");
    r = r && page_name(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && image_extension(b, l + 1);
    r = r && image_inline_5(b, l + 1);
    r = r && consumeToken(b, closebracket2);
    exit_section_(b, m, IMAGE_INLINE, r);
    return r;
  }

  // (pipe image-option)*
  private static boolean image_inline_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_inline_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!image_inline_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "image_inline_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // pipe image-option
  private static boolean image_inline_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_inline_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    r = r && image_option(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "thumbnail"|
  // 	"thumb"
  public static boolean image_mode_auto_thumb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_mode_auto_thumb")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_MODE_AUTO_THUMB, "<image - mode - auto - thumb>");
    r = consumeToken(b, "thumbnail");
    if (!r) r = consumeToken(b, "thumb");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "framed"|
  // 	"enframed"|
  // 	"frame"
  public static boolean image_mode_frame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_mode_frame")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_MODE_FRAME, "<image - mode - frame>");
    r = consumeToken(b, "framed");
    if (!r) r = consumeToken(b, "enframed");
    if (!r) r = consumeToken(b, "frame");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "frameless"
  public static boolean image_mode_frameless(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_mode_frameless")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_MODE_FRAMELESS, "<image - mode - frameless>");
    r = consumeToken(b, "frameless");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "thumbnail=" image-name
  // 	"thumb=" image-name
  public static boolean image_mode_manual_thumb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_mode_manual_thumb")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_MODE_MANUAL_THUMB, "<image - mode - manual - thumb>");
    r = consumeToken(b, "thumbnail=");
    r = r && image_name(b, l + 1);
    r = r && consumeToken(b, "thumb=");
    r = r && image_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // image-mode-manual-thumb|
  // 	image-mode-auto-thumb|
  // 	image-mode-frame|
  // 	image-mode-frameless
  public static boolean image_mode_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_mode_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_MODE_PARAMETER, "<image - mode - parameter>");
    r = image_mode_manual_thumb(b, l + 1);
    if (!r) r = image_mode_auto_thumb(b, l + 1);
    if (!r) r = image_mode_frame(b, l + 1);
    if (!r) r = image_mode_frameless(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // page-name "." image-extension
  public static boolean image_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_NAME, "<image - name>");
    r = page_name(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && image_extension(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // image-mode-parameter|
  // 	image-size-parameter|
  // 	image-align-parameter|
  // 	image-valign-parameter|
  // 	caption|
  // 	image-other-parameter
  public static boolean image_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_OPTION, "<image - option>");
    r = image_mode_parameter(b, l + 1);
    if (!r) r = image_size_parameter(b, l + 1);
    if (!r) r = image_align_parameter(b, l + 1);
    if (!r) r = image_valign_parameter(b, l + 1);
    if (!r) r = caption(b, l + 1);
    if (!r) r = image_other_parameter(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // image-param-page|
  // 	image-param-upright|
  // 	image-param-border
  public static boolean image_other_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_other_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_OTHER_PARAMETER, "<image - other - parameter>");
    r = image_param_page(b, l + 1);
    if (!r) r = image_param_upright(b, l + 1);
    if (!r) r = image_param_border(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "border"
  public static boolean image_param_border(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_border")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_PARAM_BORDER, "<image - param - border>");
    r = consumeToken(b, "border");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "page=$1"|
  // 	"page $1"
  public static boolean image_param_page(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_page")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_PARAM_PAGE, "<image - param - page>");
    r = consumeToken(b, "page=$1");
    if (!r) r = consumeToken(b, "page $1");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "upright" ("="? digits)?
  public static boolean image_param_upright(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_upright")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_PARAM_UPRIGHT, "<image - param - upright>");
    r = consumeToken(b, "upright");
    r = r && image_param_upright_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("="? digits)?
  private static boolean image_param_upright_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_upright_1")) return false;
    image_param_upright_1_0(b, l + 1);
    return true;
  }

  // "="? digits
  private static boolean image_param_upright_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_upright_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = image_param_upright_1_0_0(b, l + 1);
    r = r && digits(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "="?
  private static boolean image_param_upright_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_param_upright_1_0_0")) return false;
    consumeToken(b, equals);
    return true;
  }

  /* ********************************************************** */
  // digits "px"
  public static boolean image_size_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_size_parameter")) return false;
    if (!nextTokenIs(b, decimaldigit)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = digits(b, l + 1);
    r = r && consumeToken(b, "px");
    exit_section_(b, m, IMAGE_SIZE_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // "baseline"
  public static boolean image_valign_baseline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_baseline")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_BASELINE, "<image - valign - baseline>");
    r = consumeToken(b, "baseline");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "bottom"
  public static boolean image_valign_bottom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_bottom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_BOTTOM, "<image - valign - bottom>");
    r = consumeToken(b, "bottom");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "middle"
  public static boolean image_valign_middle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_middle")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_MIDDLE, "<image - valign - middle>");
    r = consumeToken(b, "middle");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // image-valign-baseline|
  // 	image-valign-sub|
  // 	image-valign-super|
  // 	image-valign-top|
  // 	image-valign-text-top|
  // 	image-valign-middle|
  // 	image-valign-bottom|
  // 	image-valign-text-bottom
  public static boolean image_valign_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_PARAMETER, "<image - valign - parameter>");
    r = image_valign_baseline(b, l + 1);
    if (!r) r = image_valign_sub(b, l + 1);
    if (!r) r = image_valign_super(b, l + 1);
    if (!r) r = image_valign_top(b, l + 1);
    if (!r) r = image_valign_text_top(b, l + 1);
    if (!r) r = image_valign_middle(b, l + 1);
    if (!r) r = image_valign_bottom(b, l + 1);
    if (!r) r = image_valign_text_bottom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "sub"
  public static boolean image_valign_sub(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_sub")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_SUB, "<image - valign - sub>");
    r = consumeToken(b, "sub");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "super"|
  // 	"sup"
  public static boolean image_valign_super(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_super")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_SUPER, "<image - valign - super>");
    r = consumeToken(b, "super");
    if (!r) r = consumeToken(b, "sup");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "text-bottom"
  public static boolean image_valign_text_bottom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_text_bottom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_TEXT_BOTTOM, "<image - valign - text - bottom>");
    r = consumeToken(b, "text-bottom");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "text-top"
  public static boolean image_valign_text_top(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_text_top")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_TEXT_TOP, "<image - valign - text - top>");
    r = consumeToken(b, "text-top");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "top"
  public static boolean image_valign_top(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "image_valign_top")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMAGE_VALIGN_TOP, "<image - valign - top>");
    r = consumeToken(b, "top");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ":" (list-item | item-body)?
  public static boolean indent_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDENT_ITEM, "<indent - item>");
    r = consumeToken(b, ":");
    r = r && indent_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (list-item | item-body)?
  private static boolean indent_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_item_1")) return false;
    indent_item_1_0(b, l + 1);
    return true;
  }

  // list-item | item-body
  private static boolean indent_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_item(b, l + 1);
    if (!r) r = item_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // html-tag |
  // 	url|
  // 	category-link |
  // 	link |
  // 	magic-link |
  // 	image-inline |
  // 	gallery-block |
  // 	media-inline |
  // 	text-with-formatting |
  // 	template-block
  public static boolean inline_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_ELEMENT, "<inline - element>");
    r = html_tag(b, l + 1);
    if (!r) r = url(b, l + 1);
    if (!r) r = category_link(b, l + 1);
    if (!r) r = link(b, l + 1);
    if (!r) r = magic_link(b, l + 1);
    if (!r) r = image_inline(b, l + 1);
    if (!r) r = gallery_block(b, l + 1);
    if (!r) r = media_inline(b, l + 1);
    if (!r) r = text_with_formatting(b, l + 1);
    if (!r) r = template_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( !"|"  (all-inline-elements))*
  public static boolean inline_element_sans_pipe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_element_sans_pipe")) return false;
    Marker m = enter_section_(b, l, _NONE_, INLINE_ELEMENT_SANS_PIPE, "<inline - element - sans - pipe>");
    int c = current_position_(b);
    while (true) {
      if (!inline_element_sans_pipe_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_element_sans_pipe", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !"|"  (all-inline-elements)
  private static boolean inline_element_sans_pipe_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_element_sans_pipe_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inline_element_sans_pipe_0_0(b, l + 1);
    r = r && inline_element_sans_pipe_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean inline_element_sans_pipe_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_element_sans_pipe_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (all-inline-elements)
  private static boolean inline_element_sans_pipe_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_element_sans_pipe_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // inline-element*
  public static boolean inline_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_text")) return false;
    Marker m = enter_section_(b, l, _NONE_, INLINE_TEXT, "<inline - text>");
    int c = current_position_(b);
    while (true) {
      if (!inline_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_text", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // internal-link-start article-link ("#" section-id)? ("|" (internal-link-property | internal-link-unassigned-property))* internal-link-end extra-description?
  public static boolean internal_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link")) return false;
    if (!nextTokenIs(b, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = internal_link_start(b, l + 1);
    r = r && article_link(b, l + 1);
    r = r && internal_link_2(b, l + 1);
    r = r && internal_link_3(b, l + 1);
    r = r && internal_link_end(b, l + 1);
    r = r && internal_link_5(b, l + 1);
    exit_section_(b, m, INTERNAL_LINK, r);
    return r;
  }

  // ("#" section-id)?
  private static boolean internal_link_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_2")) return false;
    internal_link_2_0(b, l + 1);
    return true;
  }

  // "#" section-id
  private static boolean internal_link_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && section_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("|" (internal-link-property | internal-link-unassigned-property))*
  private static boolean internal_link_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!internal_link_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "internal_link_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // "|" (internal-link-property | internal-link-unassigned-property)
  private static boolean internal_link_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    r = r && internal_link_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // internal-link-property | internal-link-unassigned-property
  private static boolean internal_link_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = internal_link_property(b, l + 1);
    if (!r) r = internal_link_unassigned_property(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // extra-description?
  private static boolean internal_link_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_5")) return false;
    extra_description(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // closebracket2
  public static boolean internal_link_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_end")) return false;
    if (!nextTokenIs(b, closebracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, closebracket2);
    exit_section_(b, m, INTERNAL_LINK_END, r);
    return r;
  }

  /* ********************************************************** */
  // variable-name "=" (content-non-pipe)
  public static boolean internal_link_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_property")) return false;
    if (!nextTokenIs(b, "<internal - link - property>", lcaseletter, ucaseletter)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERNAL_LINK_PROPERTY, "<internal - link - property>");
    r = variable_name(b, l + 1);
    r = r && consumeToken(b, equals);
    r = r && internal_link_property_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (content-non-pipe)
  private static boolean internal_link_property_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_property_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = content_non_pipe(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // openbracket2
  public static boolean internal_link_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_start")) return false;
    if (!nextTokenIs(b, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, openbracket2);
    exit_section_(b, m, INTERNAL_LINK_START, r);
    return r;
  }

  /* ********************************************************** */
  // whitespace? (content-non-pipe)
  public static boolean internal_link_unassigned_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_unassigned_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERNAL_LINK_UNASSIGNED_PROPERTY, "<internal - link - unassigned - property>");
    r = internal_link_unassigned_property_0(b, l + 1);
    r = r && internal_link_unassigned_property_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean internal_link_unassigned_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_unassigned_property_0")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (content-non-pipe)
  private static boolean internal_link_unassigned_property_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "internal_link_unassigned_property_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = content_non_pipe(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "Wikipedia"|"File"
  public static boolean interwiki(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interwiki")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERWIKI, "<interwiki>");
    r = consumeToken(b, "Wikipedia");
    if (!r) r = consumeToken(b, "File");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // interwiki ":"
  public static boolean interwiki_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interwiki_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERWIKI_PREFIX, "<interwiki - prefix>");
    r = interwiki(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "ISBN" spaces digits
  public static boolean isbn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isbn")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISBN, "<isbn>");
    r = consumeToken(b, "ISBN");
    r = r && spaces(b, l + 1);
    r = r && digits(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // quote2 inline-text quote2
  public static boolean italic_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "italic_text")) return false;
    if (!nextTokenIs(b, quote2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, quote2);
    r = r && inline_text(b, l + 1);
    r = r && consumeToken(b, quote2);
    exit_section_(b, m, ITALIC_TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // defined-term|
  // 	whitespace? inline-text
  public static boolean item_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM_BODY, "<item - body>");
    r = defined_term(b, l + 1);
    if (!r) r = item_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace? inline-text
  private static boolean item_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_body_1_0(b, l + 1);
    r = r && inline_text(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean item_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_body_1_0")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ucaseletter|
  // 	lcaseletter|
  // 	otherletter
  public static boolean letter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "letter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LETTER, "<letter>");
    r = consumeToken(b, ucaseletter);
    if (!r) r = consumeToken(b, lcaseletter);
    if (!r) r = consumeToken(b, otherletter);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equals2 section-name equals2 whitespace? newline?
  public static boolean level_2_heading(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_heading")) return false;
    if (!nextTokenIs(b, equals2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, equals2);
    r = r && section_name(b, l + 1);
    r = r && consumeToken(b, equals2);
    r = r && level_2_heading_3(b, l + 1);
    r = r && level_2_heading_4(b, l + 1);
    exit_section_(b, m, LEVEL_2_HEADING, r);
    return r;
  }

  // whitespace?
  private static boolean level_2_heading_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_heading_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline?
  private static boolean level_2_heading_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_heading_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // level-2-heading (!level-2-heading all-inline-elements)* (!level-2-section section)*
  public static boolean level_2_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section")) return false;
    if (!nextTokenIs(b, equals2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_2_heading(b, l + 1);
    r = r && level_2_section_1(b, l + 1);
    r = r && level_2_section_2(b, l + 1);
    exit_section_(b, m, LEVEL_2_SECTION, r);
    return r;
  }

  // (!level-2-heading all-inline-elements)*
  private static boolean level_2_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_2_section_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_2_section_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-2-heading all-inline-elements
  private static boolean level_2_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_2_section_1_0_0(b, l + 1);
    r = r && all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-2-heading
  private static boolean level_2_section_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!level-2-section section)*
  private static boolean level_2_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_2_section_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_2_section_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-2-section section
  private static boolean level_2_section_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_2_section_2_0_0(b, l + 1);
    r = r && section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-2-section
  private static boolean level_2_section_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_2_section_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_section(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equals3 section-name equals3 whitespace? newline?
  public static boolean level_3_heading(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_heading")) return false;
    if (!nextTokenIs(b, equals3)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, equals3);
    r = r && section_name(b, l + 1);
    r = r && consumeToken(b, equals3);
    r = r && level_3_heading_3(b, l + 1);
    r = r && level_3_heading_4(b, l + 1);
    exit_section_(b, m, LEVEL_3_HEADING, r);
    return r;
  }

  // whitespace?
  private static boolean level_3_heading_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_heading_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline?
  private static boolean level_3_heading_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_heading_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // level-3-heading (!level-3-heading !level-2-heading all-inline-elements)* (!level-3-heading !level-2-heading section)*
  public static boolean level_3_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section")) return false;
    if (!nextTokenIs(b, equals3)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_3_heading(b, l + 1);
    r = r && level_3_section_1(b, l + 1);
    r = r && level_3_section_2(b, l + 1);
    exit_section_(b, m, LEVEL_3_SECTION, r);
    return r;
  }

  // (!level-3-heading !level-2-heading all-inline-elements)*
  private static boolean level_3_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_3_section_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_3_section_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-3-heading !level-2-heading all-inline-elements
  private static boolean level_3_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_3_section_1_0_0(b, l + 1);
    r = r && level_3_section_1_0_1(b, l + 1);
    r = r && all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-3-heading
  private static boolean level_3_section_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_3_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-2-heading
  private static boolean level_3_section_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!level-3-heading !level-2-heading section)*
  private static boolean level_3_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_3_section_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_3_section_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-3-heading !level-2-heading section
  private static boolean level_3_section_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_3_section_2_0_0(b, l + 1);
    r = r && level_3_section_2_0_1(b, l + 1);
    r = r && section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-3-heading
  private static boolean level_3_section_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_3_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-2-heading
  private static boolean level_3_section_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_3_section_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equals4 section-name equals4 whitespace? newline?
  public static boolean level_4_heading(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_heading")) return false;
    if (!nextTokenIs(b, equals4)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, equals4);
    r = r && section_name(b, l + 1);
    r = r && consumeToken(b, equals4);
    r = r && level_4_heading_3(b, l + 1);
    r = r && level_4_heading_4(b, l + 1);
    exit_section_(b, m, LEVEL_4_HEADING, r);
    return r;
  }

  // whitespace?
  private static boolean level_4_heading_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_heading_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline?
  private static boolean level_4_heading_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_heading_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // level-4-heading (!level-4-heading !level-3-heading !level-2-heading all-inline-elements)* (!level-4-heading !level-3-heading !level-2-heading section)*
  public static boolean level_4_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section")) return false;
    if (!nextTokenIs(b, equals4)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_4_heading(b, l + 1);
    r = r && level_4_section_1(b, l + 1);
    r = r && level_4_section_2(b, l + 1);
    exit_section_(b, m, LEVEL_4_SECTION, r);
    return r;
  }

  // (!level-4-heading !level-3-heading !level-2-heading all-inline-elements)*
  private static boolean level_4_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_4_section_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_4_section_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-4-heading !level-3-heading !level-2-heading all-inline-elements
  private static boolean level_4_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_4_section_1_0_0(b, l + 1);
    r = r && level_4_section_1_0_1(b, l + 1);
    r = r && level_4_section_1_0_2(b, l + 1);
    r = r && all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-4-heading
  private static boolean level_4_section_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_4_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-3-heading
  private static boolean level_4_section_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_3_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-2-heading
  private static boolean level_4_section_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!level-4-heading !level-3-heading !level-2-heading section)*
  private static boolean level_4_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_4_section_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_4_section_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-4-heading !level-3-heading !level-2-heading section
  private static boolean level_4_section_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_4_section_2_0_0(b, l + 1);
    r = r && level_4_section_2_0_1(b, l + 1);
    r = r && level_4_section_2_0_2(b, l + 1);
    r = r && section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-4-heading
  private static boolean level_4_section_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_4_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-3-heading
  private static boolean level_4_section_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_3_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-2-heading
  private static boolean level_4_section_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_4_section_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equals5 section-name equals5 whitespace? newline?
  public static boolean level_5_heading(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_heading")) return false;
    if (!nextTokenIs(b, equals5)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, equals5);
    r = r && section_name(b, l + 1);
    r = r && consumeToken(b, equals5);
    r = r && level_5_heading_3(b, l + 1);
    r = r && level_5_heading_4(b, l + 1);
    exit_section_(b, m, LEVEL_5_HEADING, r);
    return r;
  }

  // whitespace?
  private static boolean level_5_heading_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_heading_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline?
  private static boolean level_5_heading_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_heading_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // level-5-heading (!level-5-heading !level-4-heading !level-3-heading !level-2-heading all-inline-elements)*
  public static boolean level_5_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section")) return false;
    if (!nextTokenIs(b, equals5)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_5_heading(b, l + 1);
    r = r && level_5_section_1(b, l + 1);
    exit_section_(b, m, LEVEL_5_SECTION, r);
    return r;
  }

  // (!level-5-heading !level-4-heading !level-3-heading !level-2-heading all-inline-elements)*
  private static boolean level_5_section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!level_5_section_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "level_5_section_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !level-5-heading !level-4-heading !level-3-heading !level-2-heading all-inline-elements
  private static boolean level_5_section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = level_5_section_1_0_0(b, l + 1);
    r = r && level_5_section_1_0_1(b, l + 1);
    r = r && level_5_section_1_0_2(b, l + 1);
    r = r && level_5_section_1_0_3(b, l + 1);
    r = r && all_inline_elements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !level-5-heading
  private static boolean level_5_section_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_5_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-4-heading
  private static boolean level_5_section_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_4_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-3-heading
  private static boolean level_5_section_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_3_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !level-2-heading
  private static boolean level_5_section_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "level_5_section_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !level_2_heading(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (plain-text+) (spaces plain-text+)*
  public static boolean line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINE, "<line>");
    r = line_0(b, l + 1);
    r = r && line_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // plain-text+
  private static boolean line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plain_text(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!plain_text(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (spaces plain-text+)*
  private static boolean line_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!line_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // spaces plain-text+
  private static boolean line_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spaces(b, l + 1);
    r = r && line_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // plain-text+
  private static boolean line_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plain_text(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!plain_text(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_1_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // inline-text newline?
  public static boolean lines_of_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_of_text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINES_OF_TEXT, "<lines - of - text>");
    r = inline_text(b, l + 1);
    r = r && lines_of_text_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline?
  private static boolean lines_of_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_of_text_1")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // internal-link|
  // 	external-link
  public static boolean link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link")) return false;
    if (!nextTokenIs(b, "<link>", openbracket, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINK, "<link>");
    r = internal_link(b, l + 1);
    if (!r) r = external_link(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // inline-text
  public static boolean link_description(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_description")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINK_DESCRIPTION, "<link - description>");
    r = inline_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // indent-item|
  // 	enumerated-item|
  // 	bullet-item
  public static boolean list_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ITEM, "<list - item>");
    r = indent_item(b, l + 1);
    if (!r) r = enumerated_item(b, l + 1);
    if (!r) r = bullet_item(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // isbn|
  // 	rfc-number|
  // 	pmid-number
  public static boolean magic_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "magic_link")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAGIC_LINK, "<magic - link>");
    r = isbn(b, l + 1);
    if (!r) r = rfc_number(b, l + 1);
    if (!r) r = pmid_number(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "ogg"|
  // 	"wav"
  public static boolean media_extension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "media_extension")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEDIA_EXTENSION, "<media - extension>");
    r = consumeToken(b, "ogg");
    if (!r) r = consumeToken(b, "wav");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "[[" "Media:" page-name "." media-extension "]]"
  public static boolean media_inline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "media_inline")) return false;
    if (!nextTokenIs(b, openbracket2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, openbracket2);
    r = r && consumeToken(b, "Media:");
    r = r && page_name(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && media_extension(b, l + 1);
    r = r && consumeToken(b, closebracket2);
    exit_section_(b, m, MEDIA_INLINE, r);
    return r;
  }

  /* ********************************************************** */
  // named-reference-block-url|
  //     named-reference-block-self-closing
  public static boolean named_reference_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block")) return false;
    if (!nextTokenIs(b, refopen)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_reference_block_url(b, l + 1);
    if (!r) r = named_reference_block_self_closing(b, l + 1);
    exit_section_(b, m, NAMED_REFERENCE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // reference-opening-tag whitespace?  (("name" | "group") whitespace? "=" property-assignment)+ "/" unescapedgreaterthan
  public static boolean named_reference_block_self_closing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing")) return false;
    if (!nextTokenIs(b, refopen)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_opening_tag(b, l + 1);
    r = r && named_reference_block_self_closing_1(b, l + 1);
    r = r && named_reference_block_self_closing_2(b, l + 1);
    r = r && consumeToken(b, "/");
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, m, NAMED_REFERENCE_BLOCK_SELF_CLOSING, r);
    return r;
  }

  // whitespace?
  private static boolean named_reference_block_self_closing_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (("name" | "group") whitespace? "=" property-assignment)+
  private static boolean named_reference_block_self_closing_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_reference_block_self_closing_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!named_reference_block_self_closing_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_reference_block_self_closing_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ("name" | "group") whitespace? "=" property-assignment
  private static boolean named_reference_block_self_closing_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_reference_block_self_closing_2_0_0(b, l + 1);
    r = r && named_reference_block_self_closing_2_0_1(b, l + 1);
    r = r && consumeToken(b, equals);
    r = r && property_assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "name" | "group"
  private static boolean named_reference_block_self_closing_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "name");
    if (!r) r = consumeToken(b, "group");
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean named_reference_block_self_closing_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_self_closing_2_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // reference-opening-tag whitespace? (("name" | "group") whitespace? "=" property-assignment)+ unescapedgreaterthan whitespace? reference-content whitespace? reference-closing-tag
  public static boolean named_reference_block_url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url")) return false;
    if (!nextTokenIs(b, refopen)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_opening_tag(b, l + 1);
    r = r && named_reference_block_url_1(b, l + 1);
    r = r && named_reference_block_url_2(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    r = r && named_reference_block_url_4(b, l + 1);
    r = r && reference_content(b, l + 1);
    r = r && named_reference_block_url_6(b, l + 1);
    r = r && reference_closing_tag(b, l + 1);
    exit_section_(b, m, NAMED_REFERENCE_BLOCK_URL, r);
    return r;
  }

  // whitespace?
  private static boolean named_reference_block_url_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (("name" | "group") whitespace? "=" property-assignment)+
  private static boolean named_reference_block_url_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_reference_block_url_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!named_reference_block_url_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_reference_block_url_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ("name" | "group") whitespace? "=" property-assignment
  private static boolean named_reference_block_url_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_reference_block_url_2_0_0(b, l + 1);
    r = r && named_reference_block_url_2_0_1(b, l + 1);
    r = r && consumeToken(b, equals);
    r = r && property_assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "name" | "group"
  private static boolean named_reference_block_url_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "name");
    if (!r) r = consumeToken(b, "group");
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean named_reference_block_url_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_2_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean named_reference_block_url_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_4")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean named_reference_block_url_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_reference_block_url_6")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // letter+
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE, "<namespace>");
    r = letter(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!letter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // namespace? ":"
  public static boolean namespace_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_PREFIX, "<namespace - prefix>");
    r = namespace_prefix_0(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // namespace?
  private static boolean namespace_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_prefix_0")) return false;
    namespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // letter|
  // 	decimaldigit|
  // 	symbol
  public static boolean non_whitespace_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_whitespace_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NON_WHITESPACE_CHAR, "<non - whitespace - char>");
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = symbol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nowiki-block|
  // 	html-block|
  // 	reference-block|
  // //	math-block|
  // 	pre-block|
  // 	html-comment
  public static boolean noparse_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "noparse_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOPARSE_BLOCK, "<noparse - block>");
    r = nowiki_block(b, l + 1);
    if (!r) r = html_block(b, l + 1);
    if (!r) r = reference_block(b, l + 1);
    if (!r) r = pre_block(b, l + 1);
    if (!r) r = html_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nowiki-opening-tag whitespace? nowiki-body whitespace? nowiki-closing-tag?
  public static boolean nowiki_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOWIKI_BLOCK, "<nowiki - block>");
    r = nowiki_opening_tag(b, l + 1);
    r = r && nowiki_block_1(b, l + 1);
    r = r && nowiki_body(b, l + 1);
    r = r && nowiki_block_3(b, l + 1);
    r = r && nowiki_block_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean nowiki_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_block_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean nowiki_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_block_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // nowiki-closing-tag?
  private static boolean nowiki_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_block_4")) return false;
    nowiki_closing_tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // characters
  public static boolean nowiki_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOWIKI_BODY, "<nowiki - body>");
    r = characters(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "</nowiki" whitespace? ">"
  public static boolean nowiki_closing_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_closing_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOWIKI_CLOSING_TAG, "<nowiki - closing - tag>");
    r = consumeToken(b, "</nowiki");
    r = r && nowiki_closing_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean nowiki_closing_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_closing_tag_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "<nowiki" (whitespace characters?)? ">"
  public static boolean nowiki_opening_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_opening_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOWIKI_OPENING_TAG, "<nowiki - opening - tag>");
    r = consumeToken(b, "<nowiki");
    r = r && nowiki_opening_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace characters?)?
  private static boolean nowiki_opening_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_opening_tag_1")) return false;
    nowiki_opening_tag_1_0(b, l + 1);
    return true;
  }

  // whitespace characters?
  private static boolean nowiki_opening_tag_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_opening_tag_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = whitespace(b, l + 1);
    r = r && nowiki_opening_tag_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // characters?
  private static boolean nowiki_opening_tag_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nowiki_opening_tag_1_0_1")) return false;
    characters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // page-first-char page-char*
  public static boolean page(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAGE, "<page>");
    r = page_first_char(b, l + 1);
    r = r && page_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // page-char*
  private static boolean page_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!page_char(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "page_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // canonical-page-char|
  // 	space
  public static boolean page_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAGE_CHAR, "<page - char>");
    r = canonical_page_char(b, l + 1);
    if (!r) r = consumeToken(b, space);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ucaseletter|
  // 	lcaseletter |
  //     decimaldigit|
  //     underscore
  public static boolean page_first_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_first_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAGE_FIRST_CHAR, "<page - first - char>");
    r = consumeToken(b, ucaseletter);
    if (!r) r = consumeToken(b, lcaseletter);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = consumeToken(b, underscore);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // title-character (space? title-character)*
  public static boolean page_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAGE_NAME, "<page - name>");
    r = title_character(b, l + 1);
    r = r && page_name_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (space? title-character)*
  private static boolean page_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_name_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!page_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "page_name_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // space? title-character
  private static boolean page_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = page_name_1_0_0(b, l + 1);
    r = r && title_character(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // space?
  private static boolean page_name_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "page_name_1_0_0")) return false;
    consumeToken(b, space);
    return true;
  }

  /* ********************************************************** */
  // lines-of-text
  public static boolean paragraph(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAGRAPH, "<paragraph>");
    r = lines_of_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // paragraph (EOF | newline? special-block-and-more | newline paragraph-and-more |  (tablesectionstart | tablesectionstartcaptionable))?
  public static boolean paragraph_and_more(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAGRAPH_AND_MORE, "<paragraph - and - more>");
    r = paragraph(b, l + 1);
    r = r && paragraph_and_more_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EOF | newline? special-block-and-more | newline paragraph-and-more |  (tablesectionstart | tablesectionstartcaptionable))?
  private static boolean paragraph_and_more_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1")) return false;
    paragraph_and_more_1_0(b, l + 1);
    return true;
  }

  // EOF | newline? special-block-and-more | newline paragraph-and-more |  (tablesectionstart | tablesectionstartcaptionable)
  private static boolean paragraph_and_more_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EOF(b, l + 1);
    if (!r) r = paragraph_and_more_1_0_1(b, l + 1);
    if (!r) r = paragraph_and_more_1_0_2(b, l + 1);
    if (!r) r = paragraph_and_more_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline? special-block-and-more
  private static boolean paragraph_and_more_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paragraph_and_more_1_0_1_0(b, l + 1);
    r = r && special_block_and_more(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean paragraph_and_more_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1_0_1_0")) return false;
    consumeToken(b, newline);
    return true;
  }

  // newline paragraph-and-more
  private static boolean paragraph_and_more_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && paragraph_and_more(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // tablesectionstart | tablesectionstartcaptionable
  private static boolean paragraph_and_more_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraph_and_more_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tablesectionstart);
    if (!r) r = consumeToken(b, tablesectionstartcaptionable);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unicode-wiki |
  // //	"<nowiki>" ("|" | "[" | "]" | "<" | ">" | "{" | "}")* "</nowiki>" |
  // 	unicode-wiki space* ("*" | "#" | ":" | ";")? |
  // //	unicode-wiki space? "=" space? unicode-wiki |
  // 	unicode-wiki "'" |
  // 	"'" unicode-wiki
  public static boolean plain_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLAIN_TEXT, "<plain - text>");
    r = unicode_wiki(b, l + 1);
    if (!r) r = plain_text_1(b, l + 1);
    if (!r) r = plain_text_2(b, l + 1);
    if (!r) r = plain_text_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unicode-wiki space* ("*" | "#" | ":" | ";")?
  private static boolean plain_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unicode_wiki(b, l + 1);
    r = r && plain_text_1_1(b, l + 1);
    r = r && plain_text_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // space*
  private static boolean plain_text_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, space)) break;
      if (!empty_element_parsed_guard_(b, "plain_text_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ("*" | "#" | ":" | ";")?
  private static boolean plain_text_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_1_2")) return false;
    plain_text_1_2_0(b, l + 1);
    return true;
  }

  // "*" | "#" | ":" | ";"
  private static boolean plain_text_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "#");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // unicode-wiki "'"
  private static boolean plain_text_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unicode_wiki(b, l + 1);
    r = r && consumeToken(b, "'");
    exit_section_(b, m, null, r);
    return r;
  }

  // "'" unicode-wiki
  private static boolean plain_text_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plain_text_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "'");
    r = r && unicode_wiki(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "PMID" spaces digits
  public static boolean pmid_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pmid_number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PMID_NUMBER, "<pmid - number>");
    r = consumeToken(b, "PMID");
    r = r && spaces(b, l + 1);
    r = r && digits(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pre-opening-tag whitespace? pre-body whitespace? pre-closing-tag?
  public static boolean pre_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRE_BLOCK, "<pre - block>");
    r = pre_opening_tag(b, l + 1);
    r = r && pre_block_1(b, l + 1);
    r = r && pre_body(b, l + 1);
    r = r && pre_block_3(b, l + 1);
    r = r && pre_block_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean pre_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_block_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean pre_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_block_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // pre-closing-tag?
  private static boolean pre_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_block_4")) return false;
    pre_closing_tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // characters
  public static boolean pre_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRE_BODY, "<pre - body>");
    r = characters(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "</pre" whitespace? ">"
  public static boolean pre_closing_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_closing_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRE_CLOSING_TAG, "<pre - closing - tag>");
    r = consumeToken(b, "</pre");
    r = r && pre_closing_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean pre_closing_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_closing_tag_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "<pre" (whitespace characters?)? ">"
  public static boolean pre_opening_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_opening_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRE_OPENING_TAG, "<pre - opening - tag>");
    r = consumeToken(b, "<pre");
    r = r && pre_opening_tag_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace characters?)?
  private static boolean pre_opening_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_opening_tag_1")) return false;
    pre_opening_tag_1_0(b, l + 1);
    return true;
  }

  // whitespace characters?
  private static boolean pre_opening_tag_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_opening_tag_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = whitespace(b, l + 1);
    r = r && pre_opening_tag_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // characters?
  private static boolean pre_opening_tag_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_opening_tag_1_0_1")) return false;
    characters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // whitespace? doublequote? reference-name doublequote? whitespace?
  public static boolean property_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_ASSIGNMENT, "<property - assignment>");
    r = property_assignment_0(b, l + 1);
    r = r && property_assignment_1(b, l + 1);
    r = r && reference_name(b, l + 1);
    r = r && property_assignment_3(b, l + 1);
    r = r && property_assignment_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean property_assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_assignment_0")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // doublequote?
  private static boolean property_assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_assignment_1")) return false;
    consumeToken(b, doublequote);
    return true;
  }

  // doublequote?
  private static boolean property_assignment_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_assignment_3")) return false;
    consumeToken(b, doublequote);
    return true;
  }

  // whitespace?
  private static boolean property_assignment_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_assignment_4")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "http://"|
  // 	"https://"|
  // 	"ftp://"|
  // 	"ftps://"|
  // 	"mailto:"|
  // 	"www"
  public static boolean protocol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "protocol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROTOCOL, "<protocol>");
    r = consumeToken(b, "http://");
    if (!r) r = consumeToken(b, "https://");
    if (!r) r = consumeToken(b, "ftp://");
    if (!r) r = consumeToken(b, "ftps://");
    if (!r) r = consumeToken(b, "mailto:");
    if (!r) r = consumeToken(b, "www");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // url-reference-block |
  //     named-reference-block |
  //     named-reference-block-self-closing
  public static boolean reference_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_block")) return false;
    if (!nextTokenIs(b, "<reference - block>", refopen, refopencomplete)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_BLOCK, "<reference - block>");
    r = url_reference_block(b, l + 1);
    if (!r) r = named_reference_block(b, l + 1);
    if (!r) r = named_reference_block_self_closing(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // refclose
  public static boolean reference_closing_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_closing_tag")) return false;
    if (!nextTokenIs(b, refclose)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, refclose);
    exit_section_(b, m, REFERENCE_CLOSING_TAG, r);
    return r;
  }

  /* ********************************************************** */
  // paragraph-and-more
  public static boolean reference_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_CONTENT, "<reference - content>");
    r = paragraph_and_more(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (friendly-ref-link-char | whitespace)*
  public static boolean reference_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_name")) return false;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_NAME, "<reference - name>");
    int c = current_position_(b);
    while (true) {
      if (!reference_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reference_name", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // friendly-ref-link-char | whitespace
  private static boolean reference_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = friendly_ref_link_char(b, l + 1);
    if (!r) r = whitespace(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refopen
  public static boolean reference_opening_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_opening_tag")) return false;
    if (!nextTokenIs(b, refopen)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, refopen);
    exit_section_(b, m, REFERENCE_OPENING_TAG, r);
    return r;
  }

  /* ********************************************************** */
  // refopencomplete
  public static boolean reference_opening_tag_complete(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_opening_tag_complete")) return false;
    if (!nextTokenIs(b, refopencomplete)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, refopencomplete);
    exit_section_(b, m, REFERENCE_OPENING_TAG_COMPLETE, r);
    return r;
  }

  /* ********************************************************** */
  // "RFC" spaces digits
  public static boolean rfc_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rfc_number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RFC_NUMBER, "<rfc - number>");
    r = consumeToken(b, "RFC");
    r = r && spaces(b, l + 1);
    r = r && digits(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // level-5-section|
  // 	level-4-section|
  // 	level-3-section|
  // 	level-2-section
  public static boolean section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SECTION, "<section>");
    r = level_5_section(b, l + 1);
    if (!r) r = level_4_section(b, l + 1);
    if (!r) r = level_3_section(b, l + 1);
    if (!r) r = level_2_section(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (title-legal-char | "%" | "#")*
  public static boolean section_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_id")) return false;
    Marker m = enter_section_(b, l, _NONE_, SECTION_ID, "<section - id>");
    int c = current_position_(b);
    while (true) {
      if (!section_id_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "section_id", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // title-legal-char | "%" | "#"
  private static boolean section_id_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_id_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = title_legal_char(b, l + 1);
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, "#");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // inline-text
  public static boolean section_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SECTION_NAME, "<section - name>");
    r = inline_text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( inline-element | special-block | decimaldigit | letter | symbol | space-tab | equals)*
  public static boolean single_line_any_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_line_any_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_LINE_ANY_CONTENT, "<single - line - any - content>");
    int c = current_position_(b);
    while (true) {
      if (!single_line_any_content_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "single_line_any_content", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // inline-element | special-block | decimaldigit | letter | symbol | space-tab | equals
  private static boolean single_line_any_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_line_any_content_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inline_element(b, l + 1);
    if (!r) r = special_block(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = letter(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = space_tab(b, l + 1);
    if (!r) r = consumeToken(b, equals);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // single-line-any-content
  public static boolean sort_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sort_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SORT_KEY, "<sort - key>");
    r = single_line_any_content(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // space|
  // 	TAB
  public static boolean space_tab(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space_tab")) return false;
    if (!nextTokenIs(b, "<space - tab>", tab, space)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPACE_TAB, "<space - tab>");
    r = consumeToken(b, space);
    if (!r) r = consumeToken(b, tab);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // space-tab+
  public static boolean space_tabs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space_tabs")) return false;
    if (!nextTokenIs(b, "<space - tabs>", tab, space)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPACE_TABS, "<space - tabs>");
    r = space_tab(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!space_tab(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "space_tabs", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // space+
  public static boolean spaces(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spaces")) return false;
    if (!nextTokenIs(b, space)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, space);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, space)) break;
      if (!empty_element_parsed_guard_(b, "spaces", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, SPACES, r);
    return r;
  }

  /* ********************************************************** */
  // table|
  // 	horizontal-rule |
  // 	list-item |
  // 	template-block |
  //     section
  public static boolean special_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIAL_BLOCK, "<special - block>");
    r = table(b, l + 1);
    if (!r) r = horizontal_rule(b, l + 1);
    if (!r) r = list_item(b, l + 1);
    if (!r) r = template_block(b, l + 1);
    if (!r) r = section(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // special-block (newline special-block-and-more | newline? paragraph-and-more)?
  public static boolean special_block_and_more(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIAL_BLOCK_AND_MORE, "<special - block - and - more>");
    r = special_block(b, l + 1);
    r = r && special_block_and_more_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (newline special-block-and-more | newline? paragraph-and-more)?
  private static boolean special_block_and_more_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more_1")) return false;
    special_block_and_more_1_0(b, l + 1);
    return true;
  }

  // newline special-block-and-more | newline? paragraph-and-more
  private static boolean special_block_and_more_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = special_block_and_more_1_0_0(b, l + 1);
    if (!r) r = special_block_and_more_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline special-block-and-more
  private static boolean special_block_and_more_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    r = r && special_block_and_more(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline? paragraph-and-more
  private static boolean special_block_and_more_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = special_block_and_more_1_0_1_0(b, l + 1);
    r = r && paragraph_and_more(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean special_block_and_more_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_block_and_more_1_0_1_0")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // sub-page-separator page-char+
  public static boolean sub_page(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_page")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUB_PAGE, "<sub - page>");
    r = sub_page_separator(b, l + 1);
    r = r && sub_page_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // page-char+
  private static boolean sub_page_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_page_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = page_char(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!page_char(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sub_page_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "/"
  public static boolean sub_page_separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_page_separator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUB_PAGE_SEPARATOR, "<sub - page - separator>");
    r = consumeToken(b, "/");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // html-unsafe-symbol|
  // 	underscore|
  // 	"."|
  // 	","|
  // 	"("|")"|"-"|":"|"#"|"/"|"'"|";"|"|"|"–"|doublequote|"!"|"%"|"?"|"_"|"—"|"+"|"$"|"~"|"·"|"’"|equals|"†"|"½"|"*"|"@"|"−"|"‘"|"^"|"ᴥ"
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYMBOL, "<symbol>");
    r = html_unsafe_symbol(b, l + 1);
    if (!r) r = consumeToken(b, underscore);
    if (!r) r = consumeToken(b, ".");
    if (!r) r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, ")");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, "#");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "'");
    if (!r) r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, pipe);
    if (!r) r = consumeToken(b, "–");
    if (!r) r = consumeToken(b, doublequote);
    if (!r) r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, "?");
    if (!r) r = consumeToken(b, underscore);
    if (!r) r = consumeToken(b, "—");
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "$");
    if (!r) r = consumeToken(b, "~");
    if (!r) r = consumeToken(b, "·");
    if (!r) r = consumeToken(b, "’");
    if (!r) r = consumeToken(b, equals);
    if (!r) r = consumeToken(b, "†");
    if (!r) r = consumeToken(b, "½");
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "@");
    if (!r) r = consumeToken(b, "−");
    if (!r) r = consumeToken(b, "‘");
    if (!r) r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "ᴥ");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // table-start (space table-parameters)? (table-block)*  newline? table-end
  public static boolean table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table")) return false;
    if (!nextTokenIs(b, tablestart)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_start(b, l + 1);
    r = r && table_1(b, l + 1);
    r = r && table_2(b, l + 1);
    r = r && table_3(b, l + 1);
    r = r && table_end(b, l + 1);
    exit_section_(b, m, TABLE, r);
    return r;
  }

  // (space table-parameters)?
  private static boolean table_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_1")) return false;
    table_1_0(b, l + 1);
    return true;
  }

  // space table-parameters
  private static boolean table_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, space);
    r = r && table_parameters(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (table-block)*
  private static boolean table_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!table_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "table_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (table-block)
  private static boolean table_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean table_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_3")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // whitespace? table-section-start  (!"|" cell-formatting)? newline (table-row)*
  public static boolean table_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_BLOCK, "<table - block>");
    r = table_block_0(b, l + 1);
    r = r && table_section_start(b, l + 1);
    r = r && table_block_2(b, l + 1);
    r = r && consumeToken(b, newline);
    r = r && table_block_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean table_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_0")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (!"|" cell-formatting)?
  private static boolean table_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_2")) return false;
    table_block_2_0(b, l + 1);
    return true;
  }

  // !"|" cell-formatting
  private static boolean table_block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_block_2_0_0(b, l + 1);
    r = r && cell_formatting(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean table_block_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (table-row)*
  private static boolean table_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!table_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "table_block_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (table-row)
  private static boolean table_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_row(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // space-tab? table-row-start (!"|" cell-formatting "|")? cell-content newline?
  public static boolean table_cell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_CELL, "<table - cell>");
    r = table_cell_0(b, l + 1);
    r = r && table_row_start(b, l + 1);
    r = r && table_cell_2(b, l + 1);
    r = r && cell_content(b, l + 1);
    r = r && table_cell_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space-tab?
  private static boolean table_cell_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_0")) return false;
    space_tab(b, l + 1);
    return true;
  }

  // (!"|" cell-formatting "|")?
  private static boolean table_cell_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_2")) return false;
    table_cell_2_0(b, l + 1);
    return true;
  }

  // !"|" cell-formatting "|"
  private static boolean table_cell_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_cell_2_0_0(b, l + 1);
    r = r && cell_formatting(b, l + 1);
    r = r && consumeToken(b, pipe);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean table_cell_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline?
  private static boolean table_cell_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_4")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // table-cell-double-delimited-start cell-content newline?
  public static boolean table_cell_double_delimited(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_double_delimited")) return false;
    if (!nextTokenIs(b, tablecelldoubledelimiter)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_cell_double_delimited_start(b, l + 1);
    r = r && cell_content(b, l + 1);
    r = r && table_cell_double_delimited_2(b, l + 1);
    exit_section_(b, m, TABLE_CELL_DOUBLE_DELIMITED, r);
    return r;
  }

  // newline?
  private static boolean table_cell_double_delimited_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_double_delimited_2")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // tablecelldoubledelimiter
  public static boolean table_cell_double_delimited_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_cell_double_delimited_start")) return false;
    if (!nextTokenIs(b, tablecelldoubledelimiter)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tablecelldoubledelimiter);
    exit_section_(b, m, TABLE_CELL_DOUBLE_DELIMITED_START, r);
    return r;
  }

  /* ********************************************************** */
  // tableend
  public static boolean table_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_end")) return false;
    if (!nextTokenIs(b, tableend)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tableend);
    exit_section_(b, m, TABLE_END, r);
    return r;
  }

  /* ********************************************************** */
  // space-tab? table-header-row-start whitespace? (!"|" cell-formatting "|")? cell-content newline?
  public static boolean table_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_HEADER, "<table - header>");
    r = table_header_0(b, l + 1);
    r = r && table_header_row_start(b, l + 1);
    r = r && table_header_2(b, l + 1);
    r = r && table_header_3(b, l + 1);
    r = r && cell_content(b, l + 1);
    r = r && table_header_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space-tab?
  private static boolean table_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_0")) return false;
    space_tab(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean table_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_2")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (!"|" cell-formatting "|")?
  private static boolean table_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_3")) return false;
    table_header_3_0(b, l + 1);
    return true;
  }

  // !"|" cell-formatting "|"
  private static boolean table_header_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_header_3_0_0(b, l + 1);
    r = r && cell_formatting(b, l + 1);
    r = r && consumeToken(b, pipe);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean table_header_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline?
  private static boolean table_header_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_5")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // table-header-double-delimited-start cell-content newline?
  public static boolean table_header_double_delimited(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_double_delimited")) return false;
    if (!nextTokenIs(b, tableheaderdoubledelimiter)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_header_double_delimited_start(b, l + 1);
    r = r && cell_content(b, l + 1);
    r = r && table_header_double_delimited_2(b, l + 1);
    exit_section_(b, m, TABLE_HEADER_DOUBLE_DELIMITED, r);
    return r;
  }

  // newline?
  private static boolean table_header_double_delimited_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_double_delimited_2")) return false;
    consumeToken(b, newline);
    return true;
  }

  /* ********************************************************** */
  // tableheaderdoubledelimiter
  public static boolean table_header_double_delimited_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_double_delimited_start")) return false;
    if (!nextTokenIs(b, tableheaderdoubledelimiter)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tableheaderdoubledelimiter);
    exit_section_(b, m, TABLE_HEADER_DOUBLE_DELIMITED_START, r);
    return r;
  }

  /* ********************************************************** */
  // "!"
  public static boolean table_header_row_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header_row_start")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_HEADER_ROW_START, "<table - header - row - start>");
    r = consumeToken(b, "!");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // single-line-any-content
  public static boolean table_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_parameters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_PARAMETERS, "<table - parameters>");
    r = single_line_any_content(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // table-header|table-cell|table-header-double-delimited|table-cell-double-delimited
  public static boolean table_row(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_row")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_ROW, "<table - row>");
    r = table_header(b, l + 1);
    if (!r) r = table_cell(b, l + 1);
    if (!r) r = table_header_double_delimited(b, l + 1);
    if (!r) r = table_cell_double_delimited(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "|"
  public static boolean table_row_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_row_start")) return false;
    if (!nextTokenIs(b, pipe)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    exit_section_(b, m, TABLE_ROW_START, r);
    return r;
  }

  /* ********************************************************** */
  // tablesectionstart | tablesectionstartcaptionable
  public static boolean table_section_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_section_start")) return false;
    if (!nextTokenIs(b, "<table - section - start>", tablesectionstart, tablesectionstartcaptionable)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_SECTION_START, "<table - section - start>");
    r = consumeToken(b, tablesectionstart);
    if (!r) r = consumeToken(b, tablesectionstartcaptionable);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // tablestart
  public static boolean table_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_start")) return false;
    if (!nextTokenIs(b, tablestart)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, tablestart);
    exit_section_(b, m, TABLE_START, r);
    return r;
  }

  /* ********************************************************** */
  // template-block-start template-name whitespace? newline*  ("|" whitespace? (template-property-named|template-property-unassigned)? whitespace? newline* noparse-block?)* template-block-end
  public static boolean template_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block")) return false;
    if (!nextTokenIs(b, curlyopen2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template_block_start(b, l + 1);
    r = r && template_name(b, l + 1);
    r = r && template_block_2(b, l + 1);
    r = r && template_block_3(b, l + 1);
    r = r && template_block_4(b, l + 1);
    r = r && template_block_end(b, l + 1);
    exit_section_(b, m, TEMPLATE_BLOCK, r);
    return r;
  }

  // whitespace?
  private static boolean template_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_2")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline*
  private static boolean template_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, newline)) break;
      if (!empty_element_parsed_guard_(b, "template_block_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ("|" whitespace? (template-property-named|template-property-unassigned)? whitespace? newline* noparse-block?)*
  private static boolean template_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!template_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "template_block_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // "|" whitespace? (template-property-named|template-property-unassigned)? whitespace? newline* noparse-block?
  private static boolean template_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, pipe);
    r = r && template_block_4_0_1(b, l + 1);
    r = r && template_block_4_0_2(b, l + 1);
    r = r && template_block_4_0_3(b, l + 1);
    r = r && template_block_4_0_4(b, l + 1);
    r = r && template_block_4_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean template_block_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (template-property-named|template-property-unassigned)?
  private static boolean template_block_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_2")) return false;
    template_block_4_0_2_0(b, l + 1);
    return true;
  }

  // template-property-named|template-property-unassigned
  private static boolean template_block_4_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template_property_named(b, l + 1);
    if (!r) r = template_property_unassigned(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean template_block_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // newline*
  private static boolean template_block_4_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, newline)) break;
      if (!empty_element_parsed_guard_(b, "template_block_4_0_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // noparse-block?
  private static boolean template_block_4_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_4_0_5")) return false;
    noparse_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "}}"
  public static boolean template_block_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_end")) return false;
    if (!nextTokenIs(b, curlyclose2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, curlyclose2);
    exit_section_(b, m, TEMPLATE_BLOCK_END, r);
    return r;
  }

  /* ********************************************************** */
  // "{{"
  public static boolean template_block_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_block_start")) return false;
    if (!nextTokenIs(b, curlyopen2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, curlyopen2);
    exit_section_(b, m, TEMPLATE_BLOCK_START, r);
    return r;
  }

  /* ********************************************************** */
  // (!"|" (letter|symbol|decimaldigit|whitespace-char))*
  public static boolean template_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_name")) return false;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_NAME, "<template - name>");
    int c = current_position_(b);
    while (true) {
      if (!template_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "template_name", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !"|" (letter|symbol|decimaldigit|whitespace-char)
  private static boolean template_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template_name_0_0(b, l + 1);
    r = r && template_name_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"|"
  private static boolean template_name_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_name_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter|symbol|decimaldigit|whitespace-char
  private static boolean template_name_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_name_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = whitespace_char(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( !"=" !"|"  (letter|symbol|decimaldigit|whitespace-char))*
  public static boolean template_property_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_name")) return false;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_PROPERTY_NAME, "<template - property - name>");
    int c = current_position_(b);
    while (true) {
      if (!template_property_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "template_property_name", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !"=" !"|"  (letter|symbol|decimaldigit|whitespace-char)
  private static boolean template_property_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template_property_name_0_0(b, l + 1);
    r = r && template_property_name_0_1(b, l + 1);
    r = r && template_property_name_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"="
  private static boolean template_property_name_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_name_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, equals);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !"|"
  private static boolean template_property_name_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_name_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, pipe);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letter|symbol|decimaldigit|whitespace-char
  private static boolean template_property_name_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_name_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = letter(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = whitespace_char(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // template-property-name whitespace? equals whitespace? template-property-value
  public static boolean template_property_named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_named")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_PROPERTY_NAMED, "<template - property - named>");
    r = template_property_name(b, l + 1);
    r = r && template_property_named_1(b, l + 1);
    r = r && consumeToken(b, equals);
    r = r && template_property_named_3(b, l + 1);
    r = r && template_property_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean template_property_named_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_named_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean template_property_named_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_named_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // inline-element-sans-pipe
  public static boolean template_property_unassigned(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_unassigned")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_PROPERTY_UNASSIGNED, "<template - property - unassigned>");
    r = inline_element_sans_pipe(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // inline-element-sans-pipe
  public static boolean template_property_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_property_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_PROPERTY_VALUE, "<template - property - value>");
    r = inline_element_sans_pipe(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line+ (newline+ line+)*
  public static boolean text_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_CONTENT, "<text - content>");
    r = text_content_0(b, l + 1);
    r = r && text_content_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // line+
  private static boolean text_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_content_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (newline+ line+)*
  private static boolean text_content_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!text_content_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_content_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // newline+ line+
  private static boolean text_content_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = text_content_1_0_0(b, l + 1);
    r = r && text_content_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline+
  private static boolean text_content_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, newline);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, newline)) break;
      if (!empty_element_parsed_guard_(b, "text_content_1_0_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // line+
  private static boolean text_content_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_content_1_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // formatted-text |
  // 	noparse-block|
  // 	behaviour-switch|
  // 	html-entity|
  // 	html-unsafe-symbol|
  // 	text-content|
  // 	letter|
  // 	decimaldigit|
  // 	symbol|
  // 	space-tab
  public static boolean text_with_formatting(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_with_formatting")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_WITH_FORMATTING, "<text - with - formatting>");
    r = formatted_text(b, l + 1);
    if (!r) r = noparse_block(b, l + 1);
    if (!r) r = behaviour_switch(b, l + 1);
    if (!r) r = html_entity(b, l + 1);
    if (!r) r = html_unsafe_symbol(b, l + 1);
    if (!r) r = text_content(b, l + 1);
    if (!r) r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = space_tab(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unicode-character bad-title-characters
  public static boolean title_character(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "title_character")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TITLE_CHARACTER, "<title - character>");
    r = unicode_character(b, l + 1);
    r = r && bad_title_characters(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // lcaseletter
  public static boolean title_legal_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "title_legal_char")) return false;
    if (!nextTokenIs(b, lcaseletter)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, lcaseletter);
    exit_section_(b, m, TITLE_LEGAL_CHAR, r);
    return r;
  }

  /* ********************************************************** */
  // any-supported-unicode-character Whitespaces?
  public static boolean unicode_character(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unicode_character")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNICODE_CHARACTER, "<unicode - character>");
    r = any_supported_unicode_character(b, l + 1);
    r = r && unicode_character_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Whitespaces?
  private static boolean unicode_character_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unicode_character_1")) return false;
    Whitespaces(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // letter |
  // 	decimaldigit |
  // 	symbol
  public static boolean unicode_wiki(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unicode_wiki")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNICODE_WIKI, "<unicode - wiki>");
    r = letter(b, l + 1);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = symbol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEGAL_URL_ENTITY+
  public static boolean url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL, "<url>");
    r = LEGAL_URL_ENTITY(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!LEGAL_URL_ENTITY(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "url", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEGAL_URL_ENTITY
  public static boolean url_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL_CHAR, "<url - char>");
    r = LEGAL_URL_ENTITY(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // url-char
  public static boolean url_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL_PATH, "<url - path>");
    r = url_char(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ((reference-opening-tag whitespace? unescapedgreaterthan)|(reference-opening-tag-complete)) whitespace? reference-content whitespace? reference-closing-tag
  public static boolean url_reference_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block")) return false;
    if (!nextTokenIs(b, "<url - reference - block>", refopen, refopencomplete)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL_REFERENCE_BLOCK, "<url - reference - block>");
    r = url_reference_block_0(b, l + 1);
    r = r && url_reference_block_1(b, l + 1);
    r = r && reference_content(b, l + 1);
    r = r && url_reference_block_3(b, l + 1);
    r = r && reference_closing_tag(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (reference-opening-tag whitespace? unescapedgreaterthan)|(reference-opening-tag-complete)
  private static boolean url_reference_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = url_reference_block_0_0(b, l + 1);
    if (!r) r = url_reference_block_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-opening-tag whitespace? unescapedgreaterthan
  private static boolean url_reference_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_opening_tag(b, l + 1);
    r = r && url_reference_block_0_0_1(b, l + 1);
    r = r && consumeToken(b, unescapedgreaterthan);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean url_reference_block_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_0_0_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // (reference-opening-tag-complete)
  private static boolean url_reference_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_opening_tag_complete(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace?
  private static boolean url_reference_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  // whitespace?
  private static boolean url_reference_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_reference_block_3")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (ucaseletter|lcaseletter) (ucaseletter|decimaldigit|lcaseletter)*
  public static boolean variable_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_name")) return false;
    if (!nextTokenIs(b, "<variable - name>", lcaseletter, ucaseletter)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_NAME, "<variable - name>");
    r = variable_name_0(b, l + 1);
    r = r && variable_name_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ucaseletter|lcaseletter
  private static boolean variable_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ucaseletter);
    if (!r) r = consumeToken(b, lcaseletter);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ucaseletter|decimaldigit|lcaseletter)*
  private static boolean variable_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_name_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!variable_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_name_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ucaseletter|decimaldigit|lcaseletter
  private static boolean variable_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ucaseletter);
    if (!r) r = consumeToken(b, decimaldigit);
    if (!r) r = consumeToken(b, lcaseletter);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // whitespace-char whitespace?
  public static boolean whitespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHITESPACE, "<whitespace>");
    r = whitespace_char(b, l + 1);
    r = r && whitespace_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // whitespace?
  private static boolean whitespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespace_1")) return false;
    whitespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // space-tab|
  // 	newline
  public static boolean whitespace_char(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespace_char")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHITESPACE_CHAR, "<whitespace - char>");
    r = space_tab(b, l + 1);
    if (!r) r = consumeToken(b, newline);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "*"|
  // 	"#"|
  // 	":"|
  // 	";"|
  // 	"<"|
  // 	">"|
  // //	"="|
  // 	"'"|
  // //	"{"|
  // //	"}"
  public static boolean wiki_markup_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wiki_markup_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WIKI_MARKUP_CHARACTERS, "<wiki - markup - characters>");
    r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "#");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, unescapedlessthan);
    if (!r) r = consumeToken(b, unescapedgreaterthan);
    if (!r) r = consumeToken(b, "'");
    if (!r) r = consumeToken(b, wiki_markup_characters_7_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // article?
  static boolean wiki_page(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wiki_page")) return false;
    article(b, l + 1);
    return true;
  }

}
