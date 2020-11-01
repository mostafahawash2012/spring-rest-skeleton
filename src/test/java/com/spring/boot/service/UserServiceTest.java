package com.spring.boot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserServiceTest {

	private UUID userId = UUID.randomUUID();

	User user = new User();
	List<User> users = new ArrayList<>();
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@BeforeEach
	void setMockOutput() {
		user.setId(userId);
		user.setEmail("mostafa@gmail.com");
		user.setName("Moustafa HAWASH");

		Optional<User> userOptional = Optional.of(user);

		users.add(user);

		when(userRepository.findById(userId)).thenReturn(userOptional);
		when(userRepository.findAll()).thenReturn(users);
		when(userRepository.findAllByNameContainingIgnoreCase("Moustafa")).thenReturn(users);
	}

	@Test
	public void testGetUser() {
		assertEquals(user, userService.getUser(userId));
		verify(userRepository, times(1)).findById(userId);
	}

	@Test
	public void testGetAllUsers() {
		assertEquals(users, userService.getAllUsers(null));
		assertEquals(users, userService.getAllUsers("Moustafa"));
	}

	@Test
	public void testCreate() {
		userService.create(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void testUpdate() {
		userService.update(userId, user);
		verify(userRepository, times(1)).save(user);
	}
	
	@Test
	public void testDelete() {
		userService.delete(userId);
		verify(userRepository, times(1)).deleteById(userId);
	}
}
