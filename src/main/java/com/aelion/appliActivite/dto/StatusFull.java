package com.aelion.appliActivite.dto;

import java.time.LocalDateTime;


public class StatusFull {

	private Long id;

	private LocalDateTime date;

	private String reasonWhy;

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
	
}
