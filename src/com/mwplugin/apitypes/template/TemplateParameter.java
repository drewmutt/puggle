package com.mwplugin.apitypes.template;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Created by andrewsimmons on 4/26/17.
 */
public class TemplateParameter
{
	public String name;
	public LinkedTreeMap<String, String> label;
	public LinkedTreeMap<String, String> description;
	public String type;
	public String required;
	public Boolean suggested;
	public Boolean deprecated;
}

/*
{
    "pages": {
        "2159001": {
            "title": "Template:Userbox",
            "description": {
                "en": "This template can be used to quickly create a userbox for display on a user's user page without having to know HTML or Wikitable syntax.",
                "_type": "assoc"
            },
            "params": {
                "bodyclass": {
                    "label": {
                        "en": "bodyclass",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "Adds an HTML class attribute to the entire template&#39;s HTML table, to allow for styling, emission of microformats, etc.",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "border-c": {
                    "label": {
                        "en": "border-c",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "border color",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "#999",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "border-s": {
                    "label": {
                        "en": "border-s",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "border width in pixels",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "1",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "float": {
                    "label": {
                        "en": "float",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "left|right|none",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "left",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id": {
                    "label": {
                        "en": "id",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id image or text",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-a": {
                    "label": {
                        "en": "id-a",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id horizontal alignment left/center/right/justify",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "center",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-c": {
                    "label": {
                        "en": "id-c",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id background color",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "#d0d0d0",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-fc": {
                    "label": {
                        "en": "id-fc",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id font color",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "black",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-h": {
                    "label": {
                        "en": "id-h",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id box height in pixels",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "45",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-lh": {
                    "label": {
                        "en": "id-lh",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id line height",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "1.25em",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-op": {
                    "label": {
                        "en": "id-op",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id other CSS parameters",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-p": {
                    "label": {
                        "en": "id-p",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id cell padding",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "0 1px 0 0",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-s": {
                    "label": {
                        "en": "id-s",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id text size in points",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "14",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "id-w": {
                    "label": {
                        "en": "id-w",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "id box width in pixels",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "45",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-class": {
                    "label": {
                        "en": "info-class",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "Adds an HTML class attribute to the &ldquo;info&rdquo; HTML table-row, to allow for styling, emission of microformats, etc.",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info": {
                    "label": {
                        "en": "info",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info text or image",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-a": {
                    "label": {
                        "en": "info-a",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info horizontal alignment left/center/right/justify",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "left",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-c": {
                    "label": {
                        "en": "info-c",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info background color",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "#e0e0e0",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-fc": {
                    "label": {
                        "en": "info-fc",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info font color",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "black",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-lh": {
                    "label": {
                        "en": "info-lh",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info line height",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "1.25em",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-op": {
                    "label": {
                        "en": "info-op",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info other CSS parameters",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-p": {
                    "label": {
                        "en": "info-p",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info padding",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "0 4px 0 4px",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "info-s": {
                    "label": {
                        "en": "info-s",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "info text size in points",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "8",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "nocat": {
                    "label": {
                        "en": "nocat",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "block page category declarations (see WP:NOCAT)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "false",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "usercategory": {
                    "label": {
                        "en": "usercategory",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "user category (optional)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "usercategory2": {
                    "label": {
                        "en": "usercategory2",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "user category (optional)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
                    "_BC_bools": [
                        "required",
                        "suggested",
                        "deprecated"
                    ],
                    "_type": "assoc"
                },
                "usercategory3": {
                    "label": {
                        "en": "usercategory3",
                        "_type": "assoc"
                    },
                    "description": {
                        "en": "user category (optional)",
                        "_type": "assoc"
                    },
                    "type": "string",
                    "default": {
                        "en": "",
                        "_type": "assoc"
                    },
                    "required": false,
                    "suggested": false,
                    "example": null,
                    "deprecated": false,
                    "aliases": [],
                    "autovalue": null,
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
                "0": "bodyclass",
                "1": "border-c",
                "2": "border-s",
                "3": "float",
                "4": "id",
                "5": "id-a",
                "6": "id-c",
                "7": "id-fc",
                "8": "id-h",
                "9": "id-lh",
                "10": "id-op",
                "11": "id-p",
                "12": "id-s",
                "13": "id-w",
                "14": "info-class",
                "15": "info",
                "16": "info-a",
                "17": "info-c",
                "18": "info-fc",
                "19": "info-lh",
                "20": "info-op",
                "21": "info-p",
                "22": "info-s",
                "23": "nocat",
                "24": "usercategory",
                "25": "usercategory2",
                "26": "usercategory3",
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