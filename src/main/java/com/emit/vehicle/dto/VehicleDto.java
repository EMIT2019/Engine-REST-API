package com.emit.vehicle.dto;

import lombok.Data;

@Data
public class VehicleDto implements DtoEntity {
	private Long idVehicle; 
	private BrandDto brand;
	private TypeDto type;
	private Long horsepower; 
	private Long top_speed; 
	private String img; 
	private String model; 
}
