package com.emit.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.service.type.TypeService;

@RestController
public class TypeController {
	
	@Autowired
	private TypeService tService; 
	
	@GetMapping("/types")
	public List<Type> getAllTypes(){
		return tService.getAllTypes();
	}
	
	@GetMapping("/type")
	public Type getTypeById(@RequestParam("idType") Long id) {
		return tService.getTypeById(id);
	}
	
	@PostMapping("/type")
	public Type saveType(@RequestBody Type type) {
		return tService.saveType(type);
	}
	
	@PutMapping("/type")
	public Type updateType(@RequestParam("idType") Long id, @RequestBody Type type) {
		type.setId_type(id);
		return tService.updateType(type);
	}
	
	@DeleteMapping("/type")
	public void deleteType(@RequestParam("idType") Long id) {
		tService.deleteType(id);
	}
}
