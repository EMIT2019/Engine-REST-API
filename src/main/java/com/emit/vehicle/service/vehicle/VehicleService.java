package com.emit.vehicle.service.vehicle;

import java.util.List;

import com.emit.vehicle.service.BaseService;

import com.emit.vehicle.model.Vehicle;
import org.springframework.data.domain.Pageable;

public interface VehicleService extends BaseService<Vehicle, Long> {
    List<Vehicle> getAllByGivenBrand(Integer pageNumber, String brandKey);

    List<Vehicle> getAllByGivenModel(Integer pageNumber, String modelName);

    List<Vehicle> getAllByGivenType(Integer pageNumber, String typeKey);

    List<Vehicle> getAllByFasterThan(Integer pageNumber, Long topSpeed);

    List<Vehicle> getAllByHorsePowerGreaterThan(Integer pageNumber, Long horsepower);

    List<Vehicle> globalVehicleSearch(Integer pageNumber, String searchParams);

    Pageable pageableBuilder(Integer pageNumber, Integer pageSize);
}
