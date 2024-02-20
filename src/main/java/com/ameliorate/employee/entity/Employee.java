package com.ameliorate.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NotFound;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	
	 
	private String name;
	
	private String email;
	private String designation;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////	@JoinColumn(name = "educationId", referencedColumnName = "educationId")
//	private Education education;
	
//	public long getId() {
//		return employeeId;
//	}
//	public void setId(long employeeId) {
//		this.employeeId = employeeId;
//	}
	
	public String getName() {
		return name;
	}
	public Employee(long employeeId, String name, String email, String designation) {
	super();
	this.employeeId = employeeId;
	this.name = name;
	this.email = email;
	this.designation = designation;
//	this.education = education;
}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
////	public Education getEducation() {
////		return education;
////	}
////	public void setEducation(Education education) {
////		this.education = education;
////	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	
//	public Employee(long employeeId, String name, String email, String designation) {
//		super();
//		this.employeeId = employeeId;
//		this.name = name;
//		this.email = email;
//		this.designation = designation;
//	}
	
//	public Employee() {
//		super();
//	}
	
//	public List<Employee> toList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
}
