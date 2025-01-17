package edu.jsiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.Teacher;

public class CollegeDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			Teacher teacher = entityManager.find(Teacher.class, 3);
			if(teacher !=null) {
				teacher.setName("Gayatri");
				entityTransaction.begin();
				entityManager.persist(teacher);
				entityTransaction.commit();
			}
			else {
				System.out.println("Teacher not found");
			}
			
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
