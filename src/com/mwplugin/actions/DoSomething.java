package com.mwplugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.mwplugin.dialogs.InsertTemplate;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public class DoSomething extends AnAction
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
		templateDialog.setTitle("Sup!");
		templateDialog.show();
		// TODO: insert action logic here
System.out.println("GEY");
		if(templateDialog.selectedTemplate != null)
		{
			FileEditorManager manager = FileEditorManager.getInstance(e.getProject());
			final Editor editor = manager.getSelectedTextEditor();
			assert editor != null;
			final int cursorOffset = editor.getCaretModel().getOffset();
			final Document document = editor.getDocument();

			new WriteCommandAction(e.getProject())
			{
				@Override
				protected void run(@NotNull Result result) throws Throwable
				{
					document.insertString(cursorOffset, templateDialog.selectedTemplate.content);
				}
			}.execute();
		}

	}
}
