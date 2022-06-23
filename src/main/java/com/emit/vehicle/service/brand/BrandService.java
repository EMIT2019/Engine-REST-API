package com.emit.vehicle.service.brand;

import java.util.List;

import com.emit.vehicle.model.Brand;

public interface BrandService {
	List<Brand> getAllBrands();
	
	List<Brand> getBrandPage(int pageNumber, int pageSize);
	
	Brand getBrandById(Long id);
	
	Brand saveBrand(Brand brand); 
	
	void deletebrand(Long id); 
	
	Brand updateBrand(Brand brand); 
}
