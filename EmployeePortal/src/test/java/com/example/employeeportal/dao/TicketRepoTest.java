package com.example.employeeportal.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeportal.dao.TicketRepo;
import com.example.employeeportal.dao.UserRepository;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;

@SpringBootTest
@Transactional
class TicketRepoTest {

	@Autowired
	UserRepository userRepo;

	@Autowired
	TicketRepo ticketRepo;

	List<Ticket> ticket;
	User user;

	@Test
	void testFindTicketsByUser() {
		User newUser = new User(123, "Test Employee", "testusername", "1234", new ArrayList<>(), "ROLE_USER", true);
		Ticket newTicket = new Ticket(12, "testcategory", "this is a test description", "Active", newUser);
		List<Ticket> ticketList = new ArrayList<>();

		ticketList.add(newTicket);
		newUser.setTicket(ticketList);

		user = userRepo.save(newUser);
		ticket = user.getTicket();
		List<Ticket> actualTicket = ticketRepo.findTicketsByUser(user);
		System.out.println(actualTicket);

		// assertThat(actualTicket.size()).isEqualTo(ticket.size());

		for (int i = 0; i < actualTicket.size(); i++) {

			assertThat(actualTicket.get(i).getTicketId()).isEqualTo(ticket.get(i).getTicketId());
			assertThat(actualTicket.get(i).getCategory()).isEqualTo(ticket.get(i).getCategory());
		}

	}

	@Test
	void testSaveTicket() {
		User newUser = new User(123, "Test Employee", "testusername", "1234", null, "ROLE_USER", true);
		Ticket newTicket = new Ticket(12, "testcategory", "this is a test description", "Active", newUser);

		Ticket actualticket = ticketRepo.save(newTicket);

		assertThat(ticketRepo.existsById(actualticket.getTicketId())).isTrue();
	}

	@Test
	void deleteTicket() {
		Ticket newTicket = new Ticket(12, "testcategory", "this is a test description", "Active", new User());

		Ticket ticket = ticketRepo.save(newTicket);
		ticketRepo.delete(ticket);
		;
		assertThat(ticketRepo.existsById(ticket.getTicketId())).isFalse();
	}

	@Test
	void getTicketByID() {
		Ticket newTicket = new Ticket(12, "testcategory", "this is a test description", "Active", new User());

		Ticket expectedTicket = ticketRepo.save(newTicket);

		Ticket actualTicket = (Ticket) ticketRepo.findById(expectedTicket.getTicketId()).orElse(null);

		assertThat(actualTicket).isEqualTo(actualTicket);
	}

}
