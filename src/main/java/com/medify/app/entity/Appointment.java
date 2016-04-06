package com.medify.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable{
	

	private static final long serialVersionUID = -4334833190765359091L;
	
	private Long APPOINTMENT_ID;
	private String appointmentTime;
	private String apType;
	private String apTransId;
	
	private String appintmentDuration;
	private Long doctorId;
	private Long patientId;
	
	private String apCreatedDate;
	private String callHappened="0";
	
	private String apreason;
	private Long slotId;
	
	private String apEndDate;
	private String isView="0";
	
	/**
	 * @return the id
	 */
	

	/**
	 * @return the appointmentTime
	 */
	
	 @Column(name = "APPOINTMENTTIME")
	public String getAppointmentTime() {
		return appointmentTime;
	}
	/**
	 * @param appointmentTime the appointmentTime to set
	 */
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	/**
	 * @return the apType
	 */
	
	 @Column(name = "AP_TYPE")
	public String getApType() {
		return apType;
	}
	/**
	 * @param apType the apType to set
	 */
	public void setApType(String apType) {
		this.apType = apType;
	}
	/**
	 * @return the apTransId
	 */
	
	 @Column(name = "AP_TRANSID")
	public String getApTransId() {
		return apTransId;
	}
	/**
	 * @param apTransId the apTransId to set
	 */
	public void setApTransId(String apTransId) {
		this.apTransId = apTransId;
	}
	/**
	 * @return the apDoctor
	 */
	
	/**
	 * @return the apCreatedDate
	 */
	
	 @Column(name = "AP_CREATED_AT")
	public String getApCreatedDate() {
		return apCreatedDate;
	}
	/**
	 * @param apCreatedDate the apCreatedDate to set
	 */
	public void setApCreatedDate(String apCreatedDate) {
		this.apCreatedDate = apCreatedDate;
	}
	/**
	 * @return the callHappened
	 */
	
	 @Column(name = "IS_CALL_HAPPEND")
	public String getCallHappened() {
		return callHappened;
	}
	/**
	 * @param callHappened the callHappened to set
	 */
	public void setCallHappened(String callHappened) {
		this.callHappened = callHappened;
	}
	/**
	 * @return the doctorId
	 */
	
	@Column(name = "AP_DOCTOR_ID")
	public Long getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the patientId
	 */
	
	@Column(name = "AP_PATIENT_ID")
	public Long getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the appintmentDuration
	 */
		
	@Column(name = "APPOINTMENTDURATION")
	public String getAppintmentDuration() {
		return appintmentDuration;
	}
	/**
	 * @param appintmentDuration the appintmentDuration to set
	 */
	public void setAppintmentDuration(String appintmentDuration) {
		this.appintmentDuration = appintmentDuration;
	}
	/**
	 * @return the apreason
	 */
	
	@Column(name = "AP_REASON")
	public String getApreason() {
		return apreason;
	}
	/**
	 * @param apreason the apreason to set
	 */
	public void setApreason(String apreason) {
		this.apreason = apreason;
	}
	/**
	 * @return the slotId
	 */
	
	@Column(name = "SLOT_ID")
	public Long getSlotId() {
		return slotId;
	}
	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	/**
	 * @return the apEndDate
	 */
	
	@Column(name = "AP_END_DATE")
	public String getApEndDate() {
		return apEndDate;
	}
	/**
	 * @param apEndDate the apEndDate to set
	 */
	public void setApEndDate(String apEndDate) {
		this.apEndDate = apEndDate;
	}
	/**
	 * @return the isView
	 */
	
	@Column(name = "IS_VIEW")
	public String getIsView() {
		return isView;
	}
	/**
	 * @param isView the isView to set
	 */
	public void setIsView(String isView) {
		this.isView = isView;
	}
	/**
	 * @return the aPPOINTMENT_ID
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "APPOINTMENT_ID")
	public Long getAPPOINTMENT_ID() {
		return APPOINTMENT_ID;
	}
	/**
	 * @param aPPOINTMENT_ID the aPPOINTMENT_ID to set
	 */
	public void setAPPOINTMENT_ID(Long aPPOINTMENT_ID) {
		APPOINTMENT_ID = aPPOINTMENT_ID;
	}
}