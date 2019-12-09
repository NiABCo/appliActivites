package com.aelion.appliActivite.dto;

public class UserLightDTO {

	private String lastname;
	private String mail;
	
	/*******************************
	 * *******CONSTRUCTORS**********
	 * *****************************
	 *******************************/
	
	public UserLightDTO() {}
	public UserLightDTO(String lastname, String mail) {
		super();
		this.lastname = lastname;
		this.mail = mail;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	/*******************************
	 * ********METHODS**************
	 * *****************************
	 *******************************/
	
	@Override
	public String toString() {
		return "UserLightDTO [lastname=" + lastname + ", mail=" + mail + "]";
	}
	
	
	
	
	
	
	
	
	
}
