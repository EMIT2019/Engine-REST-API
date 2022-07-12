package com.emit.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User implements ModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private Long idUser; 
	
	@NotEmpty(message = "The field name must  not be empty")
	@Column(name = "name")
	private String name; 
	
	@NotEmpty(message = "The field surename must not be emtpy")
	@Column(name = "surename")
	private String surename; 
	
	@NotEmpty(message = "The field username must not be empty")
	@Column(name = "username")
	private String username; 
	
	@NotEmpty(message = "The field password must be not empty")
	@Column(name = "password")
	private String password;
}
