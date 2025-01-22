package edu.jspiders.springmvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jspiders.springmvc.dto.Admin;
import edu.jspiders.springmvc.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(path="/add-admin",method=RequestMethod.POST)
	protected String addAdmin(@RequestParam(name="email") String email,
			@RequestParam(name="phoneno") String phoneno,
			@RequestParam(name="password") String password, ModelMap modelMap) {
		long mob=Long.parseLong(phoneno);
		
		boolean adminadded = adminService.addAdmin(email,mob,password);
		if(adminadded) {
			modelMap.addAttribute("message","Admin added Successfully");
			return "login";
		}
		else {
			modelMap.addAttribute("message","Something went Wrong");
			return "sign_up";
		}
	}
	
	@RequestMapping(path="/admin-auth",method=RequestMethod.POST)
	protected String autheniticateAdmin(@RequestParam(name="email") String email,
			@RequestParam(name="password") String password, ModelMap modelMap) {
		Admin autheniticateAdmin = adminService.autheniticateAdmin(email,password);
		if(autheniticateAdmin != null) {
			return "home";
		}
		else {
			modelMap.addAttribute("message","invalid email & password");
			return "login";
		}
	}
	
}
