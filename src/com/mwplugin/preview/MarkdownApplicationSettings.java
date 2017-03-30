package com.mwplugin.preview;

/**
 * Created by andrewsimmons on 2/6/17.
 */
public class MarkdownApplicationSettings
{
	private MarkdownCssSettings markdownCssSettings;

	public MarkdownCssSettings getMarkdownCssSettings()
	{
		return markdownCssSettings;
	}

	public interface SettingsChangedListener
	{
	}
}
