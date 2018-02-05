package com.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.example.model.User;

public interface UserInterface extends JpaRepository<User, Long> {
	
	
}
