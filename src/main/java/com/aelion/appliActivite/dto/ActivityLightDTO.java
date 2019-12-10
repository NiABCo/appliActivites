package com.aelion.appliActivite.dto;

import java.time.LocalDate;

public class ActivityLightDTO {
	
	private String label;
	
	private String description;
	
	private LocalDate beginningDate;
	
	private LocalDate endingDate;
	
	private String place;
	
	private Double price;
	
	private boolean isAgeRestricted;
	
	private int maxNumber;
	
	public ActivityLightDTO() {
		
	}

	public ActivityLightDTO(String label, String description, LocalDate beginningDate, LocalDate endingDate,
			String place, Double price, boolean isAgeRestricted, int maxNumber) {
		super();
		this.label = label;
		this.description = description;
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
		this.place = place;
		this.price = price;
		this.isAgeRestricted = isAgeRestricted;
		this.maxNumber = maxNumber;
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

	@Override
	public String toString() {
		return "ActivityLightDTO [label=" + label + ", description=" + description + ", beginningDate=" + beginningDate
				+ ", endingDate=" + endingDate + ", place=" + place + ", price=" + price + ", isAgeRestricted="
				+ isAgeRestricted + ", maxNumber=" + maxNumber + "]";
	}
	
	
}
