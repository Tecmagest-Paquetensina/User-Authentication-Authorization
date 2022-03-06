package com.projetoapi.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoapi.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
