package com.medify.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable{

	private static final long serialVersionUID = -7925134750939227355L;
	
	private Long Id;	
	
	private DoctorInfo userId;		
	
	private String userType;
	private String acName;
	private Integer accNumber;
    private String ifdcCode;
    private String bankAddress;
    private String isEnabled;
    
    
	/**
	 * @return the id
	 */
    
    @Id
	@GeneratedValue
	@Column(name = "ACCOUNTINFOID")
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
	 * @return the userId
	 */
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public DoctorInfo getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(DoctorInfo userId) {
		this.userId = userId;
	}
	/**
	 * @return the userType
	 */
	
	@Column(name = "USER_TYPE")
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the acName
	 */
	
	@Column(name = "AC_NAME")
	public String getAcName() {
		return acName;
	}
	/**
	 * @param acName the acName to set
	 */
	public void setAcName(String acName) {
		this.acName = acName;
	}
	/**
	 * @return the accNumber
	 */
	
	@Column(name = "AC_NUMBER")
	public Integer getAccNumber() {
		return accNumber;
	}
	/**
	 * @param accNumber the accNumber to set
	 */
	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}
	/**
	 * @return the ifdcCode
	 */
	
	@Column(name = "IFSC_CODE")
	public String getIfdcCode() {
		return ifdcCode;
	}
	/**
	 * @param ifdcCode the ifdcCode to set
	 */
	public void setIfdcCode(String ifdcCode) {
		this.ifdcCode = ifdcCode;
	}
	/**
	 * @return the bankAddress
	 */
	
	@Column(name = "BANK_ADDRESS")
	public String getBankAddress() {
		return bankAddress;
	}
	/**
	 * @param bankAddress the bankAddress to set
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
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
    
	
	

}
