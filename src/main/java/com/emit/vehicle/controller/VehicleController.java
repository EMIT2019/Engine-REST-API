package com.emit.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.service.vehicle.VehicleService;

@RestController
public class VehicleController { 
	
	@Autowired
	private VehicleService vService; 
	
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vService.getVehicles();
	}
	
	@GetMapping("/vehicle")
	public Vehicle getVehicleById(@RequestParam("idVehicle") Long id) {
		return vService.getVehicleById(id);
	}
	
	@DeleteMapping("/deleteVehicle")
	public void deleteVehicle(@RequestParam("idVehicle") Long id) {
		vService.deleteVehicle(id);
	}
	
	@PostMapping("/vehicle")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vService.saveVehicle(vehicle);
	}
	
	@PutMapping("/vehicle")
	public Vehicle updateVehicle(@RequestParam("idVehicle") Long id, @RequestBody Vehicle vehicle) {
		vehicle.setIdVehicle(id);
		return vService.updateVehicle(vehicle);
	}
	
}
