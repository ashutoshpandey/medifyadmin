package com.medify.app.service;

import java.util.List;

import com.medify.app.entity.PatientDetails;

public interface PatientService {

	PatientDetails findPatient(long id);

	List<PatientDetails> getPatients();

	boolean removePatient(long id);
}
