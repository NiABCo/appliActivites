package com.aelion.appliActivite.dto;

import java.io.Serializable;

public class JWTResponse implements Serializable{
	
	private String response;
	
	
	/********************************
	 *********CONSTRUCTORS**********
	 *******************************/

	public JWTResponse() {}
	public JWTResponse(String response) {
		super();
		this.response = response;
	}
	
	/********************************
	 *******GETTERS & SETTERS********
	 *******************************/
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
