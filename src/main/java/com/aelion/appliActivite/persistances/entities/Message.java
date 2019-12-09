package com.aelion.appliActivite.persistances.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="messages")
public class Message {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "name")
	private String body;
	
	@Column(name = "send_time")
	private LocalDateTime sendTime;
	
	@Column(name = "status")
	private String status;
	
	/*
	 * ********************
	 * Constructors
	 * ********************
	 */
	
	public Message() {}
	public Message(Long id, String title, String body, LocalDateTime sendTime, String status) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.sendTime = sendTime;
		this.status = status;
	}
	
	
	/*
	 * ********************
	 * getters & setters
	 * ********************
	 */
	
	
	

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

	@Override
	public String toString() {
		return "Message [title=" + title + ", body=" + body + ", sendTime=" + sendTime + ", status=" + status + "]";
	}
	
	
}
