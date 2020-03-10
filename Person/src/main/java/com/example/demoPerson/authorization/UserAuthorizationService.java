package com.example.demoPerson.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demoPerson.user.IUserRepository;
import com.example.demoPerson.user.User;

public class UserAuthorizationService implements UserDetailsService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElseThrow(() -> new RuntimeException());
		if(user == null) { throw new UsernameNotFoundException(username + " not found");}
		return new AuthorizedUser(user);
	}

}
