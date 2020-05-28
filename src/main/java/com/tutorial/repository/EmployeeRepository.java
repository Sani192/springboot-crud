package com.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}