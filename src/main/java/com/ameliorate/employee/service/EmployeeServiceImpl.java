package com.ameliorate.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ameliorate.employee.entity.Employee;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;
import com.ameliorate.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Override
//	public ResponseEntity<Employee> addEmployee(Employee employee) {
//		Employee addEmployee = employeeRepository.save(employee);
//		return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
//	}
	
	@Override
	public GenericResponseEntity addEmployee(Employee employee) {
			employeeRepository.save(employee);
		return new GenericResponseEntity(201, "Employee created successfully");
	}

	@Override
	public GenericResponseEntity updateEmployee(Long employeeId, Employee employee) throws CustomException{

		Optional<Employee> empDB = employeeRepository.findById(employeeId);
		if (empDB.isPresent()) {
			Employee existingEmployee = empDB.get();
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setDesignation(employee.getDesignation());
			employeeRepository.save(employee);
			return new GenericResponseEntity(200, "Employee updated successfully");
		}
		

	 throw new CustomException("Can't update as ID doesn't exist");

	}

	@Override
	public GenericResponseEntity deleteEmployee(Long employeeId) throws CustomException{
		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
		if(employeeById.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return new GenericResponseEntity(200, "Employee deleted successfully");
		}
		else {
		throw new CustomException("Can't delete as ID doesn't exist");
		}
	}

	@Override
	public  Employee getEmployeeById(Long employeeId) throws CustomException{
		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
		if (employeeById.isPresent()) {
			return employeeById.get();
		}
		throw new CustomException(employeeId + " Id of an employee is not found");
		
	}

	@Override
	public List<Employee> getEmployeeList() {
//		List<Employee> list = employeeRepository.findAll();
		return employeeRepository.findAll();
	}

	@Override
	public Page<Employee> getAllEmployees(int page, int size, String sort, String sortdir) {
		Pageable pageable = buildPagable(page, size, sort,sortdir);
		return employeeRepository.findAll(pageable);
	}

	private Pageable buildPagable(int page, int size, String sort, String sortdir) {
		if (page < 0) {
			page = 0;
		}
		if (size < 0 || size > 5) {
			size = 5;
		}
		Sort sortBy = null;
		if(sortdir.equalsIgnoreCase("asc")) {
			sortBy=Sort.by(sort).ascending();
		}
		else {
			sortBy=Sort.by(sort).descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return pageable;
	}

//	@Override
//	public Student addStudent(Student student) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
