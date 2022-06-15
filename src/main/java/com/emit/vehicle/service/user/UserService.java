package com.emit.vehicle.service.user;

import com.emit.vehicle.model.User;

public interface UserService {
	User getUserById(Long id);
	
	User validateUser(User user);
	
	User saveNewUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id); 
}
