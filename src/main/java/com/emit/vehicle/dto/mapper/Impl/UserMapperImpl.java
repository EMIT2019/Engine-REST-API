package com.emit.vehicle.dto.mapper.Impl;

import org.springframework.stereotype.Component;

import com.emit.vehicle.dto.UserDto;
import com.emit.vehicle.dto.mapper.UserMapper;
import com.emit.vehicle.model.User;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDto toDto(User entity) {
		UserDto userDto = new UserDto();
		userDto.setIdUser(entity.getIdUser());
		userDto.setName(entity.getName());
		userDto.setSurename(entity.getSurename());
		userDto.setUsername(entity.getUsername());
		userDto.setPassword(entity.getPassword());
		return userDto;
	}

	@Override
	public User toEntity(UserDto dto) {
		User user = new User();
		user.setIdUser(dto.getIdUser());
		user.setName(dto.getName());
		user.setSurename(dto.getSurename());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		return user;
	}

}
