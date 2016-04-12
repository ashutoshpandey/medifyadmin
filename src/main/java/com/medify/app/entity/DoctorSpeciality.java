package com.medify.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doctor_speciality")
public class DoctorSpeciality implements Serializable{
	

	private static final long serialVersionUID = -4716613104901614919L;
	
	private Long id;
	private Long specialityId;
	private Long doctorId;
	private char isEnabled='1';
	
	
	
	/**
	 * @return the id
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
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
	 * @return the specialityId
	 */
	
	 @Column(name = "SPECIALITYID")
	public Long getSpecialityId() {
		return specialityId;
	}
	/**
	 * @param specialityId the specialityId to set
	 */
	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
	}
	/**
	 * @return the doctorId
	 */
	
	 @Column(name = "DOCTORID")
	public Long getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the isEnabled
	 */
	
	 @Column(name = "ISENABLED")
	public char getIsEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(char isEnabled) {
		this.isEnabled = isEnabled;
	}
	

}
