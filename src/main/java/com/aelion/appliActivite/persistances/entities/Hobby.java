package com.aelion.appliActivite.persistances.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hobbies")
public class Hobby implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="label", nullable = false)
	private String label;
	
	
	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/
	
	public Hobby() {
		
	};
	
	public Hobby(Long id, String label) {
		this.id = id;
		this.label = label;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/******************************************
	************* METHODS *******************
	******************************************/
	@Override
	public String toString() {
		return "Hobby [id=" + id + ", label=" + label + "]";
	}
	
	
	
}
