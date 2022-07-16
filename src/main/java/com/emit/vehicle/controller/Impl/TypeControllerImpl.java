package com.emit.vehicle.controller.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.emit.vehicle.controller.TypeController;
import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.model.Type;
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

import com.emit.vehicle.dto.TypeDto;
import com.emit.vehicle.dto.mapper.TypeMapper;
import com.emit.vehicle.dto.mapper.Impl.TypeMapperImpl;
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
				.map(mapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok(typeDtoList);
	}

	@Override
	public ResponseEntity<TypeDto> getById(Long id) {
		Type type;
		type = tService.getById(id);
		return ResponseEntity.ok(mapper.toDto(type));
	}

	@Override
	public ResponseEntity<List<TypeDto>> getPage(Integer page, Integer records) {
		List<TypeDto> typeDtoList = tService.getPage(page, records).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok(typeDtoList);
	}

	@Override
	public ResponseEntity<TypeDto> save(TypeDto dtoEntity) {
		Type type, savedType;
		type = mapper.toEntity(dtoEntity);
		savedType = tService.save(type);
		return new ResponseEntity<TypeDto>(mapper.toDto(savedType), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TypeDto> update(Long id, TypeDto dtoEntity) {
		dtoEntity.setId_type(id);
		Type type, updatedType;
		type = mapper.toEntity(dtoEntity);
		updatedType = tService.update(type);
		return ResponseEntity.ok(mapper.toDto(updatedType));
	}

	@Override
	public void delete(Long id) {
		tService.delete(id);
	}
}
