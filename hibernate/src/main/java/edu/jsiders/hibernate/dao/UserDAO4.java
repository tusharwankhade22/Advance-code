package edu.jsiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate.dto.UserDTO;

public class UserDAO4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userToBeUpadated = entityManager.find(UserDTO.class, 3);
		if(userToBeUpadated !=null) {
			userToBeUpadated.setPassword("gayu@26");
			userToBeUpadated.setMobile(9876543210l);
			entityTransaction.begin();
			entityManager.persist(userToBeUpadated);
			entityTransaction.commit();
			System.out.println("updated Successfully");
		}else {
			System.out.println("user not found,invalid user id!");
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
		if(entityManager !=null)
			entityManager.close();
		if(entityTransaction !=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
}
