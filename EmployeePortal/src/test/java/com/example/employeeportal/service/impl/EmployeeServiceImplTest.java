package com.example.employeeportal.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employeeportal.dao.UserRepository;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.impl.EmployeeServiceImpl;

@SpringBootTest
class EmployeeServiceImplTest {

	@Mock
	UserRepository userRepository;

	@Mock
	private User employee;

	private EmployeeServiceImpl employeeServiceImpl;

	@BeforeEach
	void setUp() {
		this.employeeServiceImpl = new EmployeeServiceImpl(this.userRepository);
	}

	@Test
	void testCreateEmployee() {
		this.employeeServiceImpl.createEmployee(employee);
		verify(userRepository).save(employee);
	}

	@Test
	void testGetAllEmployee() {
		this.employeeServiceImpl.getAllEmployee();
		verify(userRepository).findAll();
	}

	@Test
	void testGetEmployee() {
		this.employeeServiceImpl.getEmployee(employee.getId());
		verify(userRepository).findById(employee.getId());
	}

	@Test
	void testGetEmployeebyUsername() {
		this.employeeServiceImpl.getEmployeebyUsername(employee.getUsername());
		verify(userRepository).getUserByUsername(employee.getUsername());
	}

	@Test
	void testDeleteEmployee() {
		this.employeeServiceImpl.deleteEmployee(employee.getId());
		verify(userRepository).deleteById(employee.getId());
	}

	@Test
	void testUpdateEmployee() {
		this.employeeServiceImpl.updateEmployee(employee);
		verify(userRepository).save(employee);
	}

}
