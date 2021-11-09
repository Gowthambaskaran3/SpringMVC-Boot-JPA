package com.restfulapijpa.studentmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;

@Entity
public class Student {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String student;
	
	private String department;
	
	@OneToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="department_subject")
	private Department subject;
	

	public Student() {
		
	}
	
	public Student(String student, String department) {
		super();
		this.student = student;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getDepartment() {
		return department;
	}
	
	

	public void setDepartment(String department) {
		this.department = department;
	}

	public Department getSubject() {
		return subject;
	}

	public void setSubject(Department subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", student=" + student + ", department=" + department + ", subject=" + subject
				+ "]";
	}


	

}
