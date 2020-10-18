package com.spring.boot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.boot.controller.dto.UserDto;
import com.spring.boot.controller.dto.Views;
import com.spring.boot.controller.mapper.EntityMapper;
import com.spring.boot.exception.MissingDataException;
import com.spring.boot.model.User;
import com.spring.boot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/user")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EntityMapper<User, UserDto> userMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Detail.class)
	public UserDto create(@RequestBody final UserDto userDto) {

		if (userDto != null) {
			User createdUser = userService.create(userMapper.toEntity(userDto));
			return userMapper.toDto(createdUser);
		} else {
			throw new MissingDataException("You have to provied a valid resource");
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(
			@ApiParam(value = "Id of user", type = "string", allowMultiple = false) @PathVariable final UUID id) {
		userService.delete(id);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(Views.Basic.class)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "get all users")
	public List<UserDto> getAllUsers(@RequestParam(required = false) final String name) {

		return userMapper.toDto(userService.getAllUsers(name));
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(Views.Detail.class)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "get user")
	public UserDto getUser(
			@ApiParam(value = "Id of user", type = "string", allowMultiple = false) @PathVariable final UUID id) {
		return userMapper.toDto(userService.getUser(id));
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "update user")
	public UserDto update(
			@ApiParam(value = "Id of user", type = "string", allowMultiple = false) @PathVariable final UUID id,
			@RequestBody final UserDto userDto) {

		return userMapper.toDto(userService.update(id, userMapper.toEntity(userDto)));
	}

}
