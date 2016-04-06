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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "promo_codes")
public class PromoCode {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int id;	
	
	@Column(name = "code", nullable=false, length = 255)
	private String code;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date endDate;

	@Column(name = "USAGE_COUNT")
	private int usageCount;
	
	public PromoCode(){
		
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}

	@Column(name = "status", length=10)
	private String status;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Double getAmount() {
		return amount;
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

	public void setCode(String code) {
		this.code = code;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
