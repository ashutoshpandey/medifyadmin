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
@Table(name = "query_answers")
public class QueryAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;	
	
	@Column(name = "query_id", nullable=false)
	private int queryId;
	
	@Column(name = "doctor_id", nullable=false)
	private int doctorId;

	@Column(name = "message", length=255)
	private String message;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	private String status;

	public int getId() {
		return id;
	}

	public int getQueryId() {
		return queryId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public String getMessage() {
		return message;
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

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}