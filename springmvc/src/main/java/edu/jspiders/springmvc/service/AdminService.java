package edu.jspiders.springmvc.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dao.AdminDAO;
import edu.jspiders.springmvc.dto.Admin;

@Component
public class AdminService {
	
	@Autowired
	AdminDAO adminDAO;

	public boolean addAdmin(String email, long mob, String password) {
		Admin admin=new Admin();
		admin.setEmail(email);
		admin.setMob(mob);
		admin.setPassword(password);
		
		try {
			adminDAO.addAdmin(admin);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public Admin autheniticateAdmin(String email, String password) {
		try {
			Admin admin= adminDAO.autheniticateAdmin(email,password);
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password) ) {
				return admin;
			}
			else {
				return null;
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
