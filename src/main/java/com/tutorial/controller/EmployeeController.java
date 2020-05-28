package com.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.model.Employee;
import com.tutorial.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("")
    public ResponseEntity <List<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    @PostMapping("")
    public ResponseEntity <Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
