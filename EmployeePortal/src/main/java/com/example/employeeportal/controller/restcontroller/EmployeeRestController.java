package com.example.employeeportal.controller.restcontroller;

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

import com.example.employeeportal.exception.EmployeeNotFoundException;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<User> addEmployee(@RequestBody User employee) {

		User emp = employeeService.createEmployee(employee);

		return ResponseEntity.status(HttpStatus.CREATED).body(emp);

	}

	@GetMapping("/employee")

	public ResponseEntity<List<User>> getAllEmployee() throws EmployeeNotFoundException {

		List<User> employees = employeeService.getAllEmployee();

		if (employees.size() <= 0) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EmployeeNotFoundException("EMPLOYEE_NOT_FOUND");
		} else
			return ResponseEntity.status(HttpStatus.OK).body(employees);

	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<User> getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		User employee = employeeService.getEmployee(id);

		if (employee == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EmployeeNotFoundException("EMPLOYEE_NOT_FOUND");
		} else
			return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<User> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		User employee = employeeService.getEmployee(id);

		if (employee == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EmployeeNotFoundException("EMPLOYEE_NOT_FOUND");
		} else {
			employeeService.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	@PutMapping("/employee")
	public ResponseEntity<User> updateTicket(@RequestBody User employee) throws EmployeeNotFoundException {

		User findEmp = employeeService.getEmployee(employee.getId());

		if (findEmp == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EmployeeNotFoundException("EMPLOYEE_NOT_FOUND");
		} else {
			User updateEmployee = employeeService.updateEmployee(employee);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updateEmployee);
		}

	}
}
