package com.emit.vehicle.controller.Impl;

import javax.validation.Valid;

import com.emit.vehicle.controller.UserController;
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
import com.emit.vehicle.dto.mapper.UserMapper;
import com.emit.vehicle.dto.mapper.Impl.UserMapperImpl;
import com.emit.vehicle.service.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserControllerImpl implements UserController {

    private final UserService uService;

    private final UserMapper mapper;

    public UserControllerImpl(UserService userService, UserMapper userMapper){
        this.uService = userService;
        this.mapper = userMapper;
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtoList = uService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtoList);
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id) {
        return ResponseEntity.ok(
                mapper.toDto(
                        uService.getById(id)
                )
        );
    }

    @Override
    public ResponseEntity<List<UserDto>> getPage(Integer page, Integer records) {
        List<UserDto> userDtoList = uService.getPage(page, records).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtoList);
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto dtoEntity) {
        return new ResponseEntity<UserDto>(
                mapper.toDto(
                        uService.save(
                                mapper.toEntity(dtoEntity)
                        )
                ),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<UserDto> update(Long id, UserDto dtoEntity) {
        dtoEntity.setIdUser(id);
        return new ResponseEntity<UserDto>(
                mapper.toDto(
                        uService.save(
                                mapper.toEntity(dtoEntity)
                        )
                ),
                HttpStatus.OK
        );
    }

    @Override
    public void delete(Long id) {
        uService.delete(id);
    }
}
