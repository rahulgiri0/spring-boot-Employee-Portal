package com.nagarro.employeeportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeeportal.dao.EmployeeRepo;
import com.nagarro.employeeportal.model.Employee;
import com.nagarro.employeeportal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepo employeeRepo;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> employees = (List<Employee>) employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee(int employeeId) {

		Employee employee = employeeRepo.findById(employeeId).orElse(null);
		return employee;
	}

}
