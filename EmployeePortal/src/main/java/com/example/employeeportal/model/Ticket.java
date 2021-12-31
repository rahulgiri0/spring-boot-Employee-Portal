package com.example.employeeportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private String category;
	private String description;
	private String status;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	private User user;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor by fields

	public Ticket(int ticketId, String category, String description, String status, User user) {
		super();
		this.ticketId = ticketId;
		this.category = category;
		this.description = description;
		this.status = status;
		this.user = user;
	}

	// constructor
	public int getTicketId() {
		return ticketId;
	}

	// getter and setter

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// to string

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", category=" + category + ", description=" + description + ", status="
				+ status + "]";
	}

}
