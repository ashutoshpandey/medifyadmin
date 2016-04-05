package com.medify.app.service;

import java.util.List;

import com.medify.app.entity.Admin;
import com.medify.app.entity.Doctor;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Specialty;

public interface AdminService {

	boolean isValidAdmin(Admin admin);

	boolean addDoctor(Doctor doctor);

	Doctor findDoctor(int id);

	List<Doctor> getDoctors();

	void updateDoctor(Doctor doctor);

	boolean removeDoctor(int id);

	boolean updatePassword(String userName, String password);

	List<Query> getQueries(String type);

	List<DoctorInvite> getDoctorInvites();

	Specialty findSpecialty(int specialtyId);

	boolean updateSpecialty(Specialty specialty);

	List<Specialty> getSpecialties();

	boolean removeSpecialty(int id);

	List<Reschedule> getReschedules();

	List<PromoCode> getPromoCodes();
	
	boolean removePromoCode(int id);

	PromoCode findPromoCode(String code);

	boolean savePromoCode(PromoCode promoCode);

	PromoCode findPromoCode(int id);

	List<HealthTip> getHealthTips();
}
