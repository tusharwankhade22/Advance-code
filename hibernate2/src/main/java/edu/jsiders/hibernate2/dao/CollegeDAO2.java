package edu.jsiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.College1;
import edu.jsiders.hibernate2.dto.Teacher;

public class CollegeDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			entityTransaction.begin();
			Teacher teacher1 = entityManager.find(Teacher.class, 1);
			entityManager.remove(teacher1);
			
			Teacher teacher2 = entityManager.find(Teacher.class, 2);
			entityManager.remove(teacher2);
			
			College1 college1 = entityManager.find(College1.class, 1);
			entityManager.remove(college1);
			
			entityTransaction.commit();
			
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
			entityManagerFactory.close();
		if(entityManager !=null)
			entityManager.close();
		if(entityTransaction !=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
}
