package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicle")
public class Vehicle implements ModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicle")
	private Long idVehicle;

	@NotNull(message = "The field brand needs to be specified")
	@JoinColumn(name = "id_brand")
	@OneToOne
	private Brand brand; 

	@NotNull(message = "The field type needs to be specified")
	@JoinColumn(name = "id_type")
	@OneToOne
	private Type type; 
	
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
