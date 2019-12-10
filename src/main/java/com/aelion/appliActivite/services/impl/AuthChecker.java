package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.aelion.appliActivite.exceptions.NotAuthorizedException;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IAuthChecker;
import com.aelion.appliActivite.services.IUserService;

@Component
public class AuthChecker implements IAuthChecker {

	@Autowired
	private IUserService userService;
	
	@Override
	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails ud = (UserDetails)principal;
			return userService.findByMail(ud.getUsername());
		} else {
			throw new NotAuthorizedException("NO CURRENT USER");
		}
	}
}
