package com.aelion.appliActivite.persistances.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class ActivityHasUser {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (cascade = CascadeType.ALL )
	@JoinColumn (name = "user", referencedColumnName = "id")
	 private User user;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn (name = "id_status", nullable = false)
	private List<Status> status;
 
}
