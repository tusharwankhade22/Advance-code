package edu.jsiders.hibernate2.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.Company;

public class CompanyDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		try {
			openConnection();
			Company company = entityManager.find(Company.class, 1);
			if(company !=null) {
				entityTransaction.begin();
				entityManager.remove(company);
				entityTransaction.commit();
			}
			else {
				System.out.println("company not found!");
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
