package edu.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jspiders.springmvc.dto.Admin;

@Controller
public class PageController {
	
	@RequestMapping(path="/sign-up-page")
	protected String getSignUpPage() {
		return "sign_up";
	}
	
	@RequestMapping(path="/login-page")
	protected String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(path="/home")
	protected String getHomePage(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin !=null)
		  return "home";
		else
			return "login";
	}
	
	@RequestMapping(path="/add-student-page")
	protected String getAddStudentPage(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin!=null) {
			return "add_student";
		}else {
			return "login";
		}
		
	}
	
	@RequestMapping(path="/find-student-phoneno")
	protected String getFindStudentbyPhoneno(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin!=null) {
			return "findStudentbyPhoneno";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(path="/find-student-email")
	protected String getFindStudentbyEmail(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin!=null) {
			return "findStudentbyEmail";
		}else {
			return "login";
		}
	}
	@RequestMapping(path="/find-student-name")
	protected String getFindStudentbyName(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin!=null) {
			return "findStudentbyName";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(path="/find-student-course")
	protected String getFindStudentbyCourse(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin!=null) {
			return "findStudentbyCourse";
		}else {
			return "login";
		}
	}
}



