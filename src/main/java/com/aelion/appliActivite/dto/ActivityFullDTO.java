package com.aelion.appliActivite.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.aelion.appliActivite.persistances.entities.ActivityHasUser;
import com.aelion.appliActivite.persistances.entities.Message;

public class ActivityFullDTO {

	private String label;
	
	private String description;
	
	private LocalDate creationDate;
	
	private LocalDate beginningDate;
	
	private LocalDate endingDate;
	
	private String place;
	
	private Double price;

	private boolean isAgeRestricted;
	
	private int maxNumber;
	
	private String status;
	
	private List<ActivityHasUser> actHasUser;
	
	private List<Message> activityMessage;
	
	public ActivityFullDTO() {
		
	}
	
	
	
	public ActivityFullDTO(String label, String description, LocalDate creationDate, LocalDate beginningDate,
			LocalDate endingDate, String place, Double price, boolean isAgeRestricted, int maxNumber, String status,
			List<ActivityHasUser> actHasUser, List<Message> activityMessage) {
		super();
		this.label = label;
		this.description = description;
		this.creationDate = creationDate;
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
		this.place = place;
		this.price = price;
		this.isAgeRestricted = isAgeRestricted;
		this.maxNumber = maxNumber;
		this.status = status;
		this.actHasUser = actHasUser;
		this.activityMessage = activityMessage;
	}



	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getBeginningDate() {
		return beginningDate;
	}

	public void setBeginningDate(LocalDate beginningDate) {
		this.beginningDate = beginningDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isAgeRestricted() {
		return isAgeRestricted;
	}

	public void setAgeRestricted(boolean isAgeRestricted) {
		this.isAgeRestricted = isAgeRestricted;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ActivityHasUser> getActHasUser() {
		return actHasUser;
	}

	public void setActHasUser(List<ActivityHasUser> actHasUser) {
		this.actHasUser = actHasUser;
	}

	public List<Message> getActivityMessage() {
		return activityMessage;
	}

	public void setActivityMessage(List<Message> activityMessage) {
		this.activityMessage = activityMessage;
	}

}
