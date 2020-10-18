package com.spring.boot.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.controller.dto.AccountDto;
import com.spring.boot.controller.dto.UserDto;
import com.spring.boot.model.Account;
import com.spring.boot.model.User;

@Component
public class UserMapper implements EntityMapper<User, UserDto> {

	@Autowired
	private EntityMapper<Account, AccountDto> accountmapper;

	@Override
	public UserDto toDto(User entity) {
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setGroups(entity.getGroups());
		entity.getAccounts().forEach(account -> dto.getAccounts().add(accountmapper.toDto(account)));
		return dto;
	}

	@Override
	public User toEntity(UserDto dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setGroups(dto.getGroups());
		dto.getAccounts().forEach(accountDto -> entity.getAccounts().add(accountmapper.toEntity(accountDto)));
		return entity;
	}

}
