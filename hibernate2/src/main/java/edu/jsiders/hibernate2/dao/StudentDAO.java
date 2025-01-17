package edu.jsiders.hibernate2.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.College;
import edu.jsiders.hibernate2.dto.Student;


public class StudentDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		College college=new College();
		college.setName("GSMCOE");
		college.setLocation("Pune");
		
		Student student1=new Student();
		student1.setName("Tushar");
		student1.setDept("comp");
		student1.setCollege(college);
		
		Student student2=new Student();
		student2.setName("Tushar");
		student2.setDept("comp");
		student2.setCollege(college);
		
		Student student3=new Student();
		student3.setName("Tushar");
		student3.setDept("comp");
		student3.setCollege(college);
		
		try {
			openConnection();
			entityTransaction.begin();
			entityManager.persist(college);
			entityManager.persist(student1);
			entityManager.persist(student2);
			entityManager.persist(student3);
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
