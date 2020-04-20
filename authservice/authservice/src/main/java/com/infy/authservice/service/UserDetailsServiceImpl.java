package com.infy.authservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final List<User> listOfUsers = Arrays.asList(
				new User("srujan", encoder.encode("srujan"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))),
				new User("admin", encoder.encode("admin"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
		//Need to write in java 8
		for (User user : listOfUsers) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
			}
		}

		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
	
}
