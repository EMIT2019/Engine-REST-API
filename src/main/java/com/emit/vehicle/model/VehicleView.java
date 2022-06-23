package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Immutable
public class VehicleView {
	@Id
	private Long id_vehicle;  
	
	private String brand_name; 
	
	private String type; 
	
	private Long horsepower; 
	
	private Long top_speed; 
	
	private String img; 
	
	private String model; 
}
