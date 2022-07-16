package com.emit.vehicle.controller;

import com.emit.vehicle.dto.BrandDto;
import com.emit.vehicle.dto.DtoEntity;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface BaseController<T extends DtoEntity, ID> {

    @GetMapping("/get-all")
    ResponseEntity<List<T>> getAll();

    @GetMapping("/getById")
    ResponseEntity<T> getById(@RequestParam("id") ID id);

    @GetMapping("/page/{page}/{records}")
    ResponseEntity<List<T>> getPage(@PathVariable Integer page, @PathVariable Integer records);

    @PostMapping("/save")
    ResponseEntity<T> save(@RequestBody T dtoEntity);

    @PutMapping("/update")
    ResponseEntity<T> update(@RequestParam("id") ID id,@RequestBody T dtoEntity);

    @DeleteMapping("/delete")
    void delete(@RequestParam("id") ID id);
}
