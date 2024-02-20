package com.ameliorate.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ameliorate.employee.entity.Laptop;
import com.ameliorate.employee.entity.Student;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;
import com.ameliorate.employee.service.CoursesService;
import com.ameliorate.employee.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CoursesService coursesService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<GenericResponseEntity> addStudent(@RequestBody Student student) {
		
		GenericResponseEntity generic = studentService.addStudent(student);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
//	@PostMapping("/addStudentAddress")
//	public ResponseEntity<GenericResponseEntity> addStudentAddress(@RequestBody Student student) {
//		
//		GenericResponseEntity generic = studentService.addStudentAddress(student);
//		return new ResponseEntity<>(generic,HttpStatus.CREATED);
//	}
	
	@PostMapping("/addStudentCourse")
	public ResponseEntity<GenericResponseEntity> addStudentCourse(@RequestBody Student student) {
		
		GenericResponseEntity generic = coursesService.addStudentCourse(student);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudentList")
	public List<Student> getStudentList() {
		return studentService.getStudentList();
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable("id") Integer studentId) throws CustomException{
		return studentService.getStudentById(studentId);
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public ResponseEntity<GenericResponseEntity> deleteStudent(@PathVariable("id") Integer studentId)  throws CustomException{
		GenericResponseEntity generic = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
}
