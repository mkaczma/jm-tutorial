package com.acme.craft.fixme.boilerplate;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getThingId() {
		return thingId;
	}

	public void setThingId(String thingId) {
		this.thingId = thingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegistrationKey() {
		return registrationKey;
	}

	public void setRegistrationKey(String registrationKey) {
		this.registrationKey = registrationKey;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DeviceDto deviceDto = (DeviceDto) o;

		if (id != null ? !id.equals(deviceDto.id) : deviceDto.id != null)
			return false;
		if (externalId != null ? !externalId.equals(deviceDto.externalId) : deviceDto.externalId != null)
			return false;
		if (type != null ? !type.equals(deviceDto.type) : deviceDto.type != null)
			return false;
		if (uuid != null ? !uuid.equals(deviceDto.uuid) : deviceDto.uuid != null)
			return false;
		if (thingId != null ? !thingId.equals(deviceDto.thingId) : deviceDto.thingId != null)
			return false;
		if (name != null ? !name.equals(deviceDto.name) : deviceDto.name != null)
			return false;
		if (description != null ? !description.equals(deviceDto.description) : deviceDto.description != null)
			return false;
		if (status != null ? !status.equals(deviceDto.status) : deviceDto.status != null)
			return false;
		if (registrationKey != null ? !registrationKey.equals(deviceDto.registrationKey)
				: deviceDto.registrationKey != null)
			return false;
		if (ownerId != null ? !ownerId.equals(deviceDto.ownerId) : deviceDto.ownerId != null)
			return false;
		return !(properties != null ? !properties.equals(deviceDto.properties) : deviceDto.properties != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
		result = 31 * result + (thingId != null ? thingId.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (registrationKey != null ? registrationKey.hashCode() : 0);
		result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
		result = 31 * result + (properties != null ? properties.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "DeviceDto{" + "id='" + id + '\'' + ", externalId='" + externalId + '\'' + ", type='" + type + '\''
				+ ", uuid=" + uuid + ", thingId='" + thingId + '\'' + ", name='" + name + '\'' + ", description='"
				+ description + '\'' + ", status='" + status + '\'' + ", registrationKey='" + registrationKey + '\''
				+ ", ownerId='" + ownerId + '\'' + ", properties=" + properties + '}';
	}
}
