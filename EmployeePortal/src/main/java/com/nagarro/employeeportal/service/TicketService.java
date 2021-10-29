package com.nagarro.employeeportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.employeeportal.model.Ticket;

@Service
public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public List<Ticket> getAllTicket();

	public Ticket getTicket(int ticketId);

	public void deleteTicket(int ticketId);

	public Ticket updateTicket(Ticket ticket);
}
