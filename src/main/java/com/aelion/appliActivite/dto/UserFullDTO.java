package com.aelion.appliActivite.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.aelion.appliActivite.persistances.entities.Hobby;
import com.aelion.appliActivite.persistances.entities.Message;

public class UserFullDTO {

	private String lastname;
	
	private String firstname;


	private LocalDate birthDate;
	
	private String nickname;
	
	private List<Hobby> hobbies;


	private String description;
	
	private String password;
	
	private String photo;

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
	
	@Override
	public String toString() {
		return "UserLightDTO [lastname=" + lastname + ", firstname=" + firstname + ", birthDate=" + birthDate
				+ ", nickname=" + nickname + ", hobbies=" + hobbies + ", description=" + description + ", password="
				+ password + ", photo=" + photo + ", sendMsg=" + sendMsg + ", receivedMsg=" + receivedMsg + "]";
	}


	
	
	
}
