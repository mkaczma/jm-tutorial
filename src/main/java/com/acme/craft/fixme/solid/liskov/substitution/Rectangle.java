package com.acme.craft.fixme.solid.liskov.substitution;

import lombok.Data;

@Data
public class Rectangle {

	protected int width;
	protected int height;
	
	public int getArea() {
		return getWidth() * getHeight();
	}
}
