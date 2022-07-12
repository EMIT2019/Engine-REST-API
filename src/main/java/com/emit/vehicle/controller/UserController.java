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

import com.emit.vehicle.dto.UserDto;
import com.emit.vehicle.dto.mapper.Impl.UserMapper;
import com.emit.vehicle.dto.mapper.Impl.UserMapperImpl;
import com.emit.vehicle.service.user.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService uService; 
	
	private UserMapper mapper = new UserMapperImpl();
	
	@GetMapping("/get-user")
	public ResponseEntity<UserDto> getUserById(@RequestParam("idUser") Long id) {
		return new ResponseEntity<UserDto>(mapper.toDto(uService.getUserById(id)), HttpStatus.OK);
	}
	
	@PostMapping("/new-user")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {
		if(uService.validateUsername(mapper.toEntity(userDto).getUsername()) != null) {
			throw new RuntimeException("The username you typed is already in use");
		}else {			
			uService.saveNewUser(mapper.toEntity(userDto));
			return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/check-user")
	public ResponseEntity<UserDto> validateUser(@RequestBody UserDto userDto) {
		uService.validateUser(mapper.toEntity(userDto));
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<UserDto> updateUser(@RequestParam("idUser") Long id, @RequestBody UserDto userDto) {
		userDto.setIdUser(id);
		uService.updateUser(mapper.toEntity(userDto));
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<HttpStatus> deleteUser(@RequestParam("idUser") Long id) {
		uService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
