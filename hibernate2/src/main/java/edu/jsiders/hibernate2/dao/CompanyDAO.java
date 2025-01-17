package edu.jsiders.hibernate2.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.Company;
import edu.jsiders.hibernate2.dto.Employee;

public class CompanyDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Employee employee1=new Employee();
		employee1.setName("Gaurav");
		employee1.setEmail("gaurav22@gmail.com");
		
		Employee employee2=new Employee();
		employee2.setName("Ayusha");
		employee2.setEmail("ayusha22@gmail.com");
		
		
		
		Collection<Employee> employees=new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		
		Company company=new Company();
		company.setName("TCS");
		company.setLocation("Pune");
		company.setEmployees(employees);
		
		try {
			openConnection();
			entityTransaction.begin(); 
			entityManager.persist(employee1);
			entityManager.persist(employee2);
			entityManager.persist(company);
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
