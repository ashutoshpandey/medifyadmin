package com.medify.app.pojo;

import com.medify.app.entity.DoctorInfo;
import com.medify.app.entity.PatientDetails;
import com.medify.app.entity.PublicQuestion;

public class PublicQuestionPatientDoctor {

	private PublicQuestion publicQuestion;
	private PatientDetails patientDetail;
	private DoctorInfo doctorInfo;
	
	public PublicQuestion getPublicQuestion() {
		return publicQuestion;
	}
	public void setPublicQuestion(PublicQuestion publicQuestion) {
		this.publicQuestion = publicQuestion;
	}
	public PatientDetails getPatientDetail() {
		return patientDetail;
	}
	public void setPatientDetail(PatientDetails patientDetail) {
		this.patientDetail = patientDetail;
	}
	public DoctorInfo getDoctorInfo() {
		return doctorInfo;
	}
	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
}
