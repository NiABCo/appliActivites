package com.aelion.appliActivite.dto.jwt;

import java.io.Serializable;

public class JWTRequest implements Serializable {

	
	private String mail;
	
	private String password;
	


	
	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/

	public JWTRequest() {
		super();
	}

	public JWTRequest(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	/***************************************************
	************* GETTERS / SETTERS *******************
	*****************************************************/
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
