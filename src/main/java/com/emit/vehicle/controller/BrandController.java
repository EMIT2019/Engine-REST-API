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

import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.dto.mapper.BrandMapper;
import com.emit.vehicle.dto.mapper.Impl.BrandMapperImpl;
import com.emit.vehicle.service.brand.BrandService;

@RequestMapping("/brands")
@RestController
public class BrandController {
	
	@Autowired
	private BrandService bService; 
	
	private BrandMapper mapper = new BrandMapperImpl(); 
	
	@GetMapping("/all-brands")
	public ResponseEntity<List<BrandDto>> getAllBrands(){
		return new ResponseEntity<List<BrandDto>>(bService.getAllBrands().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("/brand-page")
	public ResponseEntity<List<BrandDto>> getBrandPage(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize){
		return new ResponseEntity<List<BrandDto>>(bService.getBrandPage(pageNumber, pageSize).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList())
				, HttpStatus.OK);
	}
	
	@GetMapping("/get-brand")
	public ResponseEntity<BrandDto> getBrandById(@RequestParam("idBrand") Long id){
		return new ResponseEntity<BrandDto>(mapper.toDto(bService.getBrandById(id)), HttpStatus.OK);
	}
	
	@PostMapping("/save-brand")
	public ResponseEntity<BrandDto> saveBrand(@RequestBody BrandDto brandDto) {
		bService.saveBrand(mapper.toEntity(brandDto));
		return new ResponseEntity<BrandDto>(brandDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-brand")
	public ResponseEntity<BrandDto> updateBrand(@RequestParam("idBrand") Long id, @RequestBody BrandDto brandDto) {
		brandDto.setId_brand(id);
		bService.updateBrand(mapper.toEntity(brandDto));
		return new ResponseEntity<BrandDto>(brandDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-brand")
	public ResponseEntity<HttpStatus> deleteBrand(@RequestParam("idBrand") Long id) {
		bService.deletebrand(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
