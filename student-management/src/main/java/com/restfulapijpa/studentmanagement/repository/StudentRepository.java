package com.restfulapijpa.studentmanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restfulapijpa.studentmanagement.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public List<Student> find() {
		
		@SuppressWarnings("unchecked")
		List<Student> student = em.createNativeQuery("Select * from Student").getResultList();
		return student;
		
	}
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	@SuppressWarnings("null")
	public Student save(Student student){
		if(student.getId() == null) {
			
			em.persist(student);
			System.out.println(student);
		}
		else {
			em.merge(student);
		}
		return student;
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void update(Student student) {
		
		em.merge(student);
		
	}


	
}
