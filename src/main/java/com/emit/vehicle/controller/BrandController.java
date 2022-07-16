package com.emit.vehicle.controller;

import com.emit.vehicle.dto.BrandDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BrandController extends BaseController<BrandDto, Long> {

}
