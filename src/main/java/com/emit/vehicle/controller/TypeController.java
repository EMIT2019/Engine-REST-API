package com.emit.vehicle.controller;

import java.util.List;
import java.util.stream.Collectors;

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
public class TypeController {
	
	@Autowired
	private TypeService tService; 
	
	private TypeMapper mapper = new TypeMapperImpl(); 
	
	@GetMapping("/all-types")
	public ResponseEntity<List<TypeDto>> getAllTypes(){
		return new ResponseEntity<List<TypeDto>>(tService.getAllTypes().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("type-page")
	public ResponseEntity<List<TypeDto>> getPageType(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize){
		return new ResponseEntity<List<TypeDto>>(tService.getPageType(pageNumber, pageSize).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("/get-type")
	public ResponseEntity<TypeDto> getTypeById(@RequestParam("idType") Long id) {
		return new ResponseEntity<TypeDto>(mapper.toDto(tService.getTypeById(id)), HttpStatus.OK);
	}
	
	@PostMapping("/save-type")
	public ResponseEntity<TypeDto> saveType(@RequestBody TypeDto typeDto) {
		tService.saveType(mapper.toEntity(typeDto));
		return new ResponseEntity<TypeDto>(typeDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-type")
	public ResponseEntity<TypeDto> updateType(@RequestParam("idType") Long id, @RequestBody TypeDto typeDto) {
		typeDto.setId_type(id);
		tService.updateType(mapper.toEntity(typeDto));
		return new ResponseEntity<TypeDto>(typeDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-type")
	public ResponseEntity<HttpStatus> deleteType(@RequestParam("idType") Long id) {
		tService.deleteType(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
