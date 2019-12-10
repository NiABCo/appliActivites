package com.aelion.appliActivite.dto.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public JwtResponse() {
		super();
	}
	
	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
}
