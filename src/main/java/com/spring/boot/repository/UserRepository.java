package com.spring.boot.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	List<User> findAllByNameContainingIgnoreCase(final String name);
}
