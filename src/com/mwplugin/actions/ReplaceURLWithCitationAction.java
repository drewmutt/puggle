package com.mwplugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

import static com.mwplugin.api.WPApiManager.getCitationFromURL;

/**
 * Created by andrewsimmons on 5/16/17.
 */
public class ReplaceURLWithCitationAction extends AnAction
{
	@Override
	public void actionPerformed(AnActionEvent e)
	{
		Editor editor = e.getData(DataKeys.EDITOR);
		SelectionModel selectionModel = editor.getSelectionModel();
		String url = selectionModel.getSelectedText();
		String citationFromURL = getCitationFromURL(url);
		Document document = editor.getDocument();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				document.replaceString(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd(),citationFromURL);
			}
		};
		WriteCommandAction.runWriteCommandAction(e.getProject(), runnable);
		selectionModel.removeSelection();

	}
}
