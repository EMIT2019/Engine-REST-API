package com.emit.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.service.brand.BrandService;

@RestController
public class BrandController {
	
	@Autowired
	private BrandService bService; 
	
	@GetMapping("/brands")
	public List<Brand> getAllBrands(){
		return bService.getAllBrands();
	}
	
	@GetMapping("/brand")
	public Brand getBrandById(@RequestParam("idBrand") Long id){
		return bService.getBrandById(id);
	}
	
	@PostMapping("/brand")
	public Brand saveBrand(@RequestBody Brand brand) {
		return bService.saveBrand(brand);
	}
	
	@PutMapping("/brand")
	public Brand updateBrand(@RequestParam("idBrand") Long id, @RequestBody Brand brand) {
		brand.setId_brand(id);
		return bService.updateBrand(brand);
	}
	
	@DeleteMapping("/brand")
	public void deleteBrand(@RequestParam("idBrand") Long id) {
		bService.deletebrand(id);
	}
}
