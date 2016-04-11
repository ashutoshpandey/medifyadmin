package com.medify.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.medify.app.entity.DoctorInfo;
import com.medify.app.service.AdminService;

import jxl.Sheet;
import jxl.Workbook;

@Controller
@RequestMapping("/")
public class UploadController {

	@Autowired
	private AdminService service;

	@RequestMapping("/upload-doctors")
	public String showForm() {
		return "admin/upload-doctors";
	}

	@RequestMapping(value = "/upload-doctors-now", method = RequestMethod.POST)
	@ResponseBody
	public String processUpload(MultipartHttpServletRequest request, HttpServletRequest req,
			HttpServletResponse response, ModelMap map) {

		String status = "fine";
		
		Iterator<String> itr = request.getFileNames();

		MultipartFile file = request.getFile(itr.next());
		String orgFileName = file.getOriginalFilename();
		
		String filePath = req.getSession().getServletContext().getRealPath("/uploads/") + "/" + orgFileName;

		File dest = new File(filePath);

		try {
			file.transferTo(dest);
		} catch (Exception e) {
			status = "severe";
			System.out.println("Cannot upload file : " + e.getMessage());
			return null;
		}
		
		System.out.println("File uploaded...");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		
		List<String[]> recordStatusList = new ArrayList<String[]>(); 
		List<String> statusCountList = new ArrayList<String>();
		
		if("fine".equals(status)){
			status = saveToDatabase(dest, req, recordStatusList, statusCountList);
		}

		if(status.equals("field"))
			status = "";
		
		map.addAttribute("errorMessage", status);
		
		request.getSession().setAttribute("uploadStatus", status);
		request.getSession().setAttribute("recordStatusList", recordStatusList);
		request.getSession().setAttribute("statusCountList", statusCountList);
		
		System.out.println("Status = " + status);
		
		return "uploaded";
	}

	private String saveToDatabase(File inputWorkbook, HttpServletRequest req, List<String[]> recordStatusList, List<String> statusCountList) {

		String status = "uploaded";
		int addedCount = 0;
		int rejectedCount = 0;
		
		String[] errorRow = new String[15];
		
		Workbook w = null;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			// Get the first sheet
			Sheet sheet = w.getSheet(0);

			boolean headersValid = true;
			try{
				headersValid = areHeadersValid(sheet);
			}
			catch(Exception ex){
				headersValid = false;
			}
			
			if(headersValid){
			// i=0 means header

			String name;
			String email;
			int age;
			String phoneNumber;
			String gender;
			String city;
			String aboutMe;
			String clinicAddress;
			int consultFeeCall;
			int consultFeeText;
			String education;
			String location;
			String totalEx;
			
			for (int i = 1; i < sheet.getRows(); i++) {

				int wrongCount = 0;								
				
				try {
					try {
						name = sheet.getCell(0, i).getContents();
						
						errorRow[0] = "OK";
						
						name = name==null ? "" : name;
						
					} catch (Exception ex) {
						status = "field";
						name = "";
						++wrongCount;
					}

					try {
						errorRow[1] = "Email : OK";
						
						email = sheet.getCell(1, i).getContents();
						
						if(email!=null && email.length()>5){
							
							String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
							boolean valid = email.matches(EMAIL_REGEX);
	
							if(!valid){
								email = "";
							}
						}
						else{
							email = "";
						}
						
					} catch (Exception ex) {
						email = "";
					}
					
					try {
						errorRow[2] = "Age : OK";
						
						age = Integer.parseInt(sheet.getCell(2, i).getContents());
						
					} catch (Exception ex) {
						age = 0;
					}
					
					try {
						errorRow[3] = "Phone number : OK";
						
						phoneNumber = sheet.getCell(3, i).getContents();
						
						if(phoneNumber==null || phoneNumber.trim().length()!=10){
							phoneNumber = "";
						}
						
						if(phoneNumber==null || phoneNumber.trim().length()==0){
							phoneNumber = "";
						}

					} catch (Exception ex) {
						phoneNumber = "";
					}
					
					try {
						errorRow[4] = "Gender : OK";
						
						gender = sheet.getCell(4, i).getContents();
						
						if(gender==null){
							errorRow[4] = "Gender not provided, assuming male";
						}
						else{
							String temp = gender.toLowerCase();
							
							if(temp.equals("male") || temp.equals("female"))
								;
							else{
								gender = "male";
							}
						}

						gender = gender==null ? "male" : gender;
						
					} catch (Exception ex) {
						gender = "male";
					}
					
					try {
						errorRow[5] = "City : OK";
						
						city = sheet.getCell(5, i).getContents();

						city = city==null ? "" : city;
						
					} catch (Exception ex) {
						city = "";
					}
					
					try {
						errorRow[6] = "About me : OK";
						
						aboutMe = sheet.getCell(6, i).getContents();
						
						aboutMe = aboutMe==null ? "" : aboutMe;

					} catch (Exception ex) {
						aboutMe = "";
					}
					
					try {
						errorRow[7] = "Clinic address : OK";
						
						clinicAddress = sheet.getCell(7, i).getContents();
						
						clinicAddress = clinicAddress==null ? "" : clinicAddress;
						
					} catch (Exception ex) {
						clinicAddress = "";
					}
					
					try {
						errorRow[8] = "Consult fee call : OK";
						
						consultFeeCall = Integer.parseInt(sheet.getCell(8, i).getContents());
						
					} catch (Exception ex) {
						consultFeeCall = 0;
					}
					
					try {
						errorRow[9] = "Consult fee text : OK";
						
						consultFeeText = Integer.parseInt(sheet.getCell(9, i).getContents());
						
					} catch (Exception ex) {
						consultFeeText = 0;
					}
					
					try {
						errorRow[10] = "Education : OK";
						
						education = sheet.getCell(10, i).getContents();

					} catch (Exception ex) {
						education = "";
						System.out.println("Error reading education : " + ex.getMessage());
					}
					
					try {
						errorRow[11] = "Location : OK";
						
						location = sheet.getCell(11, i).getContents();
						
					} catch (Exception ex) {
						location = "";
						System.out.println("Error reading location : " + ex.getMessage());
					}
					
					try {
						errorRow[12] = "Total experience : OK";
						
						totalEx = sheet.getCell(12, i).getContents();
						
					} catch (Exception ex) {
						totalEx = "";
						ex.printStackTrace();
					}
					
					recordStatusList.add(errorRow);
					
					if(wrongCount<2){
						DoctorInfo doctor = new DoctorInfo();
	
						doctor.setName(name);
						doctor.setEmail(email);
						doctor.setAge(age);
						doctor.setGender(gender);
						doctor.setCity(city);
						doctor.setAboutMe(aboutMe);
						doctor.setClinicAddress(clinicAddress);
						doctor.setConsultFeeCall(consultFeeCall);
						doctor.setConsultFeeText(consultFeeText);
						doctor.setEducation(education);
						doctor.setIsEnabled('y');
						doctor.setLocation(location);
						doctor.setPhoneNumber(phoneNumber);
						doctor.setTotalEx(totalEx);
	
						System.out.println(education + " : " + location + " : " + phoneNumber);
						
						boolean added = service.addDoctorInfo(doctor);
						
						if(added)
							addedCount++;
					}
					else{
						rejectedCount++;
					}
					
				} catch (Exception ex) {
					status = "format";
				}
								
			}

			statusCountList.add("Added records = " + addedCount);
			statusCountList.add("<br/>Rejected records = " + rejectedCount);
			sheet = null;
			}
			else{
				status = "Invalid file";
				statusCountList.add("No records added");
			}

		} catch (Exception e) {
			status = "severe";
		}
		finally{
			try {
				if(w!=null)
					w.close();
			} catch (Exception e2) {
			}
		}
		
