package com.acme.craft.fixme.cleancode;

import java.util.List;

public class Slideshow {

	private String headlineString;
	private String type;
	private String text;
	private Asset asset;
	private List<SlideshowInterval> date;

	public String getHeadline() {
		return headlineString;
	}

	public void setHeadline(String headline) {
		this.headlineString = headline;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public List<SlideshowInterval> getDate() {
		return date;
	}

	public void setDate(List<SlideshowInterval> date) {
		this.date = date;
	}

}
