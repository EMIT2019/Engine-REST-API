package com.emit.vehicle.controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.emit.vehicle.controller.VehicleController;
import com.emit.vehicle.model.Vehicle;
import org.apache.coyote.Response;
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
import com.emit.vehicle.service.vehicle.VehicleService;

@RequestMapping("/vehicles")
@RestController
public class VehicleControllerImpl implements VehicleController {

	private final VehicleService vService;

	private final VehicleMapper mapper;

	public VehicleControllerImpl(VehicleService vehicleService, VehicleMapper vehicleMapper){
		this.vService = vehicleService;
		this.mapper = vehicleMapper;
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAll() {
		List<VehicleDto> vehicleDtoList = vService.getAll().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<VehicleDto> getById(Long id) {
		Vehicle vehicle;
		vehicle = vService.getById(id);
		return ResponseEntity.ok(mapper.toDto(vehicle));
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getPage(Integer page, Integer records) {
		List<VehicleDto> vehicleDtoList = vService.getPage(page, records).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<VehicleDto> save(VehicleDto dtoEntity) {
		Vehicle vehicle, savedVehicle;
		vehicle = mapper.toEntity(dtoEntity);
		savedVehicle = vService.save(vehicle);
		return new ResponseEntity<VehicleDto>(mapper.toDto(savedVehicle), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<VehicleDto> update(Long id, VehicleDto dtoEntity) {
		dtoEntity.setIdVehicle(id);
		Vehicle vehicle, updatedVehicle;
		vehicle = mapper.toEntity(dtoEntity);
		updatedVehicle = vService.save(vehicle);
		return ResponseEntity.ok(mapper.toDto(updatedVehicle));
	}

	@Override
	public void delete(Long id) {
		vService.delete(id);
	}
}
