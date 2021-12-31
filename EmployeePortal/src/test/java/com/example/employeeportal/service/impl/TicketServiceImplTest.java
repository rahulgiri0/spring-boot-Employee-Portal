package com.example.employeeportal.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.employeeportal.dao.TicketRepo;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.impl.TicketServiceImpl;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

	@Mock
	private TicketRepo ticketRepo;

	private TicketServiceImpl ticketServiceImpl;

	@Mock
	private User employee;

	@Mock
	private Ticket ticket;

	@BeforeEach
	void setUp() {
		this.ticketServiceImpl = new TicketServiceImpl(this.ticketRepo);
	}

	@Test
	void testGetAllTicket() {
		ticketServiceImpl.getAllTicket();

		verify(ticketRepo).findAll();
	}

	@Test
	void testGetTicketByUser() {

		ticketServiceImpl.getTicketByUser(employee);
		verify(ticketRepo).findTicketsByUser(employee);
	}

	@Test
	void testCreateTicket() {

		ticketServiceImpl.createTicket(ticket);
		verify(ticketRepo).save(ticket);
	}

	@Test
	void testGetTicket() {

		ticketServiceImpl.getTicket(ticket.getTicketId());
		verify(ticketRepo).findById(ticket.getTicketId());

	}

	@Test
	void testDeleteTicket() {

		ticketServiceImpl.deleteTicket(ticket.getTicketId());
		verify(ticketRepo).deleteById(ticket.getTicketId());
	}

	@Test
	void testUpdateTicket() {
		ticketServiceImpl.updateTicket(ticket);
		verify(ticketRepo).save(ticket);
	}

}
