package com.tutorial.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.model.Employee;
import com.tutorial.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDb = repository.findById(employee.getId());
		if(employeeDb.isPresent()) {
			Employee emp = employeeDb.get();
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setEmail(employee.getEmail());
			emp.setAddress(employee.getAddress());
			emp.setTelephone(employee.getTelephone());
			return repository.save(emp);
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(long id) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent()) {
			repository.delete(employee.get());
			return true;
		}
		return false;
	}

}
