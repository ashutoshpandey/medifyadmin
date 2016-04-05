package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medify.app.dao.AdminDAO;
import com.medify.app.entity.Admin;
import com.medify.app.entity.Doctor;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Specialty;

@Repository
@Transactional
public class AdminDAOImpl extends HibernateUtil implements AdminDAO {

	@Override
	public boolean isValidAdmin(Admin admin) {

		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Admin as admin where admin.user_name=:userName and password=:password");
		query.setString("userName", admin.getUserName());
		query.setString("password", admin.getPassword());
		
		return !query.list().isEmpty();
	}

	@Override
	public boolean addDoctor(Doctor doctor) {

		Session session = getCurrentSession();
		
		session.save(doctor);
		
		return true;
	}

	@Override
	public boolean removeDoctor(int doctorId) {

		Session session = getCurrentSession();

		Doctor doctor = (Doctor) session.get(Doctor.class, doctorId);
		
		if(doctor!=null){
			session.delete(doctor);
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctors() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Doctor as doc where doc.status='active'");
		
		return (List<Doctor>)query.list();
	}

	@Override
	public Doctor findDoctor(int doctorId) {
		
		Session session = getCurrentSession();

		Doctor doctor = (Doctor) session.get(Doctor.class, doctorId);
		
		return doctor==null ? null: doctor;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {

		Session session = getCurrentSession();

		Doctor existingDoctor = (Doctor) session.get(Doctor.class, doctor.getId());
		
		if(existingDoctor!=null){

			existingDoctor.setFirstName(doctor.getFirstName());
			existingDoctor.setLastName(doctor.getLastName());
			existingDoctor.setCity(doctor.getCity());
			existingDoctor.setContactNumber(doctor.getContactNumber());
			existingDoctor.setCountry(doctor.getCountry());
			existingDoctor.setAddress(doctor.getAddress());
			
			session.update(existingDoctor);
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<Doctor> getDoctorsBySpecialty(String specialty) {

		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Doctor as doc where doc.status='active'");
		
		return (List<Doctor>)query.list();
	}

	@Override
	public boolean updatePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<com.medify.app.entity.Query> getQueries(String type) {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Query as qry where qry.status='active'");
		
		return (List<com.medify.app.entity.Query>)query.list();
	}

	@Override
	public List<DoctorInvite> getDoctorInvites() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from DoctorInvite as invite where invite.status='active'");
		
		return (List<com.medify.app.entity.DoctorInvite>)query.list();
	}

	@Override
	public Specialty findSpecialty(int specialtyId) {
		
		Session session = getCurrentSession();

		Specialty specialty = (Specialty) session.get(Specialty.class, specialtyId);
		
		return specialty==null ? null: specialty;
	}

	@Override
	public boolean updateSpecialty(Specialty specialty) {

		Session session = getCurrentSession();

		Specialty existingSpecialty = (Specialty) session.get(Specialty.class, specialty.getId());
		
		if(existingSpecialty!=null){

			existingSpecialty.setDisplayName(specialty.getDisplayName());
			existingSpecialty.setName(specialty.getName());
			
			session.update(existingSpecialty);
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<Specialty> getSpecialties() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Specialty as sp where sp.status='active'");
		
		return (List<Specialty>)query.list();
	}

	@Override
	public boolean removeSpecialty(int promoCodeId) {

		Session session = getCurrentSession();

		PromoCode promoCode = (PromoCode) session.get(PromoCode.class, promoCodeId);
		
		if(promoCode!=null){
			session.delete(promoCode);
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<Reschedule> getReschedules() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Reschedule as rs where rs.status='active'");
		
		return (List<Reschedule>)query.list();
	}

	@Override
	public List<PromoCode> getPromoCodes() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from PromoCode as pc where pc.status='active'");
		
		return (List<PromoCode>)query.list();
	}

	@Override
	public boolean removePromoCode(int promoCodeId) {

		Session session = getCurrentSession();

		PromoCode promoCode = (PromoCode) session.get(PromoCode.class, promoCodeId);
		
		if(promoCode!=null){
			session.delete(promoCode);
			
			return true;
		}
		
		return false;
	}

	@Override
	public PromoCode findPromoCode(String code) {
		
		Session session = getCurrentSession();

		Query query = session.createQuery("from PromoCode as pc where pc.code=:code");
		query.setString("code", code);
		
		@SuppressWarnings("unchecked")
		List<PromoCode> promoCodes = (List<PromoCode>) query.list();
		
		return promoCodes.isEmpty() ? null: promoCodes.get(0);
	}

	@Override
	public boolean addPromoCode(PromoCode promoCode) {

		Session session = getCurrentSession();
		
		session.save(promoCode);
		
		return true;
	}

	@Override
	public PromoCode findPromoCode(int promoCodeId) {
		
		Session session = getCurrentSession();

		PromoCode promoCode = (PromoCode) session.get(PromoCode.class, promoCodeId);
		
		return promoCode==null ? null: promoCode;
	}

	@Override
	public List<HealthTip> getHealthTips() {

		Session session = getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<HealthTip> healthTips = (List<HealthTip>)session.createQuery("from HealthTip").list();
		
		return healthTips;
	}

}
