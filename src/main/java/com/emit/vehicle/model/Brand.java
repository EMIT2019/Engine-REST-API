package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "brand")
public class Brand implements ModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_brand")
	private Long id_brand; 
	
	@NotEmpty(message = "The field brand_name must not be empty")
	@Column(name = "brand_name")
	private String brand_name; 
	
	@Column(name = "img")
	private String img; 
}
