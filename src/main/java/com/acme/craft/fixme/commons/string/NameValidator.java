package com.acme.craft.fixme.commons.string;

public class NameValidator {

	public boolean valid(String name) {
		if (name != null && name.length() > 0) {
			return true;
		}
		return false;
	}

	public boolean isJohn(String name) {
		String johnName = "John";
		return name == johnName;
	}

	public String validationMessage(String firstName, String lastName, String nick) {
		return "Provided name is not valid. First name: " + firstName + ", lastName: " + lastName + " nick:" + nick;
	}

}
