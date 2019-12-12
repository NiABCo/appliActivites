package com.aelion.appliActivite.services.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IUserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 * Here we are using dummy data, you need to load user data from database or
		 * other third party application
		 */
		User user = userService.findByMail(username);
		
		UserBuilder builder = null;
		if (user != null) {
			
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			builder.roles(user.getRole());
			
			
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}