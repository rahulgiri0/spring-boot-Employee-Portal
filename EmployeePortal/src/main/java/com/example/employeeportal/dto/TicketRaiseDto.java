package com.example.employeeportal.dto;

public class TicketRaiseDto {

	private String category;
	private String description;

	// default constructor
	public TicketRaiseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public TicketRaiseDto(String category, String description) {

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

	// to string method

	@Override
	public String toString() {
		return "TicketRequest [category=" + category + ", description=" + description + "]";
	}

}
