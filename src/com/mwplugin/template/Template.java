package com.mwplugin.template;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewsimmons on 4/21/17.
 */
public class Template
{
	public String title;
	public LinkedTreeMap<String, String> description;
	public String content;
	public LinkedTreeMap<String, TemplateParameter> params;
}

/*
{
    "pages": {
        "7256413": {
            "title": "Template:Orphan",
            "description": {
                "en": "This template should only be put on articles which meet the orphan criteria.",
                "_type": "assoc"
            },
            "params": {
                "date": {
                    "label": {
                        "en": "Date",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "The date this template was added to the page. (Input: Monthname Year)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "default": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "att": {
                    "label": {
                        "en": "De-orphan attempt",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "If you have made an unsuccessful attempt to de-orphan the article, please fill in this field to record the attempt. (Input: Monthname Year)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "default": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "few": {
                    "label": {
                        "en": "Few linked articles",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "If the article only has one or two links to it and it is felt more are required and possible this option can be used. (Input: Monthname Year)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "default": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "incat": {
                    "label": {
                        "en": "In Category",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "If the article has no link and probably never will, but is well categorised this option can be used.(Input: Monthname Year)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "default": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "_type": "kvp",
                "_kvpkeyname": "key",
                "_element": "param"
            },
            "format": null,
            "paramOrder": {
                "0": "date",
                "1": "att",
                "2": "few",
                "3": "incat",
                "_element": "p"
            },
            "sets": [],
            "maps": {
                "_type": "assoc"
            }
        },
        "_type": "kvp",
        "_kvpkeyname": "id",
        "_element": "page"
    },
    "_type": "assoc"
}
 */