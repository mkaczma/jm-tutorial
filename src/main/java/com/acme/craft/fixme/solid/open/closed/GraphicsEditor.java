package com.acme.craft.fixme.solid.open.closed;

public class GraphicsEditor {
	
	
	public void drawCircle(Circle s) {
		
	}
	
	public void drawRectangle(Rectangle s) {
		
	}
	
	public void drawShape(Shape s) {
		if (s instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) s;
			drawRectangle(rectangle);
		} if (s instanceof Circle) {
			Circle circle = (Circle) s;
			drawCircle(circle);
		}
	}

}
