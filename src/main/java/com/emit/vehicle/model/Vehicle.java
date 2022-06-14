package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
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
	@Column(name = "id_brand")
	private Long idBrand; 
	@Column(name = "id_type")
	private Long idType; 
	@Column(name = "horsepower")
	private Long horsepower; 
	@Column(name = "top_speed")
	private Long top_speed; 
	@Column(name = "img")
	private String img;
	@Column(name = "model")
	private String model; 
}
