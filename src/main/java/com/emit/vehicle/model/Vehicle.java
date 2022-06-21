package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicle")
	private Long idVehicle;

	@NotNull(message = "The field brand needs to be specified")
	@Column(name = "id_brand")  
	private Long idBrand; 

	@NotNull(message = "The field type needs to be specified")
	@Column(name = "id_type") 
	private Long idType; 
	
	@Min(value = 1, message = "The field horsepower must be higher than 0")
	@Column(name = "horsepower") 
	private Long horsepower; 
	
	@Min(value = 1, message = "The field top_speed must be higher than 0")
	@Column(name = "top_speed") 
	private Long top_speed; 
	
	@Column(name = "img")
	private String img;
	
	@NotBlank(message = "The field model needs more content on it")
	@Column(name = "model") 
	private String model; 
}
