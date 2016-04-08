package com.medify.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medify.app.entity.DoctorInfo;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.PatientDetails;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Speciality;
import com.medify.app.service.AdminService;
import com.medify.app.service.PatientService;

@Controller
@RequestMapping("/")
public class AdminController {

	@Autowired
	private AdminService service;

	@Autowired
	private PatientService patientService;

	@RequestMapping("/admin-section")
	public String adminSection() {
		return "admin/admin-section";
	}
	
	@RequestMapping("/get-doctor")
	public String getDoctorInfo(@RequestParam int id, ModelMap map) {
		
		DoctorInfo doctor = service.findDoctorInfo(id);
		
		if(doctor!=null){
			map.addAttribute("found", true);
			map.addAttribute("doctor", doctor);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/get-doctor";
	}

	@RequestMapping("/edit-doctor")
	public String editDoctorInfo(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		DoctorInfo doctor = service.findDoctorInfo(id);
		
		if(doctor!=null){
			
			request.getSession().setAttribute("doctorId", doctor.getId());
			
			map.addAttribute("found", true);
			map.addAttribute("doctor", doctor);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/edit-doctor";
	}

	@RequestMapping("/remove-doctor")
	@ResponseBody
	public String removeDoctorInfo(@RequestParam int id) {
		
		DoctorInfo doctor = service.findDoctorInfo(id);
		
		if(doctor!=null){
			
			service.removeDoctorInfo(id);

			return "removed";
		}
		else
			return "invalid";
	}

	@RequestMapping("/update-doctor")
	@ResponseBody
	public String updateDoctorInfo(DoctorInfo doctor, ModelMap map, HttpServletRequest request) {
		
		Object objDoctorInfoId = request.getSession().getAttribute("doctorId");
		
		if(objDoctorInfoId!=null){
			
			long doctorId = Long.parseLong(objDoctorInfoId.toString());
			
			DoctorInfo existingDoctorInfo = service.findDoctorInfo(doctorId);
			
			if(existingDoctorInfo!=null){
				
				doctor.setId(doctorId);
				
				service.updateDoctorInfo(doctor);
	
				return "updated";
			}
			else
				return "invalid";
		}
		else
			return "invalid";
	}

	@RequestMapping("/list-doctors")
	public String listDoctorInfos(ModelMap map) {
		
		List<DoctorInfo> doctors = service.getDoctorInfos();
		
		if(doctors!=null && !doctors.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("doctors", doctors);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-doctors";
	}

	@RequestMapping("/list-patients")
	public String listCustomers(ModelMap map) {
		
		List<PatientDetails> patients = patientService.getCustomers();
		
		if(patients!=null && !patients.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("patients", patients);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-patients";
	}

	@RequestMapping("/remove-patient")
	@ResponseBody
	public String removeCustomer(@RequestParam int id) {
		
		PatientDetails patient = patientService.findCustomer(id);
		
		if(patient!=null){
			
			patientService.removeCustomer(id);

			return "removed";
		}
		else
			return "invalid";
	}

	@RequestMapping("/list-appointments")
	public String listAppointments(ModelMap map) {
		
		map.addAttribute("appointments", null);
		
		return "admin/list-appointments";
	}

	@RequestMapping("/list-queries")
	public String listQueries(@RequestParam(required=false) String type, ModelMap map) {
		
		if(type==null)
			type = "new";
		
		List<Query> queries = service.getQueries(type);
		
		map.addAttribute("queries", queries);
		
		return "admin/list-queries";
	}

	@RequestMapping("/list-doctor-invites")
	public String listInvites(ModelMap map) {
		
		List<DoctorInvite> invites = service.getDoctorInfoInvites();
		
		map.addAttribute("invites", invites);
		
		return "admin/list-invites";
	}

	@RequestMapping("/change-password")
	public String changePassword() {
		return "admin/change-password";
	}

/*********************** specialty section ********************/

	@RequestMapping("/create-specialty")
	public String createSpeciality() {
		
		return "admin/create-specialty";
	}

	@RequestMapping("/add-specialty")
	@ResponseBody
	public String addSpeciality(Speciality specialty) {
		
		Speciality existingSpeciality = service.findSpeciality(specialty.getSpecialityName());
		
		if(existingSpeciality==null){
			
			specialty.setIsActive("y");
			
			service.addSpeciality(specialty);

			return "created";
		}
		else
			return "exists";
	}

	@RequestMapping("/edit-specialty")
	public String editSpeciality(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		Speciality specialty = service.findSpeciality(id);
		
		if(specialty!=null){
			
			request.getSession().setAttribute("specialtyId", specialty.getId());
			
			map.addAttribute("found", true);
			map.addAttribute("specialty", specialty);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/edit-specialty";
	}

	@RequestMapping("/remove-specialty")
	@ResponseBody
	public String removeSpeciality(@RequestParam int id) {
		
		Speciality specialty = service.findSpeciality(id);
		
		if(specialty!=null){
			
			service.removeSpeciality(id);

			return "removed";
		}
		else
			return "invalid";
	}

	@RequestMapping("/update-specialty")
	@ResponseBody
	public String updateDoctorInfo(Speciality specialty, ModelMap map, HttpServletRequest request) {
		
		Object objSpecialityId = request.getSession().getAttribute("specialtyId");
		
		if(objSpecialityId!=null){
			
			long specialtyId = Long.parseLong(objSpecialityId.toString());
			
			Speciality existingSpeciality = service.findSpeciality(specialtyId);
			
			if(existingSpeciality!=null){
				
				specialty.setId(specialtyId);
				
				service.updateSpeciality(specialty);
	
				return "updated";
			}
			else
				return "invalid";
		}
		else
			return "invalid";
	}

	@RequestMapping("/list-specialties")
	public String listSpecialties(ModelMap map) {
		
		List<Speciality> specialties = service.getSpecialties();
		
		if(specialties!=null && !specialties.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("specialties", specialties);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-specialties";
	}

	/***************** re schedules **********************/
	
	@RequestMapping("/list-re-schedules")
	public String listReschedules(ModelMap map) {
		
		List<Reschedule> schedules = service.getReschedules();
		
		if(schedules!=null && !schedules.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("schedules", schedules);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-re-schedules";
	}	

	/***************** promo codes **********************/

	@RequestMapping("/list-promo-codes")
	public String listPromoCodes(ModelMap map) {
		
		List<PromoCode> promoCodes = service.getPromoCodes();
		
		if(promoCodes!=null && !promoCodes.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("promoCodes", promoCodes);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-promo-codes";
	}	

	@RequestMapping("/create-promo-code")
	public String createPromoCode() {
		
		return "admin/create-promo-code";
	}

	@RequestMapping("/add-promo-code")
	@ResponseBody
	public String savePromoCode(PromoCode promoCode) {
		
		PromoCode existingPromoCode = service.findPromoCode(promoCode.getCode());
		
		if(existingPromoCode==null){
			
			promoCode.setStatus("active");
			promoCode.setDateCreated(new Date());
			
			service.addPromoCode(promoCode);

			return "created";
		}
		else
			return "exists";
	}

	@RequestMapping("/edit-promo-code")
	public String editPromoCode(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		PromoCode promoCode = service.findPromoCode(id);
		
		if(promoCode!=null){
			
			request.getSession().setAttribute("promoCodeId", promoCode.getId());
			
			map.addAttribute("found", true);
			map.addAttribute("promoCode", promoCode);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/edit-promo-code";
	}

	@RequestMapping("/update-promo-code")
	@ResponseBody
	public String updatePromoCode(PromoCode promoCode, ModelMap map, HttpServletRequest request) {
		
		Object objPromoCodeId = request.getSession().getAttribute("promoCodeId");
		
		if(objPromoCodeId!=null){
			
			int promoCodeId = Integer.parseInt(objPromoCodeId.toString());
			
			PromoCode existingPromoCode = service.findPromoCode(promoCodeId);
			
			if(existingPromoCode!=null){
				
				promoCode.setId(promoCodeId);
				promoCode.setDateCreated(existingPromoCode.getDateCreated());
				promoCode.setStatus(existingPromoCode.getStatus());
				
				service.updatePromoCode(promoCode);
	
				return "updated";
			}
			else
				return "invalid";
		}
		else
			return "invalid";
	}

	@RequestMapping("/remove-promo-code")
	@ResponseBody
	public String removePromoCode(@RequestParam int id) {
		
		PromoCode promoCode = service.findPromoCode(id);
		
		if(promoCode!=null){
			
			service.removePromoCode(id);

			return "removed";
		}
		else
			return "invalid";
	}
	
	/*********************** health tips **********************/

	@RequestMapping("/list-health-tips")
	public String listHealthTips(ModelMap map) {
		
		List<HealthTip> healthTips = service.getHealthTips();
		
		map.addAttribute("healthTips", healthTips.isEmpty() ? null : healthTips);
		
		return "admin/list-health-tips";
	}

}
