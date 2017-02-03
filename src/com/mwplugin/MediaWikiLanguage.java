package com.mwplugin;

import com.intellij.lang.Language;

/**
 * Created by andrewsimmons on 2/2/17.
 */

public class MediaWikiLanguage extends Language
{
    public static final MediaWikiLanguage INSTANCE = new MediaWikiLanguage();

    private MediaWikiLanguage()
    {
        super("MediaWiki");
    }
}

