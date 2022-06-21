package com.emit.vehicle.controller;

import javax.validation.Valid;

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

import com.emit.vehicle.model.User;
import com.emit.vehicle.service.user.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService uService; 
	
	@GetMapping("/get-user")
	public ResponseEntity<User> getUserById(@RequestParam("idUser") Long id) {
		return new ResponseEntity<User>(uService.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping("/new-user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		if(uService.validateUsername(user.getUsername()) != null) {
			throw new RuntimeException("The username you typed is already in use");
		}else {			
			return new ResponseEntity<User>(uService.saveNewUser(user), HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/check-user")
	public ResponseEntity<User> validateUser(@RequestBody User user) {
		return new ResponseEntity<User>(uService.validateUser(user), HttpStatus.OK);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestParam("idUser") Long id, @RequestBody User user) {
		user.setIdUser(id);
		return new ResponseEntity<User>(uService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<HttpStatus> deleteUser(@RequestParam("idUser") Long id) {
		uService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
