package com.emit.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class VehicleApiApplication {
	final String baseUrl = "/engine";
	
	public static void main(String[] args) {
		
		SpringApplication.run(VehicleApiApplication.class, args);
	}

}
