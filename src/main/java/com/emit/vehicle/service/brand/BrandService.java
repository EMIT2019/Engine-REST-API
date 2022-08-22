package com.emit.vehicle.service.brand;

import java.util.List;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.service.BaseService;

public interface BrandService extends BaseService<Brand, Long> {
    List<Brand> getBrandByGivenName(Integer pageNumber, String brandName);
}
