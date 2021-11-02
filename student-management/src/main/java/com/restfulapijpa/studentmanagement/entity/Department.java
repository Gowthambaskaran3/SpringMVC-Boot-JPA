package com.restfulapijpa.studentmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	private String department;
	
	private String subject;
	
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="department")
//	@OneToOne(mappedBy = "department")
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subject")
	private Student student;
//	
	protected Department(){
		
	}
	
	public Department(String department, String subject) {
		super();
		this.department = department;
		this.subject = subject;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Department [department=" + department + ", subject=" + subject + "]";
	}
}
