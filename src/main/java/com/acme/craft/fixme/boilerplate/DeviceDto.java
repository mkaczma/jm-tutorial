package com.acme.craft.fixme.boilerplate;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceDto implements Serializable {
	private static final long serialVersionUID = -8984798902681813138L;

	private String id;
	private String externalId;
	private String type;
	private UUID uuid;
	private String thingId;
	private String name;
	private String description;
	private String status;
	private String registrationKey;
	private String ownerId;
	private Map<String, String> properties;

	public DeviceDto(String id, String externalId, String type, UUID uuid, String thingId, String name,
			String description, String status, String registrationKey, String ownerId, Map<String, String> properties) {
		this.id = id;
		this.externalId = externalId;
		this.type = type;
		this.uuid = uuid;
		this.thingId = thingId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.registrationKey = registrationKey;
		this.ownerId = ownerId;
		this.properties = properties;
	}

}
