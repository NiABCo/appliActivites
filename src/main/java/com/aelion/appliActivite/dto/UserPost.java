package com.aelion.appliActivite.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.aelion.appliActivite.persistances.entities.Hobby;

public class UserPost {

	@NotBlank
	private String lastname;
	
	@NotBlank
	private String firstname;
	
	@Email
	@NotBlank
	private String email;

	@Past
	private LocalDate birthDate;
	
	private String nickname;
	
	private List<Hobby> hobbies;


	private String description;
	
	@NotBlank
	private String password;
	
	private String photo;

	/**
	 * GETTERS / SETTERS
	 */
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "UserLightDTO [lastname=" + lastname + ", firstname=" + firstname + ", birthDate=" + birthDate
				+ ", nickname=" + nickname + ", hobbies=" + hobbies + ", description=" + description + ", password="
				+ password + ", photo=" + photo + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
}
