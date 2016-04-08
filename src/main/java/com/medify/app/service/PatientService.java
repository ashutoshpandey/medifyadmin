package com.medify.app.service;

import java.util.List;

import com.medify.app.entity.PatientDetails;

public interface PatientService {

	PatientDetails findCustomer(int id);

	List<PatientDetails> getCustomers();

	boolean removeCustomer(int id);
}
