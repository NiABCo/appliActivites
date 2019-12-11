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
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Transient
	private String[] roles = {
			"user","usermodo", "usermodoadmin"
	};
	
	
	
	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_hobbie", nullable = false)
	private List<Hobby> hobbies;

	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name = "photo", nullable = true)
	private String photo;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_sender", nullable = false)
	private List<Message> sendMsg;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_receiver", nullable = false)
	private List<Message> receivedMsg;
	
	@Column(name="role", nullable = false)
	private String role;


	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/
	
	public User() {
		
	}
	
	public User(Long id, String lastname, String firstName, LocalDate birthDate, String nickname, List<Hobby> hobbies,
			String description, String password, String photo, String email) {
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
		this.email = email;
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
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//Setter and Getter for the role, user by default

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = this.getRoles()[0];
	}

	/******************************************
	************* METHODS *******************
	******************************************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((receivedMsg == null) ? 0 : receivedMsg.hashCode());
		result = prime * result + ((sendMsg == null) ? 0 : sendMsg.hashCode());
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
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (receivedMsg == null) {
			if (other.receivedMsg != null)
				return false;
		} else if (!receivedMsg.equals(other.receivedMsg))
			return false;
		if (sendMsg == null) {
			if (other.sendMsg != null)
				return false;
		} else if (!sendMsg.equals(other.sendMsg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", birthDate=" + birthDate
				+ ", nickname=" + nickname + ", hobbies=" + hobbies + ", email=" + email + ", description="
				+ description + ", password=" + password + ", photo=" + photo + ", sendMsg=" + sendMsg
				+ ", receivedMsg=" + receivedMsg + "]";
	}
	
	
	/*
	public enum Role {  
		  
	    ADMIN("Admin"), USER("User"), MODO("Moderateur");  
	      
	     private String abreviation ;  
	      
	     private Role(String abreviation) {  
	         this.abreviation = abreviation ;  
	    }  
	      
	     public String getRole() {  
	         return  this.abreviation ;  
	    }  
	}
	
	*/
	

}


