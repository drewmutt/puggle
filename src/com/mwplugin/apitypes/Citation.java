package com.mwplugin.apitypes;

import java.util.Objects;

/**
 * Created by andrewsimmons on 5/16/17.
 */
public class Citation
{
	public String url;
	public String itemType;
	public String abstractNote;
	public String title;
	public String accessDate;
	public String websiteTitle;
	public String language;

	public String getMediaWikiText()
	{
		if(Objects.equals(itemType, "newspaperArticle"))
			itemType = "news";
		if(Objects.equals(itemType, "webpage"))
			itemType = "web";

		String tag = "{{cite " + itemType;

		if(url != null)
			tag = tag + "| url="+url;

//		if(abstractNote != null)
//			tag = tag + "| abstractNote=\""+url+"\"";

		if(title != null)
			tag = tag + "| title="+title;

		if(accessDate != null)
			tag = tag + "| access-date="+accessDate;

		if(websiteTitle != null)
			tag = tag + "| website="+websiteTitle;

		if(language != null)
			tag = tag + "| language="+language;

		tag = tag + "}}";
		return  tag;
	}

	/*
	{
		"url": "http://www.theage.com.au/news/book-reviews/border-street/2006/10/06/1159641511585.html",
			"itemType": "webpage",
			"abstractNote": "Explores the bittersweet offshoots of an unlikely friendship. -",
			"title": "Border Street - Book Reviews - Books - Entertainment - theage.com.au",
			"language": "en",
			"accessDate": "2017-05-17",
			"websiteTitle": "www.theage.com.au",
			"source": [
		"citoid"
    ]
	}*/
}
