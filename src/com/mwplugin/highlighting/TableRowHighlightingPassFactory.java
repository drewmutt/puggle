package com.mwplugin.highlighting;

import com.intellij.codeHighlighting.Pass;
import com.intellij.codeHighlighting.TextEditorHighlightingPass;
import com.intellij.codeHighlighting.TextEditorHighlightingPassFactory;
import com.intellij.codeHighlighting.TextEditorHighlightingPassRegistrar;
import com.intellij.codeInsight.CodeInsightSettings;
import com.intellij.codeInsight.daemon.impl.IdentifierHighlighterPass;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

/**
 * Created by andrewsimmons on 5/5/17.
 */
public class TableRowHighlightingPassFactory extends AbstractProjectComponent implements TextEditorHighlightingPassFactory
{
	private static final int[] AFTER_PASSES = {Pass.UPDATE_ALL};


	public TableRowHighlightingPassFactory(Project project, TextEditorHighlightingPassRegistrar highlightingPassRegistrar) {
		super(project);
		highlightingPassRegistrar.registerTextEditorHighlightingPass(this, null, AFTER_PASSES, false, -1);
	}

	@Override
	public TextEditorHighlightingPass createHighlightingPass(@NotNull final PsiFile file, @NotNull final Editor editor) {
		if (!editor.isOneLineMode() &&
				CodeInsightSettings.getInstance().HIGHLIGHT_IDENTIFIER_UNDER_CARET &&
				!DumbService.isDumb(myProject) &&
				(!ApplicationManager.getApplication().isHeadlessEnvironment()) &&
				(file.isPhysical() || file.getOriginalFile().isPhysical())) {
			return new TableRowHighlighterPass(file.getProject(), file, editor);
		}

		return null;
	}


}
