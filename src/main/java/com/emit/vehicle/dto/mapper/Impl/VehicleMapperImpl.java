package com.emit.vehicle.dto.mapper.Impl;

import org.springframework.stereotype.Component;

import com.emit.vehicle.dto.VehicleDto;
import com.emit.vehicle.dto.mapper.BrandMapper;
import com.emit.vehicle.dto.mapper.TypeMapper;
import com.emit.vehicle.dto.mapper.VehicleMapper;
import com.emit.vehicle.model.Vehicle;

@Component
public class VehicleMapperImpl implements VehicleMapper {
	private final BrandMapper brandMapper;
	private final TypeMapper typeMapper;

	public VehicleMapperImpl(BrandMapper brandMapper, TypeMapper typeMapper) {
		this.brandMapper = brandMapper; 
		this.typeMapper = typeMapper; 
	}
	
	@Override
	public VehicleDto toDto(Vehicle entity) {
		VehicleDto vehicleDto = new VehicleDto();
		vehicleDto.setIdVehicle(entity.getIdVehicle());
		vehicleDto.setBrand(brandMapper.toDto(entity.getBrand()));
		vehicleDto.setType(typeMapper.toDto(entity.getType()));
		vehicleDto.setHorsepower(entity.getHorsepower());
		vehicleDto.setTop_speed(entity.getTop_speed());
		vehicleDto.setImg(entity.getImg());
		vehicleDto.setModel(entity.getModel());
		return vehicleDto;
	}

	@Override
	public Vehicle toEntity(VehicleDto dto) {
		Vehicle vehicle = new Vehicle();
		vehicle.setIdVehicle(dto.getIdVehicle());
		vehicle.setBrand(brandMapper.toEntity(dto.getBrand()));
		vehicle.setType(typeMapper.toEntity(dto.getType()));
		vehicle.setHorsepower(dto.getHorsepower());
		vehicle.setTop_speed(dto.getTop_speed());
		vehicle.setImg(dto.getImg());
		vehicle.setModel(dto.getModel());
		return vehicle;
	}

}
