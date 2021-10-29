package com.nagarro.employeeportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employeeportal.model.Employee;
import com.nagarro.employeeportal.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee emp = employeeService.createEmployee(employee);

		return ResponseEntity.status(HttpStatus.CREATED).body(emp);

	}

	@GetMapping("/employee")

	public ResponseEntity<List<Employee>> getEmployee() {

		List<Employee> employees = employeeService.getAllEmployee();

		if (employees.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else
			return ResponseEntity.status(HttpStatus.OK).body(employees);

	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getTicket(@PathVariable int id) {
		Employee employee = employeeService.getEmployee(id);

		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else
			return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
}
