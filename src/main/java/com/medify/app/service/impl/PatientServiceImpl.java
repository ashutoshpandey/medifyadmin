package com.medify.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.app.dao.CustomerDAO;
import com.medify.app.entity.PatientDetails;
import com.medify.app.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private CustomerDAO dao;
	
	@Override
	public PatientDetails findCustomer(int id) {

		return dao.findCustomer(id);
	}

	@Override
	public List<PatientDetails> getCustomers() {

		return dao.getCustomers();
	}

	@Override
	public boolean removeCustomer(int id) {

		return dao.removeCustomer(id);
	}
}
