package com.medify.app.service;

import java.util.List;

import com.medify.app.entity.Admin;
import com.medify.app.entity.DoctorInfo;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Speciality;

public interface AdminService {

	boolean isValidAdmin(Admin admin);

	boolean addDoctorInfo(DoctorInfo doctor);

	DoctorInfo findDoctorInfo(long doctorId);

	List<DoctorInfo> getDoctorInfos();

	void updateDoctorInfo(DoctorInfo doctor);

	boolean removeDoctorInfo(int id);

	boolean updatePassword(String userName, String password);

	List<Query> getQueries(String type);

	List<DoctorInvite> getDoctorInfoInvites();

	Speciality findSpeciality(long specialtyId);

	boolean updateSpeciality(Speciality specialty);

	List<Speciality> getSpecialties();

	boolean removeSpeciality(int id);

	List<Reschedule> getReschedules();

	List<PromoCode> getPromoCodes();
	
	boolean removePromoCode(int id);

	PromoCode findPromoCode(String code);

	boolean addPromoCode(PromoCode promoCode);

	PromoCode findPromoCode(int id);

	List<HealthTip> getHealthTips();

	Speciality findSpeciality(String name);

	boolean addSpeciality(Speciality specialty);

	boolean updatePromoCode(PromoCode promoCode);
}
