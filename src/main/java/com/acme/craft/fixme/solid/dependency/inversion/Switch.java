package com.acme.craft.fixme.solid.dependency.inversion;

public class Switch {

	private Switchable switchable;
	private boolean pressed;

	public Switch(Switchable switchable) {
		this.switchable = switchable;
	}

	private void pressSwitch() {
		pressed = !pressed;
		if (pressed) {
			switchable.setOn(true);
		} else {
			switchable.setOn(false);
		}
	}
}
