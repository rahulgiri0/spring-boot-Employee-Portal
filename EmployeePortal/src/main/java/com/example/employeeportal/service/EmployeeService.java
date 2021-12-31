package com.example.employeeportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeportal.model.User;

@Service
public interface EmployeeService {
	public User createEmployee(User employee);

	public List<User> getAllEmployee();

	public User getEmployee(int employeeId);

	User getEmployeebyUsername(String username);

	void deleteEmployee(int Id);

	User updateEmployee(User employee);

}
