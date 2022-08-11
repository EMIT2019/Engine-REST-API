package com.emit.vehicle.controller;

import com.emit.vehicle.dto.VehicleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/default")
public interface VehicleController extends BaseController<VehicleDto, Long> {
    @GetMapping("/getByBrand")
    ResponseEntity<List<VehicleDto>> getAllByGivenBrand(@RequestParam("brand") String brandName);

    @GetMapping("/getByModel")
    ResponseEntity<List<VehicleDto>> getAllByGivenModel(@RequestParam("model") String modelName);

    @GetMapping("/getByType")
    ResponseEntity<List<VehicleDto>> getAllByGivenType(@RequestParam("type") String typeName);

    @GetMapping("/getFasterThan")
    ResponseEntity<List<VehicleDto>> getAllByFasterThan(@RequestParam("speed") Long speed);

    @GetMapping("/getHPGreaterThan")
    ResponseEntity<List<VehicleDto>> getAllByHorsePowerGreaterThan(@RequestParam("horsepower") Long horsepower);
}
