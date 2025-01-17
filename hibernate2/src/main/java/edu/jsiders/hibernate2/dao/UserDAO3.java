package edu.jsiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.User;

public class UserDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		try {
			openConnection();
			User user = entityManager.find(User.class, 3);
			if(user !=null) {
				user.setName("Tushar Wankhade");
				entityTransaction.begin();
				entityManager.persist(user);
				entityTransaction.commit();
				System.out.println("user updated sucessfully");
			}else
				System.out.println("user not found!");
		} finally {
			closeConnection();
		}
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory !=null)
			entityManager.close();
		if(entityManager !=null)
			entityManager.close();
		if(entityTransaction !=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
}
