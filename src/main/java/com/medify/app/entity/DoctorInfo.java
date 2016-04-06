package com.medify.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "doctor_info")
public class DoctorInfo implements Serializable{
	

	private static final long serialVersionUID = -554161676870961050L;
	
	private Long Id;
	private String name;
	private Integer age;
	private String gender;
	private String profilePicturePath;
	private String email;
	private String phoneNumber;
	private String education;
	private String aboutMe;
	private String totalEx;
	private String location;
	private String city;
	private String consultFeeText;
	private String consultFeeCall;
	private String clinicAddress;
	private String isEnabled;
	
	
	private Set<AccountInfo> accountDetails;
	
	
	/**
	 * @return the id
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	
	 @Column(name = "NAME")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	
	 @Column(name = "AGE")
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	
	 @Column(name = "GENDER")
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
	 * @return the profilePicturePath
	 */
	
	 @Column(name = "PROFILE_PICTURE_PATH")
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	/**
	 * @param profilePicturePath the profilePicturePath to set
	 */
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
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
	 * @return the phoneNumber
	 */
	
	
	 @Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the education
	 */
	
	
	 @Column(name = "EDUCATION")
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the totalEx
	 */
	
	 @Column(name = "TOTAL_EX")
	public String getTotalEx() {
		return totalEx;
	}
	/**
	 * @param totalEx the totalEx to set
	 */
	public void setTotalEx(String totalEx) {
		this.totalEx = totalEx;
	}
	/**
	 * @return the location
	 */
	
	 @Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the city
	 */
	
	 @Column(name = "CITY")
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the consultFeeText
	 */
	
	 @Column(name = "CONSULT_FEE_TEXT")
	public String getConsultFeeText() {
		return consultFeeText;
	}
	/**
	 * @param consultFeeText the consultFeeText to set
	 */
	public void setConsultFeeText(String consultFeeText) {
		this.consultFeeText = consultFeeText;
	}
	/**
	 * @return the consultFeeCall
	 */
	
	 @Column(name = "CONSULT_FEE_PHONE")
	public String getConsultFeeCall() {
		return consultFeeCall;
	}
	/**
	 * @param consultFeeCall the consultFeeCall to set
	 */
	public void setConsultFeeCall(String consultFeeCall) {
		this.consultFeeCall = consultFeeCall;
	}
	/**
	 * @return the clinicAddress
	 */
	
	 @Column(name = "CLINIC_ADDRESS")
	public String getClinicAddress() {
		return clinicAddress;
	}
	/**
	 * @param clinicAddress the clinicAddress to set
	 */
	 
	 @Column(name = "ID")
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}
	/**
	 * @return the isEnabled
	 */
	 
	 @Column(name = "IS_ENABLED")
	public String getIsEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * @return the accountDetails
	 */
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public Set<AccountInfo> getAccountDetails() {
		return accountDetails;
	}		
	/**
	 * @param accountDetails the accountDetails to set
	 */
	public void setAccountDetails(Set<AccountInfo> accountDetails) {
		this.accountDetails = accountDetails;
	}
	/**
	 * @return the aboutMe
	 */
	
	@Column(name = "ABOUT_ME")
	public String getAboutMe() {
		return aboutMe;
	}
	/**
	 * @param aboutMe the aboutMe to set
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	

}
