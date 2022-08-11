package com.emit.vehicle.dto;

import com.emit.vehicle.dto.DtoEntity;
import lombok.Data;

@Data
public class TypeDto implements DtoEntity {
	private Long id_type; 
	private String type; 
}
