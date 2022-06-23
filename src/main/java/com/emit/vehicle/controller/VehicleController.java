package com.emit.vehicle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.service.vehicle.VehicleService;

@RequestMapping("/vehicles")
@RestController
public class VehicleController { 
	
	@Autowired
	private VehicleService vService; 
	
	@GetMapping("/all-vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		return new ResponseEntity<List<Vehicle>>(vService.getVehicles(), HttpStatus.OK);
	}
	
	@GetMapping("/vehicle-page")
	public ResponseEntity<List<Vehicle>> getPageVehicle(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize){
		return new ResponseEntity<List<Vehicle>>(vService.getPageVehicles(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@GetMapping("/get-vehicle")
	public ResponseEntity<Vehicle> getVehicleById(@RequestParam("idVehicle") Long id) {
		return new ResponseEntity<Vehicle>(vService.getVehicleById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-vehicle")
	public ResponseEntity<HttpStatus> deleteVehicle(@RequestParam("idVehicle") Long id) {
		vService.deleteVehicle(id);	
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/save-vehicle")
	public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vService.saveVehicle(vehicle), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-vehicle")
	public ResponseEntity<Vehicle> updateVehicle(@RequestParam("idVehicle") Long id, @RequestBody Vehicle vehicle) {
		vehicle.setIdVehicle(id);
		return new ResponseEntity<Vehicle>(vService.updateVehicle(vehicle), HttpStatus.OK);
	}
	
}
