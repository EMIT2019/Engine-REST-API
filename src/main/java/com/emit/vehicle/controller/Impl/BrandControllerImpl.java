package com.emit.vehicle.controller.Impl;

import com.emit.vehicle.controller.BaseController;
import com.emit.vehicle.controller.BrandController;
import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.model.Brand;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.dto.mapper.BrandMapper;
import com.emit.vehicle.service.brand.BrandService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/brands")
@RestController
public class BrandControllerImpl implements BrandController {
	private final BrandService<Integer> bService;
	
	private final BrandMapper mapper;

	public BrandControllerImpl(BrandService<Integer> brandService, BrandMapper brandMapper){
		this.bService = brandService;
		this.mapper = brandMapper;
	}

	@Override
	public ResponseEntity<List<BrandDto>> getAll() {
		List<BrandDto> brandDtoList = bService.getAll().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok(brandDtoList);
	}

	@Override
	public ResponseEntity<BrandDto> getById(Long id) {
		return ResponseEntity.ok(mapper.toDto(bService.getById(id)));
	}

	@Override
	public ResponseEntity<List<BrandDto>> getPage(Integer page, Integer records) {
		List<BrandDto> brandDtoList = bService.getPage(page, records).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok(brandDtoList);
	}

	@Override
	public ResponseEntity<BrandDto> save(BrandDto dtoEntity) {
		return new ResponseEntity<BrandDto>(
				mapper.toDto(
						bService.save(
								mapper.toEntity(dtoEntity)
						)
				),
				HttpStatus.CREATED
		);
	}

	@Override
	public ResponseEntity<BrandDto> update(Long id, BrandDto dtoEntity) {
		dtoEntity.setId_brand(id);
		return ResponseEntity.ok(
				mapper.toDto(
						bService.update(
								mapper.toEntity(dtoEntity)
						)
				)
		);
	}

	@Override
	public void delete(Long id) {
		bService.delete(id);
	}
}
