package com.spring.boot.controller.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.boot.model.OrgGroup;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "User", description = "User DTO")
public class UserDto {

	@JsonView(Views.Basic.class)
	private UUID id;

	@JsonView(Views.Basic.class)
	private String name;

	@JsonView(Views.Detail.class)
	private String email;

	@JsonView(Views.Detail.class)
	private Set<AccountDto> accounts = new HashSet<>();

	@JsonView(Views.Detail.class)
	private Set<OrgGroup> groups = new HashSet<>();
}
