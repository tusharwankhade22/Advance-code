package edu.jsiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.AadharCard;
import edu.jsiders.hibernate2.dto.User;

public class UserDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		User user = entityManager.find(User.class, 1);
		entityManager.remove(user);
		AadharCard aadharCard = entityManager.find(AadharCard.class, 1);
		entityManager.remove(aadharCard);
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
