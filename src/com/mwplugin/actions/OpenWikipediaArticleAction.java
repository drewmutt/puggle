package com.mwplugin.actions;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.ide.scratch.ScratchFileService;
import com.intellij.ide.scratch.ScratchRootType;
import com.intellij.ide.util.PackageUtil;
import com.intellij.ide.util.PlatformPackageUtil;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.impl.ProjectRootUtil;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.openapi.vfs.newvfs.impl.VirtualDirectoryImpl;
import com.intellij.psi.*;
import com.intellij.util.PathUtil;
import com.intellij.util.containers.ContainerUtil;
import com.mwplugin.MediaWikiFileType;
import com.mwplugin.MediaWikiLanguage;
import com.mwplugin.dialogs.InsertTemplate;
import com.mwplugin.psi.MediaWikiFile;
import com.mwplugin.psi.MediaWikiTemplateBlock;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import static com.mwplugin.api.WPApiManager.getPageContent;
import static com.mwplugin.psi.MediaWikiElementFactory.createFile;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public class OpenWikipediaArticleAction extends AnAction
{
/*
$(".searchbox").autocomplete({
    source: function(request, response) {
        $.ajax({
            url: "http://en.wikipedia.org/w/api.php",
            dataType: "jsonp",
            data: {
                'action': "opensearch",
                'format': "json",
                'search': request.term
            },
            success: function(data) {
                response(data[1]);
            }
        });
    }
});
 */
/*
Call the base class constructor and provide either a project in the frame of which the dialog will be displayed, or a parent component for the dialog.
Call the init() method from the constructor of your dialog class
Call the setTitle() method to set the title for the dialog box
Implement the createCenterPanel() method to return the component comprising the main contents of the dialog.
 */

	@Override
	public void actionPerformed(AnActionEvent e)
	{
		InsertTemplate templateDialog = new InsertTemplate(e.getProject());
		templateDialog.setTitle("Open Article");
		templateDialog.show();
		// TODO: insert action logic here

		if(templateDialog.selectedArticle != null)
		{
			FileEditorManager manager = FileEditorManager.getInstance(e.getProject());
			String content = null;
			try
			{
				content = getPageContent(templateDialog.selectedArticle.getName());
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}

			String fileName = templateDialog.selectedArticle.getName();

			ScratchFileService.Option option = ScratchFileService.Option.create_if_missing;
			VirtualFile f = ScratchRootType.getInstance().createScratchFile(e.getProject(), PathUtil.makeFileName(fileName, "mediawiki"), MediaWikiLanguage.INSTANCE, content, option);
			if (f != null) {
				FileEditorManager.getInstance(e.getProject()).openFile(f, true);
			}

/*
			PsiFile file = PsiFileFactory.getInstance(e.getProject()).createFileFromText(fileName, MediaWikiLanguage.INSTANCE,  content);
			PsiDirectory[] allContentRoots = ProjectRootUtil.getAllContentRoots(e.getProject());
			PsiDirectory allContentRoot = allContentRoots[0];
			PsiFile[] exisitingFiles = allContentRoot.getFiles();
			for(PsiFile existingFile:exisitingFiles)
			{
				if(Objects.equals(existingFile.getName(), fileName))
				{
					new WriteCommandAction(e.getProject())
					{
						@Override
						protected void run(@NotNull Result result) throws Throwable
						{
							existingFile.delete();
							System.out.println("Deleted " + fileName);
						}
					}.execute();


					break;
				}
			}
			PsiElement add = allContentRoot.add(file);
			file.navigate(true);
*/
		}

	}

}
