package com.nagarro.employeeportal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.employeeportal.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
