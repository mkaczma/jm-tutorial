package com.acme.craft.fixme.contract;

import java.util.UUID;

import lombok.Data;

@Data
public class DeviceDto {
	String id;
	String name;
	UUID uuid;
}
