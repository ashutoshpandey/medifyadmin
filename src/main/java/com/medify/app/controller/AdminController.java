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

import com.medify.app.entity.Doctor;
import com.medify.app.entity.DoctorInvite;
import com.medify.app.entity.HealthTip;
import com.medify.app.entity.Patient;
import com.medify.app.entity.PromoCode;
import com.medify.app.entity.Query;
import com.medify.app.entity.Reschedule;
import com.medify.app.entity.Specialty;
import com.medify.app.service.AdminService;
import com.medify.app.service.CustomerService;

@Controller
@RequestMapping("/")
public class AdminController {

	@Autowired
	private AdminService service;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/admin-section")
	public String adminSection() {
		return "admin/admin-section";
	}
	
	@RequestMapping("/get-doctor")
	public String getDoctor(@RequestParam int id, ModelMap map) {
		
		Doctor doctor = service.findDoctor(id);
		
		if(doctor!=null){
			map.addAttribute("found", true);
			map.addAttribute("doctor", doctor);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/get-doctor";
	}

	@RequestMapping("/edit-doctor")
	public String editDoctor(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		Doctor doctor = service.findDoctor(id);
		
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
	public String removeDoctor(@RequestParam int id) {
		
		Doctor doctor = service.findDoctor(id);
		
		if(doctor!=null){
			
			service.removeDoctor(id);

			return "removed";
		}
		else
			return "invalid";
	}

	@RequestMapping("/update-doctor")
	@ResponseBody
	public String updateDoctor(Doctor doctor, ModelMap map, HttpServletRequest request) {
		
		Object objDoctorId = request.getSession().getAttribute("doctorId");
		
		if(objDoctorId!=null){
			
			int doctorId = Integer.parseInt(objDoctorId.toString());
			
			Doctor existingDoctor = service.findDoctor(doctorId);
			
			if(existingDoctor!=null){
				
				doctor.setId(doctorId);
				doctor.setDateCreated(existingDoctor.getDateCreated());
				doctor.setStatus(existingDoctor.getStatus());
				
				service.updateDoctor(doctor);
	
				return "updated";
			}
			else
				return "invalid";
		}
		else
			return "invalid";
	}

	@RequestMapping("/list-doctors")
	public String listDoctors(ModelMap map) {
		
		List<Doctor> doctors = service.getDoctors();
		
		if(doctors!=null && !doctors.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("doctors", doctors);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-doctors";
	}

	@RequestMapping("/list-customers")
	public String listCustomers(ModelMap map) {
		
		List<Patient> customers = customerService.getCustomers();
		
		if(customers!=null && !customers.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("customers", customers);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-customers";
	}

	@RequestMapping("/remove-customer")
	@ResponseBody
	public String removeCustomer(@RequestParam int id) {
		
		Patient customer = customerService.findCustomer(id);
		
		if(customer!=null){
			
			customerService.removeCustomer(id);

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
		
		List<DoctorInvite> invites = service.getDoctorInvites();
		
		map.addAttribute("invites", invites);
		
		return "admin/list-invites";
	}

	@RequestMapping("/change-password")
	public String changePassword() {
		return "admin/change-password";
	}

/*********************** specialty section ********************/

	@RequestMapping("/edit-specialty")
	public String editSpecialty(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		Specialty specialty = service.findSpecialty(id);
		
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
	public String removeSpecialty(@RequestParam int id) {
		
		Specialty specialty = service.findSpecialty(id);
		
		if(specialty!=null){
			
			service.removeSpecialty(id);

			return "removed";
		}
		else
			return "invalid";
	}

	@RequestMapping("/update-specialty")
	@ResponseBody
	public String updateDoctor(Specialty specialty, ModelMap map, HttpServletRequest request) {
		
		Object objSpecialtyId = request.getSession().getAttribute("specialtyId");
		
		if(objSpecialtyId!=null){
			
			int specialtyId = Integer.parseInt(objSpecialtyId.toString());
			
			Specialty existingSpecialty = service.findSpecialty(specialtyId);
			
			if(existingSpecialty!=null){
				
				specialty.setId(specialtyId);
				specialty.setDateCreated(existingSpecialty.getDateCreated());
				specialty.setStatus(existingSpecialty.getStatus());
				
				service.updateSpecialty(specialty);
	
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
		
		List<Specialty> specialties = service.getSpecialties();
		
		if(specialties!=null && !specialties.isEmpty()){
			map.addAttribute("found", true);
			map.addAttribute("specialties", specialties);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/list-specialties";
	}

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
