package com.example.employeeportal.controller.restcontroller;

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

import com.example.employeeportal.exception.TicketNotFoundException;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.service.EmployeeService;
import com.example.employeeportal.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketRestController {

	@Autowired
	TicketService ticketService;

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee/{employeeId}/ticket")
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket, @PathVariable int employeeId) {

		Ticket saveTicket = ticketService.createTicketByEmployeeId(ticket, employeeId);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTicket);

	}

	@GetMapping("/employee/{employeeId}/ticket")
	public ResponseEntity<List<Ticket>> getAllTicket(@PathVariable int employeeId) throws TicketNotFoundException {

		List<Ticket> tickets = ticketService.getAllTicket(employeeId);

		if (tickets.size() <= 0) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new TicketNotFoundException("No Tickets Available");
		} else
			return ResponseEntity.status(HttpStatus.OK).body(tickets);
	}

	@GetMapping("employee/{employeeId}/ticket/{ticketId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable int employeeId, @PathVariable int ticketId)
			throws TicketNotFoundException {

		// User user = employeeService.getEmployee(employeeId);
		Ticket ticket = ticketService.getTicket(ticketId);

		if (ticket == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new TicketNotFoundException("Ticket Not Found");
		} else
			return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

	@DeleteMapping("employee/{employeeId}/ticket/{ticketId}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable int ticketId, @PathVariable int employeeId)
			throws TicketNotFoundException {

		Ticket ticket = ticketService.getTicket(ticketId);

		if (ticket == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new TicketNotFoundException("Ticket Not Found");
		} else {
			ticketService.deleteTicket(ticketId, employeeId);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	@PutMapping("employee/{employeeId}/ticket")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable int employeeId)
			throws TicketNotFoundException {

		Ticket findticket = ticketService.getTicket(ticket.getTicketId());

		if (findticket == null) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new TicketNotFoundException("Ticket Not Found");
		} else {
			Ticket updateTicket = ticketService.updateTicket(ticket, employeeId);
			return ResponseEntity.status(HttpStatus.CREATED).body(updateTicket);
		}

	}
}
