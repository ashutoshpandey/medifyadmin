package com.medify.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.app.dao.AdminDAO;
import com.medify.app.entity.Admin;
import com.medify.app.entity.DoctorInfo;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PatientDetails;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.PublicQuestion;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Speciality;
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
	public boolean addDoctorInfo(DoctorInfo doctor) {

		return dao.addDoctorInfo(doctor);
	}

	@Override
	public DoctorInfo findDoctorInfo(long id) {

		return dao.findDoctorInfo(id);
	}

	@Override
	public boolean removeDoctorInfo(int id) {

		return dao.removeDoctorInfo(id);
	}

	@Override
	public List<DoctorInfo> getDoctorInfos() {

		return dao.getDoctorInfos();
	}

	@Override
	public void updateDoctorInfo(DoctorInfo doctor) {

		dao.updateDoctorInfo(doctor);
	}

	@Override
	public boolean updatePassword(String userName, String password) {

		return dao.updatePassword(userName, password);
	}

	@Override
	public List<PublicQuestion> getQueries(String type) {

		return dao.getQueries(type);
	}

	@Override
	public List<DoctorInvite> getDoctorInfoInvites() {

		return dao.getDoctorInfoInvites();
	}

	@Override
	public Speciality findSpeciality(long specialtyId) {
		
		return dao.findSpeciality(specialtyId);
	}

	@Override
	public boolean updateSpeciality(Speciality specialty) {
		
		return dao.updateSpeciality(specialty);
	}

	@Override
	public List<Speciality> getSpecialties() {
		
		return dao.getSpecialties();
	}

	@Override
	public boolean removeSpeciality(int id) {
		
		return dao.removeSpeciality(id);
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
	public Speciality findSpeciality(String name) {

		return dao.findSpeciality(name);
	}

	@Override
	public boolean addSpeciality(Speciality specialty) {

		return dao.addSpeciality(specialty);
	}

	@Override
	public boolean updatePromoCode(PromoCode promoCode) {

		return dao.updatePromoCode(promoCode);
	}

	@Override
	public PatientDetails findPatientDetails(Long postedBy) {

		return dao.findPatientDetails(postedBy);
	}

	@Override
	public PublicQuestion findPublicQuestion(long id) {

		return dao.findPublicQuestion(id);
	}
}
