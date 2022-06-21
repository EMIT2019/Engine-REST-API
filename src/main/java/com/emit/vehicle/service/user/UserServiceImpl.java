package com.emit.vehicle.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.User;
import com.emit.vehicle.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepository uRepository; 

	@Override
	public User saveNewUser(User user) {
		return uRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return uRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		uRepository.deleteById(id);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> user = uRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new RuntimeException("User with id "+id+" wasn't found");
	}

	@Override
	public User validateUser(User user) {
		return uRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public User validateUsername(String username) {
		return uRepository.findByUsername(username);
	}

}
