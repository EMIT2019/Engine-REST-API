package com.emit.vehicle.controller;

import com.emit.vehicle.dto.VehicleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/default")
public interface VehicleController extends BaseController<VehicleDto, Long> {
    @GetMapping("/search/getByBrand")
    ResponseEntity<List<VehicleDto>> getAllByGivenBrand(@RequestParam("page") Integer page, @RequestParam("brand") String brandName);

    @GetMapping("/search/getByModel")
    ResponseEntity<List<VehicleDto>> getAllByGivenModel(@RequestParam("page") Integer page, @RequestParam("model") String modelName);

    @GetMapping("/search/getByType")
    ResponseEntity<List<VehicleDto>> getAllByGivenType(@RequestParam("page") Integer page, @RequestParam("type") String typeName);

    @GetMapping("/search/getFasterThan")
    ResponseEntity<List<VehicleDto>> getAllByFasterThan(@RequestParam("page") Integer page, @RequestParam("speed") Long speed);

    @GetMapping("/search/getHPGreaterThan")
    ResponseEntity<List<VehicleDto>> getAllByHorsePowerGreaterThan(@RequestParam("page") Integer page, @RequestParam("horsepower") Long horsepower);
}
