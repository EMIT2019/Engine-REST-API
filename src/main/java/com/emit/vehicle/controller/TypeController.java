package com.emit.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.service.type.TypeService;

@RequestMapping("/types")
@RestController
public class TypeController {
	
	@Autowired
	private TypeService tService; 
	
	@GetMapping("/all-types")
	public ResponseEntity<List<Type>> getAllTypes(){
		return new ResponseEntity<List<Type>>(tService.getAllTypes(), HttpStatus.OK);
	}
	
	@GetMapping("/get-type")
	public ResponseEntity<Type> getTypeById(@RequestParam("idType") Long id) {
		return new ResponseEntity<Type>(tService.getTypeById(id), HttpStatus.OK);
	}
	
	@PostMapping("/save-type")
	public ResponseEntity<Type> saveType(@RequestBody Type type) {
		return new ResponseEntity<Type>(tService.saveType(type), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-type")
	public ResponseEntity<Type> updateType(@RequestParam("idType") Long id, @RequestBody Type type) {
		type.setId_type(id);
		return new ResponseEntity<Type>(tService.updateType(type), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-type")
	public ResponseEntity<HttpStatus> deleteType(@RequestParam("idType") Long id) {
		tService.deleteType(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
