package com.aelion.appliActivite.persistances.enteties;

import java.time.LocalDateTime;

public class Message {

	private String title;
	
	private String body;
	
	private LocalDateTime sendTime;
	
	private String status;

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
