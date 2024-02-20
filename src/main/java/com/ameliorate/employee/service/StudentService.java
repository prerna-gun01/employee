package com.ameliorate.employee.service;

import java.util.List;

import com.ameliorate.employee.entity.Student;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;

public interface StudentService {

	public GenericResponseEntity addStudent(Student student);

//	public GenericResponseEntity addStudentAddress(Student student);

	public List<Student> getStudentList();

	public Student getStudentById(Integer studentId) throws CustomException;

	public GenericResponseEntity deleteStudent(Integer studentId) throws CustomException; 



//	public void save(List<Student> student);

	
}
