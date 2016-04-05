package com.medify.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "specialty")
public class Specialty {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SPECIALITY_ID", nullable=false)
	private int id;	
	
	@Column(name = "SPECIALITY_NAME", length=255)
	private String name;

	@Column(name = "DISPLAY_NAME", length=255)
	private String displayName;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "IS_ACTIVE", length=1)
	private String status;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="specialty")
	private List<HealthTip> healthTips;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="specialty")
	private List<Doctor> doctors;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public List<HealthTip> getHealthTips() {
		return healthTips;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setHealthTips(List<HealthTip> healthTips) {
		this.healthTips = healthTips;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
}
