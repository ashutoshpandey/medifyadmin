package com.medify.app.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.medify.app.entity.Doctor;
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
			e.printStackTrace();
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
		
		String[] errorRow = new String[10];
		
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

			String firstName;
			String lastName;
			String emailID;
			String contactNumber;
			String gender;
			String address;
			String zipCode;
			String city;
			String state;
			String country;
			
			for (int i = 1; i < sheet.getRows(); i++) {
				
				int wrongCount = 0;								
				
				try {
					try {
						firstName = sheet.getCell(0, i).getContents();
						
						errorRow[0] = "OK";
						
						if(firstName==null){
							errorRow[0] = "Cannot read first name";
							++wrongCount;
						}
						if(firstName.length()==0){
							errorRow[0] = "No value provided for first name";
							++wrongCount;
						}
						
						firstName = firstName==null ? "" : firstName;
						
					} catch (Exception ex) {
						status = "field";
						firstName = "";
						++wrongCount;
					}
					
					System.out.println("1. Wrong count = " + wrongCount);

					try {
						errorRow[1] = "";
						
						lastName = sheet.getCell(1, i).getContents();
						
						lastName = lastName==null ? "" : lastName;
						
					} catch (Exception ex) {
						lastName = "";
					}

					try {
						errorRow[2] = "Email : OK";
						
						emailID = sheet.getCell(2, i).getContents();
						
						if(emailID!=null && emailID.length()>5){
							
							String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
							boolean valid = emailID.matches(EMAIL_REGEX);
	
							if(!valid){
								emailID = "";
								errorRow[2] = "Invalid email id";
								++wrongCount;
							}
						}
						else{
							//errorRow[2] = "Cannot read email";
							//status = "field";
							emailID = "";
							//++wrongCount;
						}
						
					} catch (Exception ex) {
						errorRow[2] = "Error in reading email";
						status = "field";
						emailID = "";
						++wrongCount;
					}
					
					System.out.println("3. Wrong count = " + wrongCount);
					
					try {
						errorRow[3] = "Contact number : OK";
						
						contactNumber = sheet.getCell(3, i).getContents();
						
						if(contactNumber==null || contactNumber.trim().length()!=10){
							++wrongCount;
							contactNumber = "";
							errorRow[3] = "Invalid contact number";
						}
						
						if(contactNumber==null || contactNumber.trim().length()==0){
							contactNumber = "";
						}

					} catch (Exception ex) {
						status = "field";
						contactNumber = "";
						++wrongCount;
					}
					
					try {
						errorRow[5] = "Gender : OK";
						
						gender = sheet.getCell(4, i).getContents();
						
						if(gender==null){
							errorRow[5] = "Gender not provided, assuming male";
						}
						else{
							String temp = gender.toLowerCase();
							
							if(temp.equals("male") || temp.equals("female"))
								;
							else{
								errorRow[5] = "Invalid value for gender, assuming male";
								++wrongCount;
							}
						}

						gender = gender==null ? "male" : gender;
						
					} catch (Exception ex) {
						status = "field";
						gender = "male";
					}
					
					try {
						errorRow[5] = "Address : OK";
						
						address = sheet.getCell(5, i).getContents();
						
						if(address==null){
							errorRow[5] = "Address not provided";
						}
						
					} catch (Exception ex) {
						status = "field";
						address = "";
					}
					
					try {
						errorRow[6] = "ZipCode : OK";
						
						zipCode = sheet.getCell(6, i).getContents();
						
						Integer.parseInt(zipCode);
						
					} catch (Exception ex) {
						errorRow[6] = "Invalid zipcode";
						status = "field";
						zipCode = "";
						++wrongCount;
					}
					
					try {
						errorRow[7] = "City : OK";
						
						city = sheet.getCell(7, i).getContents();
						
						if(city==null){
							errorRow[7] = "Cannot read city, considering blank";
						}
						else if(city.length()==0){
							errorRow[7] = "City not provided, considering blank";
						}
						
						city = city==null ? "" : city;
						
					} catch (Exception ex) {
						city = "";
					}
					
					try {
						errorRow[8] = "State : OK";
						
						state = sheet.getCell(8, i).getContents();
						
						if(state==null){
							errorRow[8] = "Cannot read state, considering blank";
						}
						else if(city.length()==0){
							errorRow[8] = "State not provided, considering blank";
						}
						
						state = state==null ? "" : state;
						
					} catch (Exception ex) {
						state = "";
					}
					
					try {
						errorRow[9] = "Country : OK";
						
						country = sheet.getCell(9, i).getContents();
						
						if(country==null){
							errorRow[9] = "Cannot read country, rejecting the record";
							
							wrongCount+=3;		// just making sure, it value is greater than 2(if wrongCount>2, record will be rejected)
						}
						else if(country.length()==0){
							errorRow[9] = "Country not provided, rejecting the record";

							wrongCount+=3;		// just making sure, it value is greater than 2(if wrongCount>2, record will be rejected)
						}
						
					} catch (Exception ex) {
						
						errorRow[9] = "Cannot read country, rejecting record";

						wrongCount+=3;		// just making sure, it value is greater than 2(if wrongCount>2, record will be rejected)								

						status = "field";
						
						country = "";
					}
					
					System.out.println("10. Wrong count = " + wrongCount);

					recordStatusList.add(errorRow);
					
					if(wrongCount<2){
						Doctor doctor = new Doctor();
	
						doctor.setFirstName(firstName);
						doctor.setLastName(lastName);
						doctor.setEmailID(emailID);
						doctor.setContactNumber(contactNumber);
						doctor.setGender(gender);
						doctor.setAddress(address);
						doctor.setZipCode(zipCode);
						doctor.setCity(city);
						doctor.setState(state);
						doctor.setCountry(country);
						doctor.setDateCreated(new Date());
						doctor.setState("active");
	
						boolean added = service.addDoctor(doctor);
						
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
			statusCountList.add("Rejected records = " + rejectedCount);
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

		String firstName = sheet.getCell(0, 0).getContents().toLowerCase();
		String lastName = sheet.getCell(1, 0).getContents().toLowerCase();
		String email = sheet.getCell(2, 0).getContents().toLowerCase();
		String contactNumber = sheet.getCell(3, 0).getContents().toLowerCase();
		String gender = sheet.getCell(4, 0).getContents().toLowerCase();
		String address = sheet.getCell(5, 0).getContents().toLowerCase();
		String zipcode = sheet.getCell(6, 0).getContents().toLowerCase();
		String city = sheet.getCell(7, 0).getContents().toLowerCase();
		String state = sheet.getCell(8, 0).getContents().toLowerCase();
		String country = sheet.getCell(9, 0).getContents().toLowerCase();

		boolean valid = true;
		
		valid = valid && firstName.equals("first name");
		valid = valid && lastName.equals("last name");
		valid = valid && email.equals("email");
		valid = valid && contactNumber.equals("contact");
		valid = valid && gender.equals("gender");
		valid = valid && address.equals("address");
		valid = valid && zipcode.equals("zip");
		valid = valid && city.equals("city");
		valid = valid && state.equals("state");
		valid = valid && country.equals("country");
		
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
	public String downloadSample(HttpServletRequest request, HttpServletResponse response, String file){
		String path = UploadController.class.getResource("/com/medify/data/" + file).getFile();

	    response.setContentType("application/force-download");
	    response.setContentType("application/vnd.ms-excel");
	    response.setHeader("Content-Disposition", "attachment; filename=" + file); 

	    try{
	        File fi = new File(path);
	        InputStream in = new BufferedInputStream(new FileInputStream(fi));
	        ServletOutputStream out = response.getOutputStream();
	        IOUtils.copy(in, out);
	        response.flushBuffer();

	        return null;
	    }
	    catch(Exception ex){
	        return null;
	    }
	}
}
