package com.medify.app.dao;

import java.util.List;

import com.medify.app.entity.Patient;

public interface CustomerDAO {

	Patient findCustomer(int id);

	List<Patient> getCustomers();

	boolean removeCustomer(int id);

}
