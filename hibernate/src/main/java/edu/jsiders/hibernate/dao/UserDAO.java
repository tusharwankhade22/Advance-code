package edu.jsiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate.dto.UserDTO;

public class UserDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		UserDTO userDTO=new UserDTO();
		userDTO.setName("Ramesh");
		userDTO.setEmail("ramesh07@gmail.com");
		userDTO.setMobile(9698346419l); 
		userDTO.setPassword("ramesh@68");
		
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory !=null)
			entityManagerFactory.close();
		
		if(entityManager !=null)
			entityManager.close();
		
		if(entityTransaction !=null) 
			if(entityTransaction.isActive())
				entityTransaction.rollback();
			
	}
	
	
}
