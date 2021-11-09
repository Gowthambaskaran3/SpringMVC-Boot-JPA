package com.restfulapijpa.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapijpa.studentmanagement.entity.Contact;
import com.restfulapijpa.studentmanagement.entity.Student;
import com.restfulapijpa.studentmanagement.entity.StudentNotFoundException;
import com.restfulapijpa.studentmanagement.feign.ContactProxy;
import com.restfulapijpa.studentmanagement.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	ContactProxy contactProxy;
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/contact")
	public List<Contact> findContacts(){
	return contactProxy.getContact();
	}

	@GetMapping("/student")
	public List<Student> find() {
		return studentRepository.find();
	}
	
	@GetMapping("/student/{id}")
	public Student findById(@PathVariable Long id) {
		Student student = studentRepository.findById(id);
		if(student==null) {
			throw new StudentNotFoundException("id -"+id);	
		}
		return student;		
	} 
	
	@PostMapping("/student")
	public void save(@RequestBody Student student) {
		studentRepository.save(student);
	}
	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable Long id){
		Student student = studentRepository.findById(id);
		if(student==null)
		{
			throw new StudentNotFoundException("id -"+id);
		}
		else {
			studentRepository.deleteById(id);
		}
		
		studentRepository.deleteById(id);
	}
	
	@PutMapping("/student")
	public void update(@RequestBody Student student) {
		studentRepository.update(student);
	}
	}
