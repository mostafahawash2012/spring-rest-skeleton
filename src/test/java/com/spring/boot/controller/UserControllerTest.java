package com.spring.boot.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.controller.dto.UserDto;
import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

	private static final String URL = "/user";
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	UserRepository userRepo;

	@Autowired
	MockMvc mvc;

	private User updatedUser;

	@BeforeEach
	public void setup() {
		updatedUser = new User();
		User newUser2 = new User();
		updatedUser = userRepo.save(updatedUser);
		newUser2 = userRepo.save(newUser2);
	}

	@Test
	public void testCreate() throws Exception {
		UserDto createdUser = new UserDto();
		createdUser.setName("user");
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.post(URL)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(createdUser)));
		result.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testCreateWithInvalidData() throws Exception {
		UserDto createdUser = new UserDto();
		createdUser.setName("user");
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.post(URL)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(null)));
		result.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testDelete() throws Exception {

		User newUser = new User();
		newUser = userRepo.save(newUser);
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.delete(URL + "/" + newUser.getId()));
		result.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testGetAllResources() throws Exception {

		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(URL));

		result.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.greaterThan(1)))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testUpdate() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.put(URL + "/" + updatedUser.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedUser)));

		result.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print());

	}
}
