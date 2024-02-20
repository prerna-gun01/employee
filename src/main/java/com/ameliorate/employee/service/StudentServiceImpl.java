package com.ameliorate.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameliorate.employee.entity.Student;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;
import com.ameliorate.employee.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public GenericResponseEntity addStudent(Student student) {
		
		studentRepository.save(student);
		return new GenericResponseEntity(201, "Employee created successfully");
	}
	
	@Override
	public List<Student> getStudentList() {
		List<Student> list = studentRepository.findAll();
		return studentRepository.findAll();
	}

//	@Override
//	public GenericResponseEntity addStudentAddress(Student student) {
//		studentRepository.save(student);
//		return new GenericResponseEntity(201, "Employee created successfully");
//	}

//	@Override
//	public Employee getEmployeeById(Long employeeId) throws CustomException{
//		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
//		if (employeeById.isPresent()) {
//			return employeeById.get();
//		}
//		throw new CustomException(employeeId + " Id of an employee is not found");
//		
//	}
	
	@Override
	public Student getStudentById(Integer studentId) throws CustomException{
		Optional<Student> studentById = studentRepository.findById(studentId);
		if(studentById.isPresent()) {
			return studentById.get();
		}
		throw new CustomException(studentId + " Id of an student is not found");
	}
	

	@Override
	public GenericResponseEntity deleteStudent(Integer studentId) throws CustomException {
		Optional<Student> studentById = studentRepository.findById(studentId);
		if(studentById.isPresent()) {
			studentRepository.deleteById(studentId);
			return new GenericResponseEntity(200, "Student deleted successfully");
		}
		else {
			throw new CustomException("Can't delete as ID doesn't exist");
			}
	}

}
