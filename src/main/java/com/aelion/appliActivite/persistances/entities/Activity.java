package com.aelion.appliActivite.persistances.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="activities")
public class Activity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="label", nullable=false)
	private String label;
	
	@Column(name="description", nullable=true)
	private String description;
	
	@Column(name="creation_date", nullable=false)
	private LocalDate creationDate;
	
	@Column(name="beginning_date", nullable=false)
	private LocalDate beginningDate;
	
	@Column(name="ending_date", nullable=false)
	private LocalDate endingDate;
	
	@Column(name = "place", nullable=false)
	private String place;
	
	@Column(name="price", nullable= true)
	private Double price;
	
	@Column(name="is_age_restricted", nullable=false)
	private boolean isAgeRestricted;
	
	@Column(name = "max_number" , nullable=false)
	private int maxNumber;
	
	@Column(name="status", nullable=true)
	private String status;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn (name = "id_user", nullable = false)
	private List<ActivityHasUser> actHasUser;

	
	/****************************************
	******* CONSTRUCTORS *******************
	***************************************/
	
	
	private Activity() {
		
	};
	
	
	public Activity(Long id, String label, String descirption, LocalDate creationDate, LocalDate beginningDate, LocalDate endingDate,
			String place, Double price, boolean isAgeRestricted, int maxNumber, String status) {
		super();
		this.id = id;
		this.label = label;
		this.description = descirption;
		this.creationDate = creationDate;
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
		this.place = place;
		this.price = price;
		this.isAgeRestricted = isAgeRestricted;
		this.maxNumber = maxNumber;
		this.status = status;
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

	public String getDescirption() {
		return description;
	}

	public void setDescirption(String descirption) {
		this.description = descirption;
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


	/******************************************
	************* METHODS *******************
	******************************************/
	

	@Override
	public String toString() {
		return "Activity [id=" + id + ", label=" + label + ", descirption=" + description + ", creationDate="
				+ creationDate + ", beginningDate=" + beginningDate + ", endingDate=" + endingDate + ", place=" + place
				+ ", price=" + price + ", isAgeRestricted=" + isAgeRestricted + ", maxNumber=" + maxNumber + ", status="
				+ status + "]";
	}
	
	
	
	
}
