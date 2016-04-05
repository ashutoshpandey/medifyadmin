package com.medify.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medify.app.entity.Admin;
import com.medify.app.service.AdminService;

@Controller
@RequestMapping("/")
public class AuthenticationController {

	@Autowired
	private AdminService service;

	@RequestMapping("/login")
	public String login() {
		
		return "admin/login";
	}

	@RequestMapping("/is-valid-admin")
	@ResponseBody
	public String adminSection(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) {
		
		boolean valid = service.isValidAdmin(new Admin(userName, password));
		
		if(valid)
			request.getSession().setAttribute("userName", userName);
		
		return valid ? "correct" : "wrong";
	}

	@RequestMapping("/update-password")
	@ResponseBody
	public String updatePassword(@RequestParam String password, HttpServletRequest request) {
		
		String userName = request.getSession().getAttribute("userName").toString();
		
		boolean updated = service.updatePassword(userName, password);
					
		return updated ? "updated" : "failed";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		request.getSession().invalidate();
		
		return "redirect:login";
	}
}
