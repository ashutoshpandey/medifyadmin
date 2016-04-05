package com.medify.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "health_tips")
public class HealthTip {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "specialty_id", nullable = true)
	private Specialty specialty;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "doctor_id", nullable = true)
	private Doctor doctor;

	@Column(name = "topic")
	private String topic;

	@Column(name = "article_image", length=255)
	private String articleImage;

	@Column(name = "content", length=1000)
	private String content;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	private String status;

	public int getId() {
		return id;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getTopic() {
		return topic;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public String getContent() {
		return content;
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

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
