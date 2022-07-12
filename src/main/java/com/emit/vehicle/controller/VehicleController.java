package com.emit.vehicle.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.emit.vehicle.dto.VehicleDto;
import com.emit.vehicle.dto.mapper.VehicleMapper;
import com.emit.vehicle.dto.mapper.Impl.VehicleMapperImpl;
import com.emit.vehicle.service.vehicle.VehicleService;

@RequestMapping("/vehicles")
@RestController
public class VehicleController { 
	
	@Autowired
	private VehicleService vService; 
	
	private VehicleMapper mapper = new VehicleMapperImpl();
	
	@GetMapping("/all-vehicles")
	public ResponseEntity<List<VehicleDto>> getAllVehicles() {
		return new ResponseEntity<List<VehicleDto>>(vService.getVehicles().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("/vehicle-page")
	public ResponseEntity<List<VehicleDto>> getPageVehicle(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize){
		return new ResponseEntity<List<VehicleDto>>(vService.getPageVehicles(pageNumber, pageSize).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("/get-vehicle")
	public ResponseEntity<VehicleDto> getVehicleById(@RequestParam("idVehicle") Long id) {
		return new ResponseEntity<VehicleDto>(mapper.toDto(vService.getVehicleById(id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-vehicle")
	public ResponseEntity<HttpStatus> deleteVehicle(@RequestParam("idVehicle") Long id) {
		vService.deleteVehicle(id);	
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/save-vehicle")
	public ResponseEntity<VehicleDto> saveVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
		vService.saveVehicle(mapper.toEntity(vehicleDto));
		return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-vehicle")
	public ResponseEntity<VehicleDto> updateVehicle(@RequestParam("idVehicle") Long id, @RequestBody VehicleDto vehicleDto) {
		vehicleDto.setIdVehicle(id);
		vService.updateVehicle(mapper.toEntity(vehicleDto));
		return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.OK);
	}
	
}
