package com.acme.craft.fixme.cleancode;

public class SlideshowFactory {
	
	public static Slideshow getSlideshow(Asset asset){
		Slideshow slideshow = new Slideshow();
		slideshow.setHeadline("Slideshow");
		slideshow.setType("default");
		if(asset == null){
			slideshow.setText("You dont have default content for Slideshow");
		} else {
			slideshow.setText("This is your default Slideshow content");
			slideshow.setAsset(asset);
		}
		return slideshow;
	}

}
