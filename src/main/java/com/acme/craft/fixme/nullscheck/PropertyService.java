package com.acme.craft.fixme.nullscheck;

public class PropertyService {

	private PropertyRepository repository = new PropertyRepository();

	private void update(String propertyId, String value) {
		Property property = repository.get(propertyId);
		if (property != null) {
			property.setValue(value);
			repository.save(property);
		} else {
            throw new RuntimeException("Property not found:" + propertyId);
        }
	}
}
