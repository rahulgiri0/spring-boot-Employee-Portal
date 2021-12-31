package com.example.employeeportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;

@Service
public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public List<Ticket> getAllTicket(int employeeId);

	public List<Ticket> getAllTicket();

	public Ticket getTicket(int ticketId);

	public void deleteTicket(int ticketId);

	void deleteTicket(int ticketId, int employeeId);

	public Ticket updateTicket(Ticket ticket);

	public Ticket updateTicket(Ticket ticket, int employeeId);

	public List<Ticket> getTicketByUser(User user);

	Ticket createTicketByEmployeeId(Ticket ticket, int employeeId);
}
