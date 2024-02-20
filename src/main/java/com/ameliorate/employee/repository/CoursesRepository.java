package com.ameliorate.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ameliorate.employee.entity.Courses;
import com.ameliorate.employee.entity.Student;

public interface CoursesRepository extends JpaRepository<Courses, Integer>{

	void save(Student student);

}
