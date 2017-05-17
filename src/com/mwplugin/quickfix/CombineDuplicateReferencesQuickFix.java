package com.mwplugin.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.mwplugin.psi.*;
import com.mwplugin.psi.impl.MediaWikiReferenceBlockImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

import static com.mwplugin.api.WPApiManager.getCitationFromURL;

/**
 * Created by andrewsimmons on 5/16/17.
 */
public class CombineDuplicateReferencesQuickFix extends BaseIntentionAction
	{
		private final ArrayList<MediaWikiReferenceBlock> duplicateRefBlocks;

	public CombineDuplicateReferencesQuickFix(ArrayList<MediaWikiReferenceBlock> duplicateRefBlocks)
		{
			this.duplicateRefBlocks = duplicateRefBlocks;
		}

		@NotNull
		@Override
		public String getText()
		{
			return "Combine duplicate references";
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
		public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
		IncorrectOperationException
		{
			ApplicationManager.getApplication().invokeLater(new Runnable()
			{
				@Override
				public void run()
				{

						new WriteCommandAction.Simple(project)
						{
							@Override
							public void run()
							{
								String refname = "refname";
								MediaWikiReferenceBlock firstRefBlock = duplicateRefBlocks.get(0);
								MediaWikiReferenceContent firstRefBlockContent  = PsiTreeUtil.findChildOfAnyType(firstRefBlock, MediaWikiReferenceContent.class);
								MediaWikiReferenceBlock newFirstRefBlock = MediaWikiElementFactory.createPopulatedNamedReference(project, refname, firstRefBlockContent.getText());
								firstRefBlock.replace(newFirstRefBlock);

								for(MediaWikiReferenceBlock refBlock : duplicateRefBlocks)
								{
									MediaWikiReferenceBlock newRefBlock = MediaWikiElementFactory.createEmptyNamedReference(project, refname);
									refBlock.replace(newRefBlock);
								}
							}
						}.execute();

					}
				});
			};
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
