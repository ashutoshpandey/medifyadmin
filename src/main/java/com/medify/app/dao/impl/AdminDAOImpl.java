package com.medify.app.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

@Repository
@Transactional
public class AdminDAOImpl extends HibernateUtil implements AdminDAO {

	@Override
	public boolean isValidAdmin(Admin admin) {

		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Admin as admin where admin.userName=:userName and password=:password");
		query.setString("userName", admin.getUserName());
		query.setString("password", admin.getPassword());
		
		return !query.list().isEmpty();
	}

	@Override
	public boolean addDoctorInfo(DoctorInfo doctor) {

		Session session = getCurrentSession();
		
		session.save(doctor);
		
		return true;
	}

	@Override
	public boolean removeDoctorInfo(int doctorId) {

		Session session = getCurrentSession();

		DoctorInfo doctor = (DoctorInfo) session.get(DoctorInfo.class, doctorId);
		
		if(doctor!=null){
			session.delete(doctor);
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorInfo> getDoctorInfos() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from DoctorInfo as doc where doc.status='y'");
		
		return (List<DoctorInfo>)query.list();
	}

	@Override
	public DoctorInfo findDoctorInfo(long doctorId) {
		
		Session session = getCurrentSession();

		DoctorInfo doctor = (DoctorInfo) session.get(DoctorInfo.class, doctorId);
		
		return doctor==null ? null: doctor;
	}

	@Override
	public boolean updateDoctorInfo(DoctorInfo doctor) {

		Session session = getCurrentSession();

		DoctorInfo existingDoctorInfo = (DoctorInfo) session.get(DoctorInfo.class, doctor.getId());
		
		if(existingDoctorInfo!=null){

			existingDoctorInfo.setName(doctor.getName());
			existingDoctorInfo.setAboutMe(doctor.getAboutMe());
			existingDoctorInfo.setCity(doctor.getCity());
			existingDoctorInfo.setPhoneNumber(doctor.getPhoneNumber());
			existingDoctorInfo.setAge(doctor.getAge());
			existingDoctorInfo.setClinicAddress(doctor.getClinicAddress());
			existingDoctorInfo.setConsultFeeCall(doctor.getConsultFeeCall());
			existingDoctorInfo.setConsultFeeText(doctor.getConsultFeeText());
			existingDoctorInfo.setEducation(doctor.getEducation());
			existingDoctorInfo.setEmail(doctor.getEmail());
			existingDoctorInfo.setGender(doctor.getGender());
			existingDoctorInfo.setIsEnabled(doctor.getIsEnabled());
			existingDoctorInfo.setLocation(doctor.getLocation());
			existingDoctorInfo.setTotalEx(doctor.getTotalEx());

			session.update(existingDoctorInfo);
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorInfo> getDoctorInfosBySpeciality(long id) {

		Session session = getCurrentSession();
		
		String hql = "from DoctorInfo as doc where doc.id in(select doctorId from DoctorSpeciality as ds where ds.specialityId=:specialityId and ds.isEnabled='1')";		
		
		Query query = session.createQuery(hql);
		query.setLong("specialityId", id);
		
		return (List<DoctorInfo>)query.list();
	}

	@Override
	public boolean updatePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PublicQuestion> getQueries(String type) {
		
		Session session = getCurrentSession();
		
		String hql;
		if(type.equals("pending"))
			hql = "from PublicQuestion as pq where pq.repliedBy is null order by pq.id";
		else
			hql = "from PublicQuestion as pq where pq.repliedBy is not null order by pq.id";
		
		Query query = session.createQuery(hql);
		
		return (List<PublicQuestion>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorInvite> getDoctorInfoInvites() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from DoctorInfoInvite as invite where invite.status='y'");
		
		return (List<DoctorInvite>)query.list();
	}

	@Override
	public Speciality findSpeciality(long specialtyId) {
		
		Session session = getCurrentSession();

		Speciality specialty = (Speciality) session.get(Speciality.class, specialtyId);
		
		return specialty==null ? null: specialty;
	}

	@Override
	public boolean updateSpeciality(Speciality specialty) {

		Session session = getCurrentSession();

		Speciality existingSpeciality = (Speciality) session.get(Speciality.class, specialty.getId());
		
		if(existingSpeciality!=null){

			existingSpeciality.setDisplayName(specialty.getDisplayName());
			existingSpeciality.setSpecialityName(specialty.getSpecialityName());
			
			session.update(existingSpeciality);
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speciality> getSpecialties() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Speciality as sp where sp.isActive='y'");
		
		return (List<Speciality>)query.list();
	}

	@Override
	public boolean removeSpeciality(int promoCodeId) {

		Session session = getCurrentSession();

		PromoCode promoCode = (PromoCode) session.get(PromoCode.class, promoCodeId);
		
		if(promoCode!=null){
			session.delete(promoCode);
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reschedule> getReschedules() {
		
		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Reschedule as rs where rs.status='y'");
		
		return (List<Reschedule>)query.list();
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@Override
	public Speciality findSpeciality(String name) {

		Session session = getCurrentSession();
		
		Query query = session.createQuery("from Speciality as specialty where specialty.specialityName=:name and specialty.isActive='y'");
		query.setString("name", name);
	
		List<Speciality> specialties = query.list();
		
		return specialties.isEmpty() ? null : specialties.get(0);				
	}

	@Override
	public boolean addSpeciality(Speciality specialty) {

		Session session = getCurrentSession();
		
		session.save(specialty);
		
		return true;
	}

	@Override
	public boolean updatePromoCode(PromoCode promoCode) {

		Session session = getCurrentSession();

		PromoCode existingPromoCode = (PromoCode) session.get(PromoCode.class, promoCode.getId());
		
		if(existingPromoCode!=null){

			existingPromoCode.setCode(promoCode.getCode());
			existingPromoCode.setAmount(promoCode.getAmount());
			existingPromoCode.setStartDate(promoCode.getStartDate());
			existingPromoCode.setEndDate(promoCode.getEndDate());
			existingPromoCode.setUsageCount(promoCode.getUsageCount());
			
			session.update(existingPromoCode);
			
			return true;
		}
		
		return false;
	}

	@Override
	public PatientDetails findPatientDetails(Long postedBy) {
		
		Session session = getCurrentSession();

		PatientDetails patient = (PatientDetails) session.get(PatientDetails.class, postedBy);
		
		return patient==null ? null: patient;
	}

	@Override
	public PublicQuestion findPublicQuestion(long id) {
		
		Session session = getCurrentSession();

		PublicQuestion publicQuestion = (PublicQuestion) session.get(PublicQuestion.class, id);
		
		return publicQuestion==null ? null: publicQuestion;
	}

	@Override
	public HealthTip findHealthTip(long id) {
		
		Session session = getCurrentSession();

		HealthTip healthTip = (HealthTip) session.get(HealthTip.class, id);
		
		return healthTip==null ? null: healthTip;
	}

	@Override
	public boolean removeHealthTip(long id) {
		
		Session session = getCurrentSession();

		HealthTip healthTip = (HealthTip) session.get(HealthTip.class, id);
		
		if(healthTip!=null){
			session.delete(healthTip);
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addHealthTip(HealthTip healthTip) {

		Session session = getCurrentSession();
		
		session.save(healthTip);
		
		return true;
	}

	@Override
	public boolean updateHealthTip(HealthTip healthTip) {

		Session session = getCurrentSession();

		HealthTip existingHealthTip = (HealthTip) session.get(HealthTip.class, healthTip.getId());
		
		if(existingHealthTip!=null){

			existingHealthTip.setContent(healthTip.getContent());
			existingHealthTip.setTopic(healthTip.getTopic());
			
			session.update(existingHealthTip);
			
			return true;
		}
		
		return false;
	}

}
