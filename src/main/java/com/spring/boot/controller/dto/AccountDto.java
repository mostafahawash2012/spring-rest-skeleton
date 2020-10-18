package com.spring.boot.controller.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.boot.model.AccountTypesEnum;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "account", description = "account DTO")
public class AccountDto {

	@JsonView(Views.Basic.class)
	private UUID Id;
	@JsonView(Views.Detail.class)
	private String login;
	@JsonView(Views.Detail.class)
	private AccountTypesEnum type;
}
