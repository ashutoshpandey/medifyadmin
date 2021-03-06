package com.medify.app.dao;

import java.util.List;

import com.medify.app.entity.Admin;
import com.medify.app.entity.DoctorInfo;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PatientDetails;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.PublicQuestion;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Speciality;

public interface AdminDAO {

	boolean isValidAdmin(Admin admin);

	boolean addDoctorInfo(DoctorInfo doctor);

	boolean removeDoctorInfo(int doctorId);

	List<DoctorInfo> getDoctorInfos();

	DoctorInfo findDoctorInfo(long id);

	boolean updateDoctorInfo(DoctorInfo doctor);

	List<DoctorInfo> getDoctorInfosBySpeciality(long id);

	boolean updatePassword(String userName, String password);

	List<PublicQuestion> getQueries(String type);

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

	PatientDetails findPatientDetails(Long postedBy);

	PublicQuestion findPublicQuestion(long id);

	HealthTip findHealthTip(long healthTipId);

	boolean removeHealthTip(long id);

	boolean addHealthTip(HealthTip healthTip);

	boolean updateHealthTip(HealthTip healthTip);

}
