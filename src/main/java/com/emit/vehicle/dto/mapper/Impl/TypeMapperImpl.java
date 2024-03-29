package com.emit.vehicle.dto.mapper.Impl;

import com.emit.vehicle.model.Brand;
import org.springframework.stereotype.Component;

import com.emit.vehicle.dto.TypeDto;
import com.emit.vehicle.dto.mapper.TypeMapper;
import com.emit.vehicle.model.Type;

@Component
public class TypeMapperImpl implements TypeMapper {
	@Override
	public TypeDto toGetDtoEntity(Type entity) {
		TypeDto typeDto = new TypeDto();
		typeDto.setId_type(entity.getId_type());
		typeDto.setType(entity.getType());
		return typeDto;
	}

	@Override
	public Type toPostEntity(TypeDto dto) {
		Type type = new Type();
		type.setId_type(dto.getId_type());
		type.setType(dto.getType());
		return type;
	}
}
