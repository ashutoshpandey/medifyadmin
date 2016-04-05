package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medify.app.dao.AdminDAO;
import com.medify.app.entity.Admin;
import com.medify.app.entity.Doctor;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Specialty;

@Repository
@Transactional
public class AdminDAOImpl extends HibernateUtil implements AdminDAO {

	@Override
	public boolean isValidAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor findDoctor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Doctor> getDoctorsBySpecialty(String specialty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Query> getQueries(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorInvite> getDoctorInvites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specialty findSpecialty(int specialtyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Specialty> getSpecialties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeSpecialty(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reschedule> getReschedules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromoCode> getPromoCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePromoCode(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PromoCode findPromoCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePromoCode(PromoCode promoCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PromoCode findPromoCode(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HealthTip> getHealthTips() {

		Session session = getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<HealthTip> healthTips = (List<HealthTip>)session.createQuery("from HealthTip").list();
		
		return healthTips;
	}

}
