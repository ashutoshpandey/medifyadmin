package com.medify.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_invite")
public class DoctorInvite implements Serializable {

	private static final long serialVersionUID = -2015240365931597576L;

	private Long INVITEDOCID;
	private String doctorName;
	private String doctorNumber;
	private char isCalled = '0';
	private String callResponse;

	/**
	 * @return the iNVITEDOCID
	 */

	@Id
	@GeneratedValue
	@Column(name = "INVITEDOCID")
	public Long getINVITEDOCID() {
		return INVITEDOCID;
	}

	/**
	 * @param iNVITEDOCID
	 *            the iNVITEDOCID to set
	 */
	public void setINVITEDOCID(Long iNVITEDOCID) {
		INVITEDOCID = iNVITEDOCID;
	}

	/**
	 * @return the doctorName
	 */

	@Column(name = "DOC_NAME")
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName
	 *            the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the doctorNumber
	 */

	@Column(name = "DOC_NUMBER")
	public String getDoctorNumber() {
		return doctorNumber;
	}

	/**
	 * @param doctorNumber
	 *            the doctorNumber to set
	 */
	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	/**
	 * @return the isCalled
	 */

	@Column(name = "IS_CALLED")
	public char getIsCalled() {
		return isCalled;
	}

	/**
	 * @param isCalled
	 *            the isCalled to set
	 */
	public void setIsCalled(char isCalled) {
		this.isCalled = isCalled;
	}

	/**
	 * @return the callResponse
	 */

	@Column(name = "CALL_RESPONSE")
	public String getCallResponse() {
		return callResponse;
	}

	/**
	 * @param callResponse
	 *            the callResponse to set
	 */
	public void setCallResponse(String callResponse) {
		this.callResponse = callResponse;
	}
}