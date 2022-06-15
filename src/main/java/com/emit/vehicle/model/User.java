package com.emit.vehicle.model;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private Long idUser; 
	@Column(name = "name")
	private String name; 
	@Column(name = "surename")
	private String surename; 
	@Column(name = "username")
	private String username; 
	@Column(name = "password")
	private String password;
}
