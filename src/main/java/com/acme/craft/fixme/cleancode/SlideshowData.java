package com.acme.craft.fixme.cleancode;


public class SlideshowData {

	private Slideshow timeline;
	private Integer slide;

	public SlideshowData(Slideshow timeline2, int slide2) {
		timeline = timeline2;
		slide = slide2;
	}

	public Slideshow getTimeline() {
		return timeline;
	}

	public void setTimeline(Slideshow timeline) {
		this.timeline = timeline;
	}

	public Integer getSlide() {
		return slide;
	}

	public void setSlide(Integer slide) {
		this.slide = slide;
	}

}
