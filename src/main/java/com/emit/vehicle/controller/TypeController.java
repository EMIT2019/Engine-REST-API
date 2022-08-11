package com.emit.vehicle.controller;

import com.emit.vehicle.dto.TypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/default")
public interface TypeController extends BaseController<TypeDto, Long> {
    @GetMapping("/getByName")
    ResponseEntity<List<TypeDto>> getAllByGivenName(@RequestParam("name") String typeName);
}
