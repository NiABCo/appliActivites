package com.aelion.appliActivite.persistances.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name = "date_of_birth")
	private LocalDate dOB;
	
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="password")
	private String password;
	
	@Column(name="photo")
	private String photo;
	
	private List<Hobby> hobbies;

}
