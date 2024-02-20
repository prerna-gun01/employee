package com.ameliorate.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ameliorate.employee.entity.Employee;
import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.exception.GenericResponseEntity;

public interface EmployeeService {

	public GenericResponseEntity addEmployee(Employee employee);

	

	public GenericResponseEntity updateEmployee(Long employeeId, Employee employee) throws CustomException;

	public GenericResponseEntity deleteEmployee(Long employeeId)throws CustomException;
	
	public Employee getEmployeeById (Long employeeId);

//	public List<Employee> getByName(String name, int pageNo, int recordCount);

	public List<Employee> getEmployeeList() ;



	public Page<Employee> getAllEmployees(int page, int size, String sort, String sortdir);



//	public Student addStudent(Student student);




//	Page<Employee> getSort(int page, int size);

//	public List<Employee> findEmployeesWithSorting(String field);

}
