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
	private Speciality specialty;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "doctor_id", nullable = true)
	private DoctorInfo doctor;

	@Column(name = "topic")
	private String topic;

	@Column(name = "article_image", length=255)
	private String articleImage;

	@Column(name = "content", length=1000)
	private String content;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "like_count", length=10)
	private Integer likeCount=0;
	
	
	private String status;

	public int getId() {
		return id;
	}

	public Speciality getSpecialty() {
		return specialty;
	}

	public DoctorInfo getDoctor() {
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

	public void setSpecialty(Speciality specialty) {
		this.specialty = specialty;
	}

	public void setDoctor(DoctorInfo doctor) {
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

	/**
	 * @return the likeCount
	 */
	public Integer getLikeCount() {
		return likeCount;
	}

	/**
	 * @param likeCount the likeCount to set
	 */
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
}