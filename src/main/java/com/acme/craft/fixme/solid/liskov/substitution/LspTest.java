package com.acme.craft.fixme.solid.liskov.substitution;

public class LspTest {

	private static Rectangle getNewRectangle() {
		// Object returned by some fancy Factory
		return new Square();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Rectangle r = getNewRectangle();
		
		r.setWidth(5);
		r.setHeight(10);
		// user assumes he works with a rectangle and tries to set height and width accordingly
		
		System.out.println(r.getArea());
	}
}
