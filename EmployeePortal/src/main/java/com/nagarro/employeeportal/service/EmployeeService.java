package com.nagarro.employeeportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.employeeportal.model.Employee;

@Service
public interface EmployeeService {
	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployee(int employeeId);

}
