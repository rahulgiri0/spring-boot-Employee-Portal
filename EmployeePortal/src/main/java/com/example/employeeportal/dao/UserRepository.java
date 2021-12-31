package com.example.employeeportal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeportal.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User getUserByUsername(String username);
}
