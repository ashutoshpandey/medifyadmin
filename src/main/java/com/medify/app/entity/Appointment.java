package com.medify.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;	
	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "appointment_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentCreated;
	
	private String status;

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getAppointmentCreated() {
		return appointmentCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setAppointmentCreated(Date appointmentCreated) {
		this.appointmentCreated = appointmentCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
