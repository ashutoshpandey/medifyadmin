package com.medify.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;	
	
	@Column(name = "first_name", nullable=false, length = 255)
	private String firstName;

	@Column(name = "last_name", nullable=false, length = 255)
	private String lastName;

	@Column(name = "contact_number", nullable=false, length = 20)
	private String contactNumber;

	@Column(name = "email_id", nullable=true, length = 255)
	private String emailID;

	@Column(name = "gender", nullable=false)
	private String gender;

	@Column(name = "country", nullable=false, length = 255)
	private String country;

	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "city", length = 255)
	private String city;

	@Column(name = "state", length = 255)
	private String state;

	@Column(name = "zip_code", nullable=false, length = 10)
	private String zipCode;

	@Column(name = "password", length=255)
	private String password;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	private String status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "specialty_id", nullable = true)
	private Specialty specialty;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="doctor")
	private List<HealthTip> healthTips;
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
