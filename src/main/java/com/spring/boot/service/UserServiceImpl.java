package com.spring.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.RecordNotFoundException;
import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(UUID id, User user) {
		Optional<User> updateUser = userRepository.findById(id);
		if (updateUser.isPresent()) {
			user.setId(id);
			return userRepository.save(user);
		} else {
			throw new RecordNotFoundException("User not found Id = " + id);
		}
	}

	@Override
	public void delete(UUID id) {
		Optional<User> deleteUser = userRepository.findById(id);
		if (deleteUser.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("User not found Id = " + id);
		}

	}

	@Override
	public User getUser(UUID id) {
		Optional<User> findUser = userRepository.findById(id);
		if (findUser.isPresent()) {
			return findUser.get();
		} else {
			throw new RecordNotFoundException("User not found Id = " + id);
		}
	}

	@Override
	public List<User> getAllUsers(String name) {
		if (name != null) {
			return userRepository.findAllByNameContainingIgnoreCase(name);
		} else {
			return userRepository.findAll();
		}
	}

}
