package com.spring.boot.service;

import java.util.List;
import java.util.UUID;

import com.spring.boot.model.User;

public interface UserService {

	User create(final User user);

	User update(final UUID id, final User user);

	void delete(final UUID id);

	User getUser(final UUID id);

	List<User> getAllUsers(final String name);
}
