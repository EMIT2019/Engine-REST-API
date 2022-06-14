package com.emit.vehicle.service.brand;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository bRepository; 

	@Override
	public List<Brand> getAllBrands() {
		return bRepository.findAll();
	}

	@Override
	public Brand getBrandById(Long id) {
		Optional<Brand> brand = bRepository.findById(id);
		
		if(brand.isPresent()) {
			return brand.get(); 
		}
		throw new RuntimeException("Brand with id "+id+" wasn't found");
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return bRepository.save(brand);
	}

	@Override
	public void deletebrand(Long id) {
		bRepository.deleteById(id);
	}

	@Override
	public Brand updateBrand(Brand brand) {
		return bRepository.save(brand);
	}

}
