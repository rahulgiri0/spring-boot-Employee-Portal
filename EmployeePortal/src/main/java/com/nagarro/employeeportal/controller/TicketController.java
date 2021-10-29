package com.nagarro.employeeportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employeeportal.model.Ticket;
import com.nagarro.employeeportal.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping("/ticket")
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
		Ticket saveTicket = ticketService.createTicket(ticket);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTicket);

	}

	@GetMapping("/ticket")
	public ResponseEntity<List<Ticket>> getAllTicket() {
		List<Ticket> tickets = ticketService.getAllTicket();

		if (tickets.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else
			return ResponseEntity.status(HttpStatus.OK).body(tickets);
	}

	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable int ticketId) {
		Ticket ticket = ticketService.getTicket(ticketId);

		if (ticket == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else
			return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable int ticketId) {
		ticketService.deleteTicket(ticketId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@PutMapping("/ticket")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
		Ticket updateTicket = ticketService.updateTicket(ticket);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updateTicket);

	}
}
