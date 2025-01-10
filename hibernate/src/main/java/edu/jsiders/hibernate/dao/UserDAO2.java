package edu.jsiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.jsiders.hibernate.dto.UserDTO;

public class UserDAO2 { 
	 
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, 3);
		if(userDTO !=null)
			System.out.println(userDTO);
		else
			System.out.println("user not found, invalid user id!!");
		
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory !=null)
			entityManagerFactory.close();
		if(entityManager !=null)
			entityManager.close();
	}
}
