package com.medify.app.dao;

import java.util.List;

import com.medify.app.entity.PatientDetails;

public interface PatientDetailDAO {

	PatientDetails findPatientDetail(long id);

	List<PatientDetails> getPatientDetails();

	boolean removePatientDetail(long id);

}
