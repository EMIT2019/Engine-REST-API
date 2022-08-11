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
	public VehicleDto toGetDtoEntity(Vehicle entity) {
		VehicleDto vehicleGetDto = new VehicleDto();
		vehicleGetDto.setIdVehicle(entity.getIdVehicle());
		vehicleGetDto.setBrand(brandMapper.toGetDtoEntity(entity.getBrand()));
		vehicleGetDto.setType(typeMapper.toGetDtoEntity(entity.getType()));
		vehicleGetDto.setHorsepower(entity.getHorsepower());
		vehicleGetDto.setTop_speed(entity.getTop_speed());
		vehicleGetDto.setImg(entity.getImg());
		vehicleGetDto.setModel(entity.getModel());
		return vehicleGetDto;
	}

	@Override
	public Vehicle toPostEntity(VehicleDto dto) {
		Vehicle vehicle = new Vehicle();
		vehicle.setIdVehicle(dto.getIdVehicle());
		vehicle.setBrand(brandMapper.toPostEntity(dto.getBrand()));
		vehicle.setType(typeMapper.toPostEntity(dto.getType()));
		vehicle.setHorsepower(dto.getHorsepower());
		vehicle.setTop_speed(dto.getTop_speed());
		vehicle.setImg(dto.getImg());
		vehicle.setModel(dto.getModel());
		return vehicle;
	}
}
