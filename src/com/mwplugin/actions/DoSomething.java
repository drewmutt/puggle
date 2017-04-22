package com.mwplugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import com.mwplugin.InsertTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.apache.commons.httpclient.params.HttpMethodParams.USER_AGENT;

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


	}
}
