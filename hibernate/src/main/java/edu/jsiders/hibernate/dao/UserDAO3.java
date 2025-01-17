package edu.jsiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate.dto.UserDTO;

public class UserDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userToBeDelected = entityManager.find(UserDTO.class, 5);
		if(userToBeDelected !=null) {
			entityTransaction.begin();
			entityManager.remove(userToBeDelected);
			entityTransaction.commit();
			System.out.println("user Deleted!");
		}else {
			System.out.println("user not found ,invalid user id!!");
		}
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
		
		if(entityManager != null)
			entityManager.close();
		
		if(entityTransaction != null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		
	}
}
