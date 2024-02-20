package com.ameliorate.employee.service;

import com.ameliorate.employee.entity.Student;
import com.ameliorate.employee.exception.GenericResponseEntity;

public interface CoursesService {

	public GenericResponseEntity addStudentCourse(Student student);
}