		return status;
	}

	private boolean areHeadersValid(Sheet sheet) {

		String name = sheet.getCell(0, 0).getContents().toLowerCase();
		String email = sheet.getCell(1, 0).getContents().toLowerCase();
		String age = sheet.getCell(2, 0).getContents().toLowerCase();
		String phoneNumber = sheet.getCell(3, 0).getContents().toLowerCase();
		String gender = sheet.getCell(4, 0).getContents().toLowerCase();
		String city = sheet.getCell(5, 0).getContents().toLowerCase();
		String aboutMe = sheet.getCell(6, 0).getContents().toLowerCase();
		String clinicAddress = sheet.getCell(7, 0).getContents().toLowerCase();
		String consultFeeCall = sheet.getCell(8, 0).getContents().toLowerCase();
		String consultFeeText = sheet.getCell(9, 0).getContents().toLowerCase();
		String education = sheet.getCell(10, 0).getContents().toLowerCase();
		String location = sheet.getCell(11, 0).getContents().toLowerCase();
		String totalExperience = sheet.getCell(12, 0).getContents().toLowerCase();

		boolean valid = true;
		
		valid = valid && name.equals("name");
		valid = valid && email.equals("email");
		valid = valid && age.equals("age");
		valid = valid && phoneNumber.equals("phone number");
		valid = valid && gender.equals("gender");
		valid = valid && city.equals("city");
		valid = valid && aboutMe.equals("about me");
		valid = valid && clinicAddress.equals("clinic address");
		valid = valid && consultFeeCall.equals("consult fee call");
		valid = valid && consultFeeText.equals("consult fee text");
		valid = valid && education.equals("education");
		valid = valid && location.equals("location");
		valid = valid && totalExperience.equals("total experience");
		
		return valid;
	}
	
	@RequestMapping("/upload-doctor-status")
	public String getUploadStatus(HttpServletRequest request, ModelMap map){
		
		if(request.getSession().getAttribute("uploadstatus")!=null){
			
			String status = request.getSession().getAttribute("uploadStatus").toString();

			@SuppressWarnings("unchecked")
			List<String[]> recordStatusList = (List<String[]>) request.getSession().getAttribute("recordStatusList"); 
			@SuppressWarnings("unchecked")
			List<String> statusCountList = (List<String>) request.getSession().getAttribute("statusCountList");
			
			map.addAttribute("uploadStatus", status);
			map.addAttribute("recordStatusList", recordStatusList);
			map.addAttribute("statusCountList", statusCountList);

			request.getSession().setAttribute("uploadStatus", null);
			request.getSession().setAttribute("recordStatusList", null);
			request.getSession().setAttribute("statusCountList", null);
		}
		else {
			map.addAttribute("uploadstatus", "nodata");
		}
		
		return "admin/uploaded";
	}
	
	@RequestMapping("/download-sample")
	public void downloadSample(HttpServletRequest request, HttpServletResponse response){

		try{
			URL url = getClass().getResource("/sample.xls");
            File f = new File(url.toURI());

            if (f.exists()) {
                response.setContentType("application/xls");
                response.setContentLength(new Long(f.length()).intValue());
                response.setHeader("Content-Disposition", "attachment; filename=sample.xls");
                FileCopyUtils.copy(new FileInputStream(f), response.getOutputStream());
            } else {
                System.out.println(f.getAbsolutePath()+ " does not exist");
            }
		}
		catch(Exception ex){
			
		}
	}
}
