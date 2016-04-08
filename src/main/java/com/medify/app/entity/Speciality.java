package com.medify.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "speciality")
public class Speciality {
	
	private Long id;
	private String specialityName;
	private String displayName;
	private char isActive;
	
	
	/**
	 * @return the id
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "SPECIALITY_ID")
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the specialityName
	 */
	
	 @Column(name = "SPECIALITY_NAME")
	public String getSpecialityName() {
		return specialityName;
	}
	/**
	 * @param specialityName the specialityName to set
	 */
	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}
	/**
	 * @return the displayName
	 */
	
	 @Column(name = "DISPLAY_NAME")
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the isActive
	 */
	
	@Column(name = "IS_ACTIVE")
	public char getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
}
