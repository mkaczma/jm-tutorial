package com.acme.craft.fixme.commons.collection;

import java.util.ArrayList;
import java.util.List;

public class PropertyService {

	public List<String> defaultProperties() {
		List<String> properties = new ArrayList<>();
		properties.add("property1");
		properties.add("property2");
		properties.add("property3");
		properties.add("property4");

		return properties;
	}

	public boolean valid(List<String> properties) {
		if (properties != null && properties.size() > 0) {
			boolean isValid = true;
			for (String property : properties) {
				isValid = isValid && valid(property);
			}
		}
		return false;
	}

	private boolean valid(String property) {
		return property != null && !property.isEmpty();
	}
}
