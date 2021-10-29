package com.nagarro.employeeportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeeportal.dao.TicketRepo;
import com.nagarro.employeeportal.model.Ticket;
import com.nagarro.employeeportal.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepo ticketRepo;

	public Ticket createTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> tickets = (List<Ticket>) ticketRepo.findAll();
		return tickets;
	}

	@Override
	public Ticket getTicket(int ticketId) {

		Ticket ticket = ticketRepo.findById(ticketId).orElse(null);

		return ticket;
	}

	@Override
	public void deleteTicket(int ticketId) {
		// TODO Auto-generated method stub

		ticketRepo.deleteById(ticketId);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepo.save(ticket);

	}
}
