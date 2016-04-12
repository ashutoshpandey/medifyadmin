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

import com.medify.app.entity.HealthTip;
import com.medify.app.entity.Speciality;
import com.medify.app.service.AdminService;

@Controller
@RequestMapping("/")
public class HealthTipController {

	@Autowired
	private AdminService service;

	@RequestMapping("/create-health-tip")
	public String createHealthTip(ModelMap map) {
		
		List<Speciality> specialities = service.getSpecialties();

		map.addAttribute("specialities", specialities);
		
		return "admin/create-health-tip";
	}

	@RequestMapping("/add-health-tip")
	@ResponseBody
	public String saveHealthTip(HealthTip healthTip) {
		
		healthTip.setStatus("active");
		healthTip.setDateCreated(new Date());
		
		service.addHealthTip(healthTip);

		return "created";
	}

	@RequestMapping("/edit-health-tip")
	public String editHealthTip(@RequestParam int id, ModelMap map, HttpServletRequest request) {
		
		HealthTip healthTip = service.findHealthTip(id);
		
		if(healthTip!=null){
			
			request.getSession().setAttribute("healthTipId", healthTip.getId());
			
			map.addAttribute("found", true);
			map.addAttribute("healthTip", healthTip);
		}
		else
			map.addAttribute("found", false);
		
		return "admin/edit-promo-code";
	}

	@RequestMapping("/update-health-tip")
	@ResponseBody
	public String updateHealthTip(HealthTip healthTip, ModelMap map, HttpServletRequest request) {
		
		Object objHealthTipId = request.getSession().getAttribute("healthTipId");
		
		if(objHealthTipId!=null){
			
			int healthTipId = Integer.parseInt(objHealthTipId.toString());
			
			HealthTip existingHealthTip = service.findHealthTip(healthTipId);
			
			if(existingHealthTip!=null){
				
				healthTip.setId(healthTipId);
				healthTip.setDateCreated(existingHealthTip.getDateCreated());
				healthTip.setStatus(existingHealthTip.getStatus());
				
				service.updateHealthTip(healthTip);
	
				return "updated";
			}
			else
				return "invalid";
		}
		else
			return "invalid";
	}

	@RequestMapping("/remove-health-tip")
	@ResponseBody
	public String removeHealthTip(@RequestParam int id) {
		
		HealthTip healthTip = service.findHealthTip(id);
		
		if(healthTip!=null){
			
			service.removeHealthTip(id);

			return "removed";
		}
		else
			return "invalid";
	}
	
	@RequestMapping("/list-health-tips")
	public String listHealthTips(ModelMap map) {
		
		List<HealthTip> healthTips = service.getHealthTips();
		
		map.addAttribute("healthTips", healthTips.isEmpty() ? null : healthTips);
		
		return "admin/list-health-tips";
	}
}
