package com.aelion.appliActivite.persistances.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "messages")
public class Message implements Serializable{
  
	
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "body", nullable = false)
	private String body;

	@Column(name = "send_time", nullable = false)
	private LocalDateTime sendTime;

	@Column(name = "status", nullable = true)
	private String status;

	
	

	/****************************************
	 ******* CONSTRUCTORS *******************
	 ***************************************/

	public Message() {};
	
	public Message(Long id, String title, String body, LocalDateTime sendTime, String status) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.sendTime = sendTime;
		this.status = status;
	}
	

	/***************************************************
	 ************* GETTERS / SETTERS *******************
	 *****************************************************/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getSendTime() {
		return sendTime;
	}

	public void setSendTime(LocalDateTime sendTime) {
		this.sendTime = sendTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/******************************************
	 ************* METHODS *******************
	 ******************************************/

	@Override
	public String toString() {
		return "Message [title=" + title + ", body=" + body + ", sendTime=" + sendTime + ", status=" + status + "]";
	}

}
