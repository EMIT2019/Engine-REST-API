package com.emit.vehicle.service.brand;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emit.vehicle.dto.BrandDto;
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
	
	//Getting a range of records (JPA Pagination)
	@Override
	public List<Brand> getBrandPage(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return bRepository.findAll(page).getContent();
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
	
	public BrandDto castEntityToDto(Brand brand) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId_brand(brand.getId_brand());
		brandDto.setBrand_name(brand.getBrand_name());
		brandDto.setImg(brand.getImg());
		return brandDto;
	}
}
