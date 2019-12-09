package com.aelion.appliActivite.persistances.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="lastname",nullable = false)
	private String lastname;
	
	@Column(name="firstname", nullable = false)
	private String firstname;
	
	@Column(name="birth_date", nullable = false)
	private LocalDate birthDate;
	
	@Column(name="nickname", nullable = true)
	private String nickname;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_hobbie", nullable = false)
	private List<Hobby> hobbies;


	@Column(name="description", nullable = false)

	private String description;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name = "photo", nullable = true)
	private String photo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_sender", nullable = false)
	private List<Message> sendMsg;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_receiver", nullable = false)
	private List<Message> receivedMsg;
	


	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/
	
	public User() {
		
	}
	
	public User(Long id, String lastname, String firstName, LocalDate birthDate, String nickname, List<Hobby> hobbies,
			String description, String password, String photo) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstName;
		this.birthDate = birthDate;
		this.nickname = nickname;
		this.hobbies = hobbies;
		this.description = description;
		this.password = password;
		this.photo = photo;
	}

	/***************************************************
	************* GETTERS / SETTERS *******************
	*****************************************************/

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return this.lastname;
	}
	public void setName(String name) {
		this.lastname = name;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
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
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	/******************************************
	************* METHODS *******************
	******************************************/
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + lastname + ", firstName=" + firstname + ", birthDate=" + birthDate
				+ ", nickname=" + nickname + ", hobbies=" + hobbies + ", description=" + description + ", password="
				+ password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
