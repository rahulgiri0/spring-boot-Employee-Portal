package com.example.employeeportal.dto;

public class TicketUpdateDto {

	private int ticketId;
	private String category;
	private String description;

	// default constructor
	public TicketUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public TicketUpdateDto(int ticketId, String category, String description) {
		this.ticketId = ticketId;
		this.category = category;
		this.description = description;
	}

	// getter and setter

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

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	// to string method

	@Override
	public String toString() {
		return "TicketRequest [ticketId= " + ticketId + ", category=" + category + ", description=" + description + "]";
	}

}
