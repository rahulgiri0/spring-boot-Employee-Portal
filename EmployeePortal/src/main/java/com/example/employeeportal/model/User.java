package com.example.employeeportal.model;

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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String employeeName;
	@Column(unique = true)
	private String username;

	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private List<Ticket> ticket;

	private String role;
	private boolean enabled;

	// default constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public User(int id, String employeeName, String username, String password, List<Ticket> ticket, String role,
			boolean enabled) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.username = username;
		this.password = password;
		this.ticket = ticket;
		this.role = role;
		this.enabled = enabled;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// to string

	@Override
	public String toString() {
		return "User [id=" + id + ", employeeName=" + employeeName + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}

}
