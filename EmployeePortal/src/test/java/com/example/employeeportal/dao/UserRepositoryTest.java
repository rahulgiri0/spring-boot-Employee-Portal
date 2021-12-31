package com.example.employeeportal.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeportal.dao.UserRepository;
import com.example.employeeportal.model.User;

@SpringBootTest
@Transactional
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	void testSave() {
		User employee = new User(123, "Test Employee", "testusername", "1234", new ArrayList<>(), "ROLE_USER", true);
		User expectedEmployee = userRepository.save(employee);
		User actualEmployee = userRepository.findById(expectedEmployee.getId()).orElse(null);

		assertThat(actualEmployee).isEqualTo(expectedEmployee);
	}

	@Test
	void testGetUserByUsername() {
		User employee = new User(123, "Test Employee", "testusername", "1234", new ArrayList<>(), "ROLE_USER", true);
		User expectedEmployee = userRepository.save(employee);
		User actualEmployee = userRepository.getUserByUsername(expectedEmployee.getUsername());

		assertThat(actualEmployee.getUsername()).isEqualTo(expectedEmployee.getUsername());
	}

}
