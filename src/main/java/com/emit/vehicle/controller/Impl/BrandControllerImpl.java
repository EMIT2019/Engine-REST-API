package com.emit.vehicle.controller.Impl;

import com.emit.vehicle.controller.BrandController;
import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.model.Brand;
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
	private final BrandService bService;
	
	private final BrandMapper mapper;

	public BrandControllerImpl(BrandService brandService, BrandMapper brandMapper){
		this.bService = brandService;
		this.mapper = brandMapper;
	}

	@Override
	public ResponseEntity<List<BrandDto>> getAll() {
		List<BrandDto> brandDtoList = bService.getAll().stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(brandDtoList);
	}

	@Override
	public ResponseEntity<BrandDto> getById(Long id) {
		Brand brand;
		brand  = bService.getById(id);
		return ResponseEntity.ok(mapper.toGetDtoEntity(brand));
	}

	@Override
	public ResponseEntity<List<BrandDto>> getPage(Integer page) {
		List<BrandDto> brandDtoList = bService.getPage(page).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());

		return ResponseEntity.ok(brandDtoList);
	}

	@Override
	public ResponseEntity<BrandDto> save(BrandDto dtoEntity) {
		Brand brand, savedBrand;
		brand  = mapper.toPostEntity(dtoEntity);
		savedBrand = bService.save(brand);
		return new ResponseEntity<BrandDto>(mapper.toGetDtoEntity(savedBrand), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<BrandDto> update(Long id, BrandDto dtoEntity) {
		dtoEntity.setId_brand(id);
		Brand brand, updatedBrand;
		brand = mapper.toPostEntity(dtoEntity);
		updatedBrand = bService.update(brand);
		return ResponseEntity.ok(mapper.toGetDtoEntity(updatedBrand));
	}

	@Override
	public void delete(Long id) {
		bService.delete(id);
	}

	@Override
	public ResponseEntity<List<BrandDto>> getAllByGivenName(Integer page, String name) {
		List<BrandDto> brandDtoList = bService.getBrandByGivenName(page, name).stream()
				.map(mapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(brandDtoList);
	}
}
