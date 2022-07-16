package com.emit.vehicle.service.brand;

import java.util.List;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.service.BaseService;

public interface BrandService<ID> extends BaseService<Brand, Long> {
    List<Brand> getPage(ID pageNumber, ID pageSize);
}
