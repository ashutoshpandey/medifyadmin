package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medify.app.dao.CustomerDAO;
import com.medify.app.entity.PatientDetails;

@Transactional
@Repository
public class PatientDAOImpl extends HibernateUtil implements CustomerDAO {

	@Override
	public PatientDetails findCustomer(int id) {

		Session session = getCurrentSession();
		
		PatientDetails doctor = (PatientDetails) session.get(PatientDetails.class, id);
		if (doctor != null) 		
			return doctor;

		return null;
	}

	@Override
	public List<PatientDetails> getCustomers() {

		Session session = getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<PatientDetails> doctors = (List<PatientDetails>)session.createQuery("from PatientDetails as doc where doc.status='active'").list();
		if (!doctors.isEmpty()) 		
			return doctors;	

		return null;
	}

	@Override
	public boolean removeCustomer(int id) {
		
		Session session = getCurrentSession();

		PatientDetails doctor = (PatientDetails) session.get(PatientDetails.class, id);
		if (doctor != null) {

			//doctor.setStatus("removed");
			
			session.update(doctor);

			return true;
		}

		return false;
	}
}
