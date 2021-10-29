package com.nagarro.employeeportal.dto;

public class EmployeeCredential {

	private int employeeId;
	private String password;

	// default constructor
	public EmployeeCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public EmployeeCredential(int employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}

	// getter and setter

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// to string method

	@Override
	public String toString() {
		return "EmployeeCredential [employeeId=" + employeeId + ", password=" + password + "]";
	}

}
