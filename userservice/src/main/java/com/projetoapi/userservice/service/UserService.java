package com.projetoapi.userservice.service;

import com.projetoapi.userservice.domain.Role;
import com.projetoapi.userservice.domain.User;

import java.util.List;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String userName, String roleName);
	User getUser(String userName);
	List<User>getUsers();
}
