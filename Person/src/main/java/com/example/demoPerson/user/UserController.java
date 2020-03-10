package com.example.demoPerson.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {
	
	@Autowired
	IUserRepository userRepository;
	
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}	
}
