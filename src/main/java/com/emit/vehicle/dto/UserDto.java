package com.emit.vehicle.dto;

import lombok.Data;

@Data
public class UserDto implements DtoEntity {
	private Long idUser; 
	private String name; 
	private String surename; 
	private String username; 
	private String password; 
}
