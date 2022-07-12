package com.emit.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "type")
public class Type implements ModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type")
	private Long id_type; 
	
	@NotEmpty(message = "The field type must not be empty")
	@Column(name = "type")
	private String type; 
}
