package com.acme.craft.fixme.solid.open.closed;

import lombok.Data;

@Data
public abstract class Shape {

	private int type;

	public abstract void draw();
}
