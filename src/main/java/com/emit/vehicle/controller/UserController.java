package com.emit.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.vehicle.model.User;
import com.emit.vehicle.service.user.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService; 
	
	@GetMapping("/user")
	public User getUserById(@RequestParam("idUser") Long id) {
		return uService.getUserById(id);
	}
	
	@PostMapping("/new_user")
	public User saveUser(@RequestBody User user) {
		return uService.saveNewUser(user);
	}
	
	@PostMapping("/check_user")
	public User validateUser(@RequestBody User user) {
		return uService.validateUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestParam("idUser") Long id, @RequestBody User user) {
		user.setIdUser(id);
		return uService.updateUser(user);
	}
	
	@DeleteMapping("/user")
	public void deleteUser(@RequestParam("idUser") Long id) {
		uService.deleteUser(id);
	}
}
