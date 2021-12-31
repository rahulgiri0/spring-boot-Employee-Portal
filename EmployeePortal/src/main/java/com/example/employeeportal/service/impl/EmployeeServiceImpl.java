package com.example.employeeportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeportal.dao.UserRepository;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public User createEmployee(User employee) {
		User emp = userRepository.save(employee);
		return emp;
	}

	@Override
	public List<User> getAllEmployee() {

		List<User> employees = (List<User>) userRepository.findAll();
		return employees;
	}

	@Override
	public User getEmployee(int employeeId) {

		User employee = userRepository.findById(employeeId).orElse(null);
		return employee;
	}

	@Override
	public User getEmployeebyUsername(String username) {

		User employee = userRepository.getUserByUsername(username);
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public User updateEmployee(User employee) {
		User emp = userRepository.save(employee);
		return emp;
	}

	public EmployeeServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

}
