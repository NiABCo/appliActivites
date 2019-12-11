package com.aelion.appliActivite.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

public class StatusLight {

	private Long id;

	@PastOrPresent
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
