package com.aelion.appliActivite.persistances.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")

public class Status implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name="date", nullable =false)
	private LocalDateTime date;

	@Column(name="reason", nullable = true)
	private String reasonWhy;
	
	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/
	
	public Status() {
		
	}

	public Status(Long id, LocalDateTime date, String reasonWhy) {
		super();
		this.id = id;
		this.date = date;
		this.reasonWhy = reasonWhy;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getReasonWhy() {
		return reasonWhy;
	}

	public void setReasonWhy(String reasonWhy) {
		this.reasonWhy = reasonWhy;
	}

	
	/******************************************
	************* METHODS *******************
	******************************************/
	@Override
	public String toString() {
		return "Status [id=" + id + ", date=" + date + ", reasonWhy=" + reasonWhy + "]";
	}

}
