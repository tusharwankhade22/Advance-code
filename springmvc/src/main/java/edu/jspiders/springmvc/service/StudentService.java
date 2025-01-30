package edu.jspiders.springmvc.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dao.StudentDAO;
import edu.jspiders.springmvc.dto.Student;
@Component
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public boolean addStudent(String name, String email, long phoneno, String course) {
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhoneno(phoneno);
		student.setCourse(course);
		try {
			studentDAO.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Student> findAllStudents() {
		List<Student> students = studentDAO.findAllStudents();
		if(students.size()>0)
			return students;
		else
			return null;
	}

	public boolean deleteStudentById(int id) {
		try {
			studentDAO.deleteStudentById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Student findStudentById(int id) {
		return studentDAO.findStudentById(id);
	}

	public boolean updateStudent(int id, String name, String email, long phoneno, String course) {
		try {
			studentDAO.updateStudent(id,name,email,phoneno,course);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Student findStudentByMobile(long phonono) {
		try {
			return studentDAO.findStudentByMobile(phonono);
			
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Student findStudentByEmail(String email) {
		try {
			return studentDAO.findStudentByEmail(email);
			
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Student> findStudentByName(String name) {
		try {
			return studentDAO.findStudentByName(name);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public List<Student> findStudentbyCourse(String course) {
	    try {
			return studentDAO.findStudentbyCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
