package edu.jspiders.springmvc.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			@RequestParam(name="phoneno") long phoneno,
			@RequestParam(name="password") String password, ModelMap modelMap) {
		
		boolean adminadded = adminService.addAdmin(email,phoneno,password);
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
		@RequestParam(name="password") String password, ModelMap modelMap,HttpSession httpSession) {
		
		Admin autheniticateAdmin = adminService.autheniticateAdmin(email,password);
		if(autheniticateAdmin != null) {
			httpSession.setAttribute("auth_admin", autheniticateAdmin);
			return "home";
		}
		else {
			modelMap.addAttribute("message","invalid email & password");
			return "login";
		}
	}
	@RequestMapping(path="/delete-admin")
	protected String deleteAdmin(@RequestParam(name="id") int id,ModelMap modelMap,HttpSession httpSession) {
		boolean adminDeleted = adminService.deleteAdmin(id);
		if(adminDeleted) {
			modelMap.addAttribute("message","Admin Deleted");
			return "login";
		}
		else {
			modelMap.addAttribute("message","Something went wrong!");
			return "home";
		}
		
	}
	
	@RequestMapping(path="edit-admin")
	protected String editAdmin(@RequestParam(name="id") int id,ModelMap modelMap) {
		Admin admin = adminService.findAdminById(id);
		modelMap.addAttribute("admin", admin);
		return "edit_admin";
	}
	
	@RequestMapping(path="update_admin")
	protected String upadateAdmin(@RequestParam(name="id") int id,@RequestParam(name="email") String email,@RequestParam(name="password") String password,@RequestParam(name="phoneno") long phoneno,ModelMap modelMap) {
		boolean Adminupdated = adminService.updateAdmin(id,email,password,phoneno);
		if(Adminupdated)
			modelMap.addAttribute("message", "Admin Updated");
		else
			modelMap.addAttribute("message", "Something went Wrong");
		
		return "home";
		
	}
	
	@RequestMapping(path="/logout")
	protected String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}
	
	
	
}
