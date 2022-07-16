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

	private final BrandRepository bRepository;

	public BrandServiceImpl(BrandRepository brandRepository){
		this.bRepository = brandRepository;
	}

	@Override
	public List<Brand> getAll() {
		return bRepository.findAll();
	}

	@Override
	public Brand getById(Long id) {
		Optional<Brand> brand = bRepository.findById(id);

		if(brand.isPresent()){
			return brand.get();
		}

		throw new RuntimeException("The item with id "+id+" doesn't exists.");
	}

	@Override
	public Brand save(Brand entity) {
		return bRepository.save(entity);
	}

	@Override
	public Brand update(Brand entity) {
		return bRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		bRepository.deleteById(id);
	}

	@Override
	public List<Brand> getPage(Integer pageNumber, Integer pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return bRepository.findAll(page).getContent();
	}
}
