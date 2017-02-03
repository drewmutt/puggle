package com.mwplugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andrewsimmons on 2/2/17.
 */
public class MediaWikiFileFactory extends FileTypeFactory
{
	@Override
	public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer)
	{
		fileTypeConsumer.consume(MediaWikiFileType.INSTANCE, "mediawiki");
	}
}