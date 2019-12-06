package com.aelion.appliActivite.persistance.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "label", nullable = false)
	private String label;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "creationDate", nullable = false)
	private LocalDate creationDate;
	
	@Column(name = "beginningDate", nullable = false)
	private LocalDate beginningDate;
	
	@Column(name = "endingDate", nullable = false)
	private LocalDate endingDate;
	
	@Column(name = "place", nullable = false)
	private String place;
	
	@Column(name = "price", nullable = true)
	private Double price;
	
	@Column(name = "isAgeRestricted", nullable = false)
	private boolean isAgeRestricted;
	
	@Column(name = "maxNumber", nullable = true)
	private int maxNumber;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	
	/*************************
	 * Constructors
	 ************************/
	
	public Activity() {}
	
	public Activity(Long id, String label, String description, LocalDate creationDate, LocalDate beginningDate, LocalDate endingDate,
			String place, Double price, boolean isAgeRestricted, int maxNumber, String status) {
		super();
		this.id = id;
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
	}
	
	/*************************
	 * Getters & Setters
	 *************************/
	
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
	
	/**********************
	 * Methods
	 * *******************/
	
	
}
