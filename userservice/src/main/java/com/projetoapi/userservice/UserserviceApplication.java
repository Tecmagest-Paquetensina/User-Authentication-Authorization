package com.projetoapi.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projetoapi.userservice.domain.Role;
import com.projetoapi.userservice.domain.User;
import com.projetoapi.userservice.service.UserService;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_GENERAL_ADMIN"));
						
			userService.saveUser(new User(null, "Abigail Paquete", "abip", "A@123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Josiane Paquete", "josi", "J@123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Igor Paquete", "igorp", "I@123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Rosana Ferreira", "rosana", "R@123456", new ArrayList<>()));
			
			userService.addRoleToUser("abi", "ROLE_USER");
			userService.addRoleToUser("abi", "ROLE_MANAGER");
			userService.addRoleToUser("rosana", "ROLE_MANAGER");
			userService.addRoleToUser("Josi", "ROLE_ADMIN");
			userService.addRoleToUser("igorp", "ROLE_USER");
			userService.addRoleToUser("igorp", "ROLE_ADMIN");
			userService.addRoleToUser("igorp", "ROLE_GENERAL_ADMIN");
		};
	}
}
