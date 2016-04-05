package com.medify.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.app.dao.CustomerDAO;
import com.medify.app.entity.Patient;
import com.medify.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	@Override
	public Patient findCustomer(int id) {

		return dao.findCustomer(id);
	}

	@Override
	public List<Patient> getCustomers() {

		return dao.getCustomers();
	}

	@Override
	public boolean removeCustomer(int id) {

		return dao.removeCustomer(id);
	}
}
