package com.medify.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "patient_info")
public class PatientDetails implements Serializable{

	private static final long serialVersionUID = -3295521652530944965L;
	
	private Long PATIENT_ID;
	private String patientName;
	private String profilePicPath;
	private String mobileNo;
	private String email;
	private int age;
	private String gender;
	private Date memberSince;
	private char isActive;
	private String bloodGroup;
	
	private char isStep1='0';
	private char isStep2='0';
	
	
	/**
	 * @return the pATIENT_ID
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "PATIENT_ID", columnDefinition="LONG")
	public Long getPATIENT_ID() {
		return PATIENT_ID;
	}
	/**
	 * @param pATIENT_ID the pATIENT_ID to set
	 */
	public void setPATIENT_ID(Long pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}
	
	
	/**
	 * @return the patientName
	 */
	
	 @Column(name = "PATIENT_NAME")
	public String getPatientName() {
		return patientName;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * @return the mobileNo
	 */
	
	 @Column(name = "MOBILE")
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	
	 @Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the age
	 */
	
	 @Column(name = "AGE")
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	
	@Column(name = "GENDER", columnDefinition="enum('M','F')")
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */

	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the memberSince
	 */
	
	 @Column(name = "CREATED_AT")
	public Date getMemberSince() {
		return memberSince;
	}
	/**
	 * @param memberSince the memberSince to set
	 */
	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
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
	/**
	 * @return the profilePicPath
	 */
	
	@Column(name = "PROFILE_PIC_PATH")
	public String getProfilePicPath() {
		return profilePicPath;
	}
	/**
	 * @param profilePicPath the profilePicPath to set
	 */
	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	/**
	 * @return the isStep1
	 */
	
	 @Column(name = "ISSTEP1")
	public char getIsStep1() {
		return isStep1;
	}
	/**
	 * @param isStep1 the isStep1 to set
	 */
	public void setIsStep1(char isStep1) {
		this.isStep1 = isStep1;
	}
	/**
	 * @return the isStep2
	 */
	
	 @Column(name = "ISSTEP2")
	public char getIsStep2() {
		return isStep2;
	}
	/**
	 * @param isStep2 the isStep2 to set
	 */
	public void setIsStep2(char isStep2) {
		this.isStep2 = isStep2;
	}
	/**
	 * @return the bloodGroup
	 */
	
	@Column(name = "BLOOD_GROUP")
	public String getBloodGroup() {
		return bloodGroup;
	}
	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	
	

}
