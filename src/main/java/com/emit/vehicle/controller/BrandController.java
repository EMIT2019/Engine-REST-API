package com.emit.vehicle.controller;

import java.util.List;

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

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.service.brand.BrandService;

@RequestMapping("/brands")
@RestController
public class BrandController {
	
	@Autowired
	private BrandService bService; 
	
	@GetMapping("/all-brands")
	public ResponseEntity<List<Brand>> getAllBrands(){
		return new ResponseEntity<List<Brand>>(bService.getAllBrands(), HttpStatus.OK);
	}
	
	@GetMapping("/get-brand")
	public ResponseEntity<Brand> getBrandById(@RequestParam("idBrand") Long id){
		return new ResponseEntity<Brand>(bService.getBrandById(id), HttpStatus.OK);
	}
	
	@PostMapping("/save-brand")
	public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
		return new ResponseEntity<Brand>(bService.saveBrand(brand), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-brand")
	public ResponseEntity<Brand> updateBrand(@RequestParam("idBrand") Long id, @RequestBody Brand brand) {
		brand.setId_brand(id);
		return new ResponseEntity<Brand>(bService.updateBrand(brand), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-brand")
	public ResponseEntity<HttpStatus> deleteBrand(@RequestParam("idBrand") Long id) {
		bService.deletebrand(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
