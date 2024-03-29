package com.emit.vehicle.dto.mapper.Impl;

import com.emit.vehicle.model.ModelEntity;
import org.springframework.stereotype.Component;

import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.dto.mapper.BrandMapper;
import com.emit.vehicle.model.Brand;

@Component
public class BrandMapperImpl implements BrandMapper {

	@Override
	public BrandDto toGetDtoEntity(Brand entity) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId_brand(entity.getId_brand());
		brandDto.setBrand_name(entity.getBrand_name());
		brandDto.setImg(entity.getImg());
		return brandDto;
	}

	@Override
	public Brand toPostEntity(BrandDto dto) {
		Brand brand = new Brand();
		brand.setId_brand(dto.getId_brand());
		brand.setBrand_name(dto.getBrand_name());
		brand.setImg(dto.getImg());;
		return brand;
	}
}
