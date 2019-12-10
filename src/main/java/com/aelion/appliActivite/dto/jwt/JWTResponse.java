package com.aelion.appliActivite.dto.jwt;

import java.io.Serializable;

public class JWTResponse implements Serializable {

	
	private String token;
	
	public JWTResponse() {
		super();
	};
	
	
	public JWTResponse(String token) {
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
