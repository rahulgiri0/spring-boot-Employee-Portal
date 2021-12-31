package com.example.employeeportal.service;

import org.springframework.stereotype.Service;

import com.example.employeeportal.dto.TicketRaiseDto;
import com.example.employeeportal.dto.TicketUpdateDto;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;

@Service
public class PortalService {

	public Ticket constructTicket(TicketRaiseDto ticketRequest, User employee) {
		Ticket ticket = new Ticket();
		ticket.setUser(employee);
		ticket.setCategory(ticketRequest.getCategory());
		ticket.setDescription(ticketRequest.getDescription());
		ticket.setStatus("Active");

		return ticket;
	}

	public Ticket constructTicket(TicketUpdateDto ticketUpdateDto, User employee) {
		Ticket ticket = new Ticket();
		ticket.setUser(employee);
		ticket.setTicketId(ticketUpdateDto.getTicketId());
		ticket.setCategory(ticketUpdateDto.getCategory());
		ticket.setDescription(ticketUpdateDto.getDescription());
		ticket.setStatus("Active");

		return ticket;
	}
}
