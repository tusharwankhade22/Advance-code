package edu.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jspiders.springmvc.dto.Admin;
import edu.jspiders.springmvc.dto.Student;
import edu.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(path="/add-student")
	protected String addStudent(@RequestParam(name="name") String name,
			@RequestParam(name="email") String email,
			@RequestParam(name="phoneno") long phoneno,
			@RequestParam(name="course") String course,ModelMap modelMap,HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin !=null) {
			boolean studentadded = studentService.addStudent(name,email,phoneno,course);
			List<Student> students = studentService.findAllStudents();
			if(studentadded) {
				modelMap.addAttribute("students", students);
				modelMap.addAttribute("message", "Student added succesfully");
			}else {
				if(students !=null)
					modelMap.addAttribute("students", students);
				modelMap.addAttribute("message", "something went wrong");
			}
			
			return "students";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping(path="/students")
	protected String findAllStudents(ModelMap modelMap,HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin !=null) {
			List<Student> students = studentService.findAllStudents();
			
			if(students !=null)
				modelMap.addAttribute("students", students);
			else
				modelMap.addAttribute("message", "No Data Available");
			return "students";	
		}
		else 
			return "login";
	}
	
	@RequestMapping("/delete-student")
	protected String deleteStudentById(@RequestParam(name="id") int id,ModelMap modelMap,HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin != null) {
			boolean studentDeleted = studentService.deleteStudentById(id);
			
			List<Student> students = studentService.findAllStudents();
			if(studentDeleted) {
				if(students !=null)
					modelMap.addAttribute("students", students);
				else 
					modelMap.addAttribute("message", "No Data Available");
			}
			else {
				modelMap.addAttribute("message", "Something Went Wrong");
				if(students !=null)
					modelMap.addAttribute("students", students);
				else 
					modelMap.addAttribute("message", "No Data Available");
			}	
			return "students";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping(path="/edit-student")
	protected String getEditStudentPage(@RequestParam(name="id") int id,ModelMap modelMap,HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("auth_admin");
		if(admin !=null) {
			Student student = studentService.findStudentById(id);
			modelMap.addAttribute("student", student);
			return "edit_student";
		}else {
			return "login";
		}
		
	}
	
	@RequestMapping(path="/upadte-student")
	protected String updateStudent(@RequestParam(name="id") int id,
			@RequestParam(name="name") String name,
			@RequestParam(name="email") String email,
			@RequestParam(name="phoneno") long phoneno,
			@RequestParam(name="course") String course, ModelMap modelMap) {
		boolean updateStudent = studentService.updateStudent(id,name,email,phoneno,course);
		List<Student> students = studentService.findAllStudents();
		
		if(updateStudent) {
			modelMap.addAttribute("message", "Student Updated");
		}
		else {
			modelMap.addAttribute("message", "Something Went Wrong");
		}
		modelMap.addAttribute("students", students);
		return "students";
	}
	
	@RequestMapping(path="/mobile")
	protected String findStudentByMobile(@RequestParam(name="phonono") long phonono,ModelMap modelMap) {
		Student student = studentService.findStudentByMobile(phonono);
		if(student !=null)
			modelMap.addAttribute("student", student);
		else
			modelMap.addAttribute("message", "No Data Available");
		return "student_mobile";
	}
	
	@RequestMapping(path="/email")
	protected String findStudentByEmail(@RequestParam(name="email") String email,ModelMap modelMap) {
		Student student = studentService.findStudentByEmail(email);
		if(student !=null)
			modelMap.addAttribute("student", student);
		else
			modelMap.addAttribute("message", "No Data Available");
		return "Student_email";
	}
	
	@RequestMapping(path="/name")
	protected String findStudentByName(@RequestParam(name="name") String name,ModelMap modelMap) {
		List<Student> students = studentService.findStudentByName(name);
		if(students !=null) {
			modelMap.addAttribute("students", students);
		}
		else {
			modelMap.addAttribute("message", "No Data Available");
		}
		return "student_name";
	}
	
	@RequestMapping(path="/course")
	protected String findStudentbyCourse(@RequestParam(name="course") String course,ModelMap modelMap) {
		List<Student> students = studentService.findStudentbyCourse(course);
		if(students !=null) {
			modelMap.addAttribute("students", students);
		}
		else {
			modelMap.addAttribute("message", "No Data Available");
		}
		return "student_course";
		
	}
	
}
