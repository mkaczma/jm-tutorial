package com.acme.craft.fixme.commons.collection;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;

public class PropertyService {

	public List<String> defaultProperties() {
		List<String> properties = Lists.newArrayList("p1", "p2", "p3", "p4");
		return properties;
	}

	public boolean valid(List<String> properties) {
		if (!CollectionUtils.isEmpty(properties)) {
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
