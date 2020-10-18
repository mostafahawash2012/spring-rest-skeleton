package com.spring.boot.controller.mapper;

import org.springframework.stereotype.Component;

import com.spring.boot.controller.dto.AccountDto;
import com.spring.boot.model.Account;

@Component
public class AccountMapper implements EntityMapper<Account, AccountDto> {

	@Override
	public AccountDto toDto(Account entity) {
		AccountDto dto = new AccountDto();
		dto.setId(entity.getId());
		dto.setLogin(entity.getLogin());
		return dto;
	}

	@Override
	public Account toEntity(AccountDto dto) {
		Account entity = new Account();
		entity.setId(dto.getId());
		entity.setLogin(dto.getLogin());

		return entity;
	}

}
