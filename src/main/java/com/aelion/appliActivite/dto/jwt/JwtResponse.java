package com.aelion.appliActivite.dto.jwt;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private Collection<? extends GrantedAuthority> roles;

	public JwtResponse(String token, Collection<? extends GrantedAuthority> collection) {
		super();
		this.token = token;
		this.roles = collection;
	};

	

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}



	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
