package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medify.app.dao.PatientDetailDAO;
import com.medify.app.entity.PatientDetails;

@Transactional
@Repository
public class PatientDAOImpl extends HibernateUtil implements PatientDetailDAO {

	@Override
	public PatientDetails findPatientDetail(long id) {

		Session session = getCurrentSession();
		
		PatientDetails doctor = (PatientDetails) session.get(PatientDetails.class, id);
		if (doctor != null) 		
			return doctor;

		return null;
	}

	@Override
	public List<PatientDetails> getPatientDetails() {

		Session session = getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<PatientDetails> doctors = (List<PatientDetails>)session.createQuery("from PatientDetails as doc").list();
		if (!doctors.isEmpty()) 		
			return doctors;	

		return null;
	}

	@Override
	public boolean removePatientDetail(long id) {
		
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
