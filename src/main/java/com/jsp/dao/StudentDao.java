package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Student;


@Component
public class StudentDao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	
	
//=================================================================================================
	
	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
		
	}
	
//==================================================================================================
	
	public List<Student> viewAllStudents() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}
	
//====================================================================================================
	
	public boolean deleteStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		if(student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
//=======================================================================================================
	
	public Student updateStudentById(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	
//=======================================================================================================
	
	public Student getStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	
//========================================================================================================
	
	

}
