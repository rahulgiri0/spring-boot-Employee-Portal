package com.example.employeeportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.employeeportal.dao.TicketRepo;
import com.example.employeeportal.dao.UserRepository;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	UserRepository usrRepository;

	public Ticket createTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	@Cacheable("data")
	public List<Ticket> getAllTicket(int employeeId) {
		User employee = usrRepository.findById(employeeId).orElse(null);
		List<Ticket> tickets = (List<Ticket>) ticketRepo.findTicketsByUser(employee);
		return tickets;
	}

	@Override
	@Cacheable(value = "data", key = "#ticketId")
	public Ticket getTicket(int ticketId) {

		Ticket ticket = ticketRepo.findById(ticketId).orElse(null);

		return ticket;
	}

	@Override
	@CacheEvict(cacheNames = "data", key = "#ticketId")
	public void deleteTicket(int ticketId) {
		// TODO Auto-generated method stub

		ticketRepo.deleteById(ticketId);
	}

	@Override
	@CachePut(cacheNames = "data", key = "#ticket")
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepo.save(ticket);

	}

	@Override
	@Cacheable("data")
	public List<Ticket> getTicketByUser(User user) {

		List<Ticket> tickets = ticketRepo.findTicketsByUser(user);
		return tickets;
	}

	public TicketServiceImpl(TicketRepo ticketRepo) {

		this.ticketRepo = ticketRepo;
	}

	@Override
	public Ticket createTicketByEmployeeId(Ticket ticket, int employeeId) {
		User employee = usrRepository.findById(employeeId).orElse(null);
		ticket.setUser(employee);
		Ticket saveTicket = ticketRepo.save(ticket);
		return saveTicket;
	}

	public void deleteTicket(int ticketId, int employeeId) {

		ticketRepo.deleteById(ticketId);
	}

	public Ticket updateTicket(Ticket ticket, int employeeId) {
		User employee = usrRepository.findById(employeeId).orElse(null);
		ticket.setUser(employee);
		return ticketRepo.save(ticket);

	}

	public List<Ticket> getAllTicket() {

		List<Ticket> tickets = (List<Ticket>) ticketRepo.findAll();
		return tickets;
	}

}
