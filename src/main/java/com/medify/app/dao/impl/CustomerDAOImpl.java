package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medify.app.dao.CustomerDAO;
import com.medify.app.entity.Patient;

@Transactional
@Repository
public class CustomerDAOImpl extends HibernateUtil implements CustomerDAO {

	@Override
	public Patient findCustomer(int id) {

		Session session = getCurrentSession();
		
		Patient doctor = (Patient) session.get(Patient.class, id);
		if (doctor != null) 		
			return doctor;

		return null;
	}

	@Override
	public List<Patient> getCustomers() {

		Session session = getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Patient> doctors = (List<Patient>)session.createQuery("from Patient as doc where doc.status='active'").list();
		if (!doctors.isEmpty()) 		
			return doctors;	

		return null;
	}

	@Override
	public boolean removeCustomer(int id) {
		
		Session session = getCurrentSession();

		Patient doctor = (Patient) session.get(Patient.class, id);
		if (doctor != null) {

			doctor.setStatus("removed");
			
			session.update(doctor);

			return true;
		}

		return false;
	}
}
