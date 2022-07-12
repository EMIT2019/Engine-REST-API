package com.emit.vehicle.dto;

import lombok.Data;

@Data
public class BrandDto implements DtoEntity {
	private Long id_brand; 
	private String brand_name; 
	private String img; 
}
