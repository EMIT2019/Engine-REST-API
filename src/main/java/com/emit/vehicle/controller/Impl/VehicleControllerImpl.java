package com.emit.vehicle.controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.emit.vehicle.controller.VehicleController;
import com.emit.vehicle.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<VehicleDto> vehicleGetDtoList = vService.getAll().stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleGetDtoList);
	}

	@Override
	public ResponseEntity<VehicleDto> getById(Long id) {
		Vehicle vehicle;
		vehicle = vService.getById(id);
		return ResponseEntity.ok(mapper.toGetDtoEntity(vehicle));
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getPage(Integer page) {
		List<VehicleDto> vehicleGetDtoList = vService.getPage(page).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleGetDtoList);
	}

	@Override
	public ResponseEntity<VehicleDto> save(VehicleDto dtoEntity) {
		Vehicle vehicle, savedVehicle;
		vehicle = mapper.toPostEntity(dtoEntity);
		savedVehicle = vService.save(vehicle);
		return new ResponseEntity<VehicleDto>(mapper.toGetDtoEntity(savedVehicle), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<VehicleDto> update(Long id, VehicleDto dtoEntity) {
		dtoEntity.setIdVehicle(id);
		Vehicle vehicle, updatedVehicle;
		vehicle = mapper.toPostEntity(dtoEntity);
		updatedVehicle = vService.save(vehicle);
		return ResponseEntity.ok(mapper.toGetDtoEntity(updatedVehicle));
	}

	@Override
	public void delete(Long id) {
		vService.delete(id);
	}

	//The brandKey parameter can have a descriptive or primary key value (it can work in both ways thanks to some Specification pattern implementation)
	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenBrand(Integer page, String brandKey) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenBrand(page, brandKey).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenModel(Integer page, String modelName) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenModel(page, modelName).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	//The typeKey parameter can have a descriptive or primary key value (it can work in both ways thanks to some Specification pattern implementation)
	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenType(Integer page, String typeKey) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenType(page, typeKey).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByFasterThan(Integer page, Long speed) {
		List<VehicleDto> vehicleDtoList = vService.getAllByFasterThan(page, speed).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByHorsePowerGreaterThan(Integer page, Long horsepower) {
		List<VehicleDto> vehicleDtoList = vService.getAllByHorsePowerGreaterThan(page, horsepower).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}
	//This method allows the client to make a search with one or more parameters (it can work in that way thanks to combining Specifications)
	@Override
	public ResponseEntity<List<VehicleDto>> globalVehicleSearch(Integer page, String parameters) {
		List<VehicleDto> vehicleDtoList = vService.globalVehicleSearch(page, parameters).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}
}
