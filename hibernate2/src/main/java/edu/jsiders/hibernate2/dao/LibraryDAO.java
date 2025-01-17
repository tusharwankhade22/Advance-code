package edu.jsiders.hibernate2.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsiders.hibernate2.dto.Book;
import edu.jsiders.hibernate2.dto.Library;

public class LibraryDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		Library library1=new Library();
		library1.setName("ABC");
		library1.setLocation("Wakad");
		
		Library library2=new Library();
		library2.setName("XYZ");
		library2.setLocation("Pimple Gurav");
		
		Collection<Library> libraries=new ArrayList<Library>();
		libraries.add(library1);
		libraries.add(library2);
		
		Book book1= new Book();
		book1.setName("Sunrise Night");
		book1.setAuthor("Jeff Zentner");
		book1.setPrice(500.00);
		book1.setLibraries(libraries);
		
		Book book2= new Book();
		book2.setName("The Mermaid");
		book2.setAuthor("Cynthia Hand");
		book2.setPrice(350.00);
		book2.setLibraries(libraries);
		
		Collection<Book> books=new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		library1.setBooks(books);
		library2.setBooks(books);

		try {
			openConnection();
			entityTransaction.begin();
			entityManager.persist(book1);
			entityManager.persist(book2);
			entityManager.persist(library1);
			entityManager.persist(library2);
			entityTransaction.commit();
				
		}finally {
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
