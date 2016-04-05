package com.medify.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.app.dao.AdminDAO;
import com.medify.app.entity.Admin;
import com.medify.app.entity.Doctor;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Specialty;
import com.medify.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;
	
	@Override
	public boolean isValidAdmin(Admin admin) {

		return dao.isValidAdmin(admin);
	}

	@Override
	public boolean addDoctor(Doctor doctor) {

		return dao.addDoctor(doctor);
	}

	@Override
	public Doctor findDoctor(int id) {

		return dao.findDoctor(id);
	}

	@Override
	public boolean removeDoctor(int id) {

		return dao.removeDoctor(id);
	}

	@Override
	public List<Doctor> getDoctors() {

		return dao.getDoctors();
	}

	@Override
	public void updateDoctor(Doctor doctor) {

		dao.updateDoctor(doctor);
	}

	@Override
	public boolean updatePassword(String userName, String password) {

		return dao.updatePassword(userName, password);
	}

	@Override
	public List<Query> getQueries(String type) {

		return dao.getQueries(type);
	}

	@Override
	public List<DoctorInvite> getDoctorInvites() {

		return dao.getDoctorInvites();
	}

	@Override
	public Specialty findSpecialty(int specialtyId) {
		
		return dao.findSpecialty(specialtyId);
	}

	@Override
	public boolean updateSpecialty(Specialty specialty) {
		
		return dao.updateSpecialty(specialty);
	}

	@Override
	public List<Specialty> getSpecialties() {
		
		return dao.getSpecialties();
	}

	@Override
	public boolean removeSpecialty(int id) {
		
		return dao.removeSpecialty(id);
	}

	@Override
	public List<Reschedule> getReschedules() {

		return dao.getReschedules();
	}

	@Override
	public List<PromoCode> getPromoCodes() {

		return dao.getPromoCodes();
	}

	@Override
	public boolean removePromoCode(int id) {

		return dao.removePromoCode(id);
	}

	@Override
	public PromoCode findPromoCode(String code) {

		return dao.findPromoCode(code);
	}

	@Override
	public boolean addPromoCode(PromoCode promoCode) {

		return dao.addPromoCode(promoCode);
	}

	@Override
	public PromoCode findPromoCode(int id) {

		return dao.findPromoCode(id);
	}

	@Override
	public List<HealthTip> getHealthTips() {

		return dao.getHealthTips();
	}

	@Override
	public Specialty findSpecialty(String name) {

		return dao.findSpecialty(name);
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {

		return dao.addSpecialty(specialty);
	}
}
