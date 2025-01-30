package edu.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dto.Student;

@Component
public class StudentDAO {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	private void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("springmvc");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private void closeConnection() {
		if(entityManagerFactory !=null)
			entityManagerFactory.close();
		if(entityManager !=null)
			entityManager.close();
		if(entityTransaction != null)
			if(entityTransaction.isActive())
				entityTransaction.commit();
	}

	public void addStudent(Student student) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		closeConnection();
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		openConnection();
		Query query = entityManager.createQuery("SELECT students FROM Student students");
		List<Student> students = query.getResultList();
		closeConnection();
		
		return students;	
	}

	public void deleteStudentById(int id) {
		openConnection();
		entityTransaction.begin();
		Student studentToBeDeleted = entityManager.find(Student.class,id);
		entityManager.remove(studentToBeDeleted);
		entityTransaction.commit();
		closeConnection();
	}

	public Student findStudentById(int id) {
		openConnection();
		Student student = entityManager.find(Student.class, id);
		closeConnection();
		return student;
	}

	public void updateStudent(int id, String name, String email, long phoneno, String course) {
		openConnection();
		entityTransaction.begin();
		Student student = entityManager.find(Student.class, id);
		student.setName(name);
		student.setEmail(email);
		student.setPhoneno(phoneno);
		student.setCourse(course);
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public Student findStudentByMobile(long phonono) {
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM Student student WHERE student.phoneno = ?1");
		query.setParameter(1, phonono);
		Student student = (Student) query.getSingleResult();
		System.out.println(student);
		closeConnection();
		return student;
	}

	public Student findStudentByEmail(String email) {
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM Student student WHERE student.email = ?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		System.out.println(student);
		closeConnection();
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> findStudentByName(String name) {
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM Student student WHERE student.name LIKE CONCAT('%', ?1, '%')");
		query.setParameter(1, name);
		List<Student> students = query.getResultList();
		closeConnection();
		return students;
		
	}

	@SuppressWarnings("unchecked")
	public List<Student> findStudentbyCourse(String course) {
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM Student student WHERE student.course=?1");
		query.setParameter(1, course);
		List<Student> students = query.getResultList();
		closeConnection();
		return students;
	}
	
	
	
}
