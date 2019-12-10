package com.aelion.appliActivite.dto;

public class UserLightDTO {

	private String lastname;
	private String email;
	
	/*******************************
	 * *******CONSTRUCTORS**********
	 * *****************************
	 *******************************/
	
	public UserLightDTO() {};
	
	
	public UserLightDTO(String lastname, String email) {
		super();
		this.lastname = lastname;
		this.email = email;
	}
	
	
	
	/*******************************
	 *****GETTERS & SETTERS*********
	 *******************************
	 *******************************/
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	/*******************************
	 * ********METHODS**************
	 * *****************************
	 *******************************/
	
	@Override
	public String toString() {
		return "UserLightDTO [lastname=" + lastname + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
}
