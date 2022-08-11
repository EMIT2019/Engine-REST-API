package com.emit.vehicle.controller;

import com.emit.vehicle.dto.BrandDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/default")
public interface BrandController extends BaseController<BrandDto, Long> {
    @GetMapping("/getByName")
    ResponseEntity<List<BrandDto>> getAllByGivenName(@RequestParam("name") String name);
}
