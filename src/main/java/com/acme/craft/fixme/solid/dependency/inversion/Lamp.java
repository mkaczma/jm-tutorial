package com.acme.craft.fixme.solid.dependency.inversion;

import lombok.Data;

@Data
public class Lamp {

	private boolean on = false;

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

}
