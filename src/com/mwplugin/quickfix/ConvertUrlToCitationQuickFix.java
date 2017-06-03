package com.mwplugin.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.ide.browsers.WebBrowser;
import com.intellij.ide.browsers.WebBrowserManager;
import com.intellij.ide.browsers.WebBrowserReferenceConverter;
import com.intellij.ide.browsers.WebBrowserService;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.indexing.FileBasedIndex;
import com.mwplugin.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

import static com.mwplugin.api.WPApiManager.getCitationFromURL;

public class ConvertUrlToCitationQuickFix extends BaseIntentionAction
{
	private MediaWikiUrl url;

	public ConvertUrlToCitationQuickFix(MediaWikiUrl url)
	{
		this.url = url;
	}

	@NotNull
	@Override
	public String getText()
	{
		return "Convert to citation";
	}

	@NotNull
	@Override
	public String getFamilyName()
	{
		return "MediaWiki properties";
	}

	@Override
	public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file)
	{
		return true;
	}

	@Override
	public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws IncorrectOperationException
	{
		ApplicationManager.getApplication().invokeLater(new Runnable()
		{
			@Override
			public void run()
			{

				//				SelectionModel selectionModel = editor.getSelectionModel();
				//				String url = selectionModel.getSelectedText();
				//				MediaWikiReferenceContent referenceContent = PsiTreeUtil.getParentOfType(url, MediaWikiReferenceContent.class);
				ProgressManager.getInstance().run(new Task.Backgroundable(project, "Fetching Citation Template")
				{
					public void run(@NotNull ProgressIndicator progressIndicator)
					{

						// start your process

						// Set the progress bar percentage and text
						progressIndicator.setFraction(0.10);
						progressIndicator.setText("Contacting API");

						new WriteCommandAction.Simple(project)
						{
							@Override
							public void run()
							{
								String citationFromURL = getCitationFromURL(url.getText());
								if (citationFromURL != null)
								{
									progressIndicator.setFraction(0.90);
									progressIndicator.setText("Replacing URL");

									PsiElement referenceContent = PsiTreeUtil.getParentOfType(url, MediaWikiReferenceContent.class);
									MediaWikiTemplateBlock templateBlock = MediaWikiElementFactory.createTemplate(project, citationFromURL);
									referenceContent.replace(templateBlock);
									//									parent.add(templateBlock);
//									url.delete();
								}
							}
						}.execute();

					}
				});


			}

			;
		});
	}
//
//	private void createProperty(final Project project, final VirtualFile file)
//	{
//		new WriteCommandAction(project)
//		{
//			@Override
//			protected void run(@NotNull Result result) throws Throwable
//			{
//
//				MediaWikiFile MediaWikiFile = (MediaWikiFile) PsiManager.getInstance(project).findFile(file);
//				ASTNode lastChildNode = MediaWikiFile.getNode().getLastChildNode();
//				// TODO: Add another check for CRLF
//				if (lastChildNode != null/* && !lastChildNode.getElementType().equals(MediaWikiTypes.CRLF)*/)
//				{
//					MediaWikiFile.getNode().addChild(MediaWikiElementFactory.createCRLF(project).getNode());
//				}
//				// IMPORTANT: change spaces to escaped spaces or the new node will only have the first word for the key
////				MediaWikiProperty property = MediaWikiElementFactory.createProperty(project, key.replaceAll(" ", "\\\\ "), "");
////				MediaWikiFile.getNode().addChild(property.getNode());
////				((Navigatable) property.getLastChild().getNavigationElement()).navigate(true);
//				FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveCaretRelatively(2, 0, false, false, false);
//
//				// almost the same thing but manipulating plain text of the document instead of PSI
////                FileEditorManager.getInstance(project).openFile(file, true);
////                final Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
////                final Document document = editor.getDocument();
////                document.insertString(document.getTextLength(), "\n" + key.replaceAll(" ", "\\\\ ") + " = ");
////                editor.getCaretModel().getPrimaryCaret().moveToOffset(document.getTextLength());
//			}
//		}.execute();
//	}
}