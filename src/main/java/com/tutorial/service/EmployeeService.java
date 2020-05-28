package com.tutorial.service;

import java.util.List;

import com.tutorial.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();
	
	Employee findEmployeeById(long id);
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	boolean deleteEmployee(long id);
}
