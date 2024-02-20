package com.ameliorate.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ameliorate.employee.entity.Employee;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;
import com.ameliorate.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	

//	private static Map<String, Employee> employeeRepo = new HashMap<>();
//	@PostMapping("/add")
//	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
//		employeeRepo.put(employee.getName(), employee);
//		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//	}
	
	
//	@PostMapping("/add")
//	public ResponseEntity<GenericResponseEntity> addEmployee(@RequestBody Employee employee) {
//		GenericResponseEntity generic = service.addEmployee(employee);
//		return new ResponseEntity<>(generic,HttpStatus.CREATED);
//	}
	
	@PostMapping("/add")
	public ResponseEntity<GenericResponseEntity> addEmployee(@RequestBody Employee employee) {
		GenericResponseEntity generic = service.addEmployee(employee);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
//	@PostMapping("/addStudent")
//	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//		ResponseEntity generic = studentService.addStudent(student);
//		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//	}
	

//	@PostMapping("/add")
//	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
//		service.addEmployee(employee);
//		ResponseEntity<String> responseEntity = new ResponseEntity<>("Employee added",HttpStatus.CREATED);
//		return responseEntity;
//	}
	
//	@PostMapping("/add")
//	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
//		Employee addEmployee= service.addEmployee(employee);
//		return new ResponseEntity<Employee>(addEmployee, HttpStatus.CREATED);
//	}
//	Default
//	@PutMapping("/update/{id}")
//	public Employee updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee)  throws CustomException{
//		return service.updateEmployee(employeeId, employee);
//	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<GenericResponseEntity> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee)  throws CustomException{
		GenericResponseEntity generic = service.updateEmployee(employeeId, employee);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
//	default
//	@DeleteMapping("/delete/{id}")
//	public String deleteEmployee(@PathVariable("id") Long employeeId)  throws CustomException{
//		service.deleteEmployee(employeeId);
//		return "Employee deleted successfully";
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GenericResponseEntity> deleteEmployee(@PathVariable("id") Long employeeId)  throws CustomException{
		GenericResponseEntity generic = service.deleteEmployee(employeeId);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long employeeId) throws CustomException{
		return service.getEmployeeById(employeeId);
		
	}
	
//	@GetMapping("/getById/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
//		Employee employee=service.getEmployeeById(employeeId);
//		return ResponseEntity.status(HttpStatus.OK).body(employee);
//	}
	
	@GetMapping("/getlist")
	public List<Employee> getEmployeeList() {
		return service.getEmployeeList();
	}
	
//	@GetMapping("/getlist")
//	public ResponseEntity<Employee> getEmployeeList(){
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
//	public ResponseEntity<String> getEmployeeList(){
//		String msg = "Employee List";
//		return new ResponseEntity<String>(msg,HttpStatus.OK);
//	}
	
//	public ResponseEntity<List<Employee>> getEmployeeList() {
//		List<Employee> list=employeeRepository.findAll();
//		if(list.size()<=0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(list));
//		
//	}
	
//	@GetMapping("/employees")
//	Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
//		
//		return service.getAllEmployees(page,size);
//	}
	
	@GetMapping("/employees")
	public ResponseEntity<Page<Employee>> getUsers(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "employeeId")String sort, 
            @RequestParam(defaultValue = "asc")String sortdir) {
			Page<Employee> employees = service.getAllEmployees(page, size,sort,sortdir);
			return ResponseEntity.ok(employees);
}
	
}
