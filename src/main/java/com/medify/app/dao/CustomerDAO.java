package com.medify.app.dao;

import java.util.List;

import com.medify.app.entity.PatientDetails;

public interface CustomerDAO {

	PatientDetails findCustomer(int id);

	List<PatientDetails> getCustomers();

	boolean removeCustomer(int id);

}
