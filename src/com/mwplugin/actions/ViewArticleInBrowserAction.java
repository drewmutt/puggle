package com.mwplugin.actions;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.vfs.VirtualFile;

import java.net.URI;

/**
 * Created by andrewsimmons on 5/12/17.
 */
public class ViewArticleInBrowserAction extends AnAction
{
	@Override
	public void actionPerformed(AnActionEvent e)
	{
		Document currentDoc = FileEditorManager.getInstance(e.getProject()).getSelectedTextEditor().getDocument();
		VirtualFile currentFile = FileDocumentManager.getInstance().getFile(currentDoc);
		String fileName = currentFile.getPath();
	}
}
