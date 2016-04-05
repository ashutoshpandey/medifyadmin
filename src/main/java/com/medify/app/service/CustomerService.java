package com.medify.app.service;

import java.util.List;

import com.medify.app.entity.Patient;

public interface CustomerService {

	Patient findCustomer(int id);

	List<Patient> getCustomers();

	boolean removeCustomer(int id);
}
