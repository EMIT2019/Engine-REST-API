package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emit.vehicle.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//Validate user when trying to log in 
	User findByUsernameAndPassword(String username, String password);
	
	//Validate user when signing up
	User findByUsername(String username);
}
