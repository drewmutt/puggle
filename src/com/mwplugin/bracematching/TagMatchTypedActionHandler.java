package com.mwplugin.bracematching;

import com.intellij.codeInsight.editorActions.TypedHandler;
import com.intellij.codeInsight.highlighting.BraceMatcher;
import com.intellij.codeInsight.highlighting.BraceMatchingUtil;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IElementType;
import com.mwplugin.MediaWikiFileType;
import com.mwplugin.MediaWikiLanguage;
import com.mwplugin.psi.MediaWikiTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 5/3/17.
 */
public class TagMatchTypedActionHandler extends TypedHandler
{
	public TagMatchTypedActionHandler(TypedActionHandler originalHandler)
	{
		super(originalHandler);
	}

	@Override
		public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext)
		{
			super.execute(editor, c, dataContext);
			handleTagMatching(editor, MediaWikiFileType.INSTANCE, c);
			/*
			final Document document = editor.getDocument();
			Project project = editor.getProject();
			Runnable runnable = new Runnable()
			{
				@Override
				public void run()
				{
//					document.insertString(0, "Typed\n");

				}
			};
			WriteCommandAction.runWriteCommandAction(project, runnable);*/
		}



	private static void handleTagMatching(@NotNull Editor editor, @NotNull FileType fileType, char lparenChar){
		int offset = editor.getCaretModel().getOffset();
		HighlighterIterator iterator = ((EditorEx) editor).getHighlighter().createIterator(offset);
		boolean atEndOfDocument = offset == editor.getDocument().getTextLength();

		if (!atEndOfDocument) iterator.retreat();
		if (iterator.atEnd()) return;
		BraceMatcher braceMatcher = BraceMatchingUtil.getBraceMatcher(fileType, iterator);
		if (iterator.atEnd()) return;
		IElementType braceTokenType = iterator.getTokenType();
		final CharSequence fileText = editor.getDocument().getCharsSequence();
		if (!braceMatcher.isLBraceToken(iterator, fileText, fileType)) return;

		if (!iterator.atEnd()) {
			iterator.advance();

			iterator.retreat();
		}

		int lparenOffset = BraceMatchingUtil.findLeftmostLParen(iterator, braceTokenType, fileText,fileType);
		if (lparenOffset < 0) lparenOffset = 0;

		iterator = ((EditorEx)editor).getHighlighter().createIterator(lparenOffset);
		boolean matched = BraceMatchingUtil.matchBrace(fileText, fileType, iterator, true, true);

		if (!matched) {
			String text;
			if (braceTokenType == MediaWikiTypes.refopencomplete) {
				text = "</ref>";
			}
			else if (braceTokenType == MediaWikiTypes.openbracket2) {
				text = "]]";
			}
			else if (lparenChar == '[') {
				text = "]";
			}
			else if (braceTokenType == MediaWikiTypes.curlyopen2) {
				text = "}}";
			}
			else {
				throw new AssertionError("Unknown char "+lparenChar);
			}
			editor.getDocument().insertString(offset, text);
		}
	}

}