package com.emit.vehicle.controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.emit.vehicle.controller.TypeController;
import com.emit.vehicle.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.dto.TypeDto;
import com.emit.vehicle.dto.mapper.TypeMapper;
import com.emit.vehicle.service.type.TypeService;

@RequestMapping("/types")
@RestController
public class TypeControllerImpl implements TypeController {

	private final TypeService tService;

	private final TypeMapper mapper;

	public TypeControllerImpl(TypeMapper mapper, TypeService typeService){
		this.mapper = mapper;
		this.tService = typeService;
	}

	@Override
	public ResponseEntity<List<TypeDto>> getAll() {
		List<TypeDto> typeDtoList = tService.getAll().stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(typeDtoList);
	}

	@Override
	public ResponseEntity<TypeDto> getById(Long id) {
		Type type;
		type = tService.getById(id);
		return ResponseEntity.ok(mapper.toGetDtoEntity(type));
	}

	@Override
	public ResponseEntity<List<TypeDto>> getPage(Integer page, Integer records) {
		List<TypeDto> typeDtoList = tService.getPage(page, records).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(typeDtoList);
	}

	@Override
	public ResponseEntity<TypeDto> save(TypeDto dtoEntity) {
		Type type, savedType;
		type = mapper.toPostEntity(dtoEntity);
		savedType = tService.save(type);
		return new ResponseEntity<TypeDto>(mapper.toGetDtoEntity(savedType), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TypeDto> update(Long id, TypeDto dtoEntity) {
		dtoEntity.setId_type(id);
		Type type, updatedType;
		type = mapper.toPostEntity(dtoEntity);
		updatedType = tService.update(type);
		return ResponseEntity.ok(mapper.toGetDtoEntity(updatedType));
	}

	@Override
	public void delete(Long id) {
		tService.delete(id);
	}

	@Override
	public ResponseEntity<List<TypeDto>> getAllByGivenName(String typeName) {
		List<TypeDto> typeDtoList = tService.getTypeByGivenName(typeName).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(typeDtoList);
	}
}
