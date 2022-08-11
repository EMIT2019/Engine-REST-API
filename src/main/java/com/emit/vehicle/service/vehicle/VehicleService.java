package com.emit.vehicle.service.vehicle;

import java.util.List;

import com.emit.vehicle.service.BaseService;

import com.emit.vehicle.model.Vehicle;

public interface VehicleService extends BaseService<Vehicle, Long> {
    List<Vehicle> getAllByGivenBrand(String brandName);

    List<Vehicle> getAllByGivenModel(String modelName);

    List<Vehicle> getAllByGivenType(String typeName);

    List<Vehicle> getAllByGivenSpeed(Long topSpeed);
}
