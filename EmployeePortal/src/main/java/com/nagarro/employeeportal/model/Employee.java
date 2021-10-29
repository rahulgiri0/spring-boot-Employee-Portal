package com.nagarro.employeeportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String username;
	private String password;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> ticket;

	private String role;

	// default constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public Employee(int id, String username, String password, List<Ticket> ticket, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ticket = ticket;
		this.role = role;
	}

	// getter and setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// to string

	@Override
	public String toString() {
		return "Employee [Id=" + id + ", username=" + username + ", password=" + password + ", ticket=" + ticket
				+ ", role=" + role + "]";
	}

}
