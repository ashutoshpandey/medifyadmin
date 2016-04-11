package com.medify.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.app.dao.PatientDetailDAO;
import com.medify.app.entity.PatientDetails;
import com.medify.app.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDetailDAO dao;
	
	@Override
	public PatientDetails findPatient(long id) {

		return dao.findPatientDetail(id);
	}

	@Override
	public List<PatientDetails> getPatients() {

		return dao.getPatientDetails();
	}

	@Override
	public boolean removePatient(long id) {

		return dao.removePatientDetail(id);
	}
}
