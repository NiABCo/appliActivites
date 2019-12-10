package com.aelion.appliActivite.dto;

import java.time.LocalDate;
import java.util.List;

import com.aelion.appliActivite.persistances.entities.Hobby;
import com.aelion.appliActivite.persistances.entities.Message;

public class UserFullDTO {

	private String lastname;
	
	private String firstname;
	
	private String email;

	private LocalDate birthDate;
	
	private String nickname;
	
	private List<Hobby> hobbies;

	private String description;
	
	private String password;
	
	private String photo;
	
	private String email;

	private List<Message> sendMsg;

	private List<Message> receivedMsg;

	public UserFullDTO() {}
	public UserFullDTO(String lastname, String firstname, LocalDate birthDate, String nickname, List<Hobby> hobbies,
			String description, String password, String photo, List<Message> sendMsg, List<Message> receivedMsg) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthDate = birthDate;
		this.nickname = nickname;
		this.hobbies = hobbies;
		this.description = description;
		this.password = password;
		this.photo = photo;
		this.sendMsg = sendMsg;
		this.receivedMsg = receivedMsg;
	}
	
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Message> getSendMsg() {
		return sendMsg;
	}
	public void setSendMsg(List<Message> sendMsg) {
		this.sendMsg = sendMsg;
	}
	public List<Message> getReceivedMsg() {
		return receivedMsg;
	}
	public void setReceivedMsg(List<Message> receivedMsg) {
		this.receivedMsg = receivedMsg;
	}
	@Override
	public String toString() {
		return "UserLightDTO [lastname=" + lastname + ", firstname=" + firstname + ", birthDate=" + birthDate
				+ ", nickname=" + nickname + ", hobbies=" + hobbies + ", description=" + description + ", password="
				+ password + ", photo=" + photo + ", sendMsg=" + sendMsg + ", receivedMsg=" + receivedMsg + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
}
