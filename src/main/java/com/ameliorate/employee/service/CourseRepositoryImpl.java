package com.ameliorate.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameliorate.employee.entity.Student;
import com.ameliorate.employee.exception.GenericResponseEntity;
import com.ameliorate.employee.repository.CoursesRepository;

@Service
public class CourseRepositoryImpl implements CoursesService{

	@Autowired
	private CoursesRepository coursesRepository;
	

	
	@Override
	public GenericResponseEntity addStudentCourse(Student student) {
		coursesRepository.save(student);
		return new GenericResponseEntity(201, "Employee created successfully");
	}
}
