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
	public ResponseEntity<List<VehicleDto>> getPage(Integer page, Integer records) {
		List<VehicleDto> vehicleGetDtoList = vService.getPage(page, records).stream()
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

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenBrand(String brandName) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenBrand(brandName).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenModel(String modelName) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenModel(modelName).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByGivenType(String typeName) {
		List<VehicleDto> vehicleDtoList = vService.getAllByGivenType(typeName).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByFasterThan(Long speed) {
		List<VehicleDto> vehicleDtoList = vService.getAllByFasterThan(speed).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}

	@Override
	public ResponseEntity<List<VehicleDto>> getAllByHorsePowerGreaterThan(Long horsepower) {
		List<VehicleDto> vehicleDtoList = vService.getAllByHorsePowerGreaterThan(horsepower).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(vehicleDtoList);
	}


}
