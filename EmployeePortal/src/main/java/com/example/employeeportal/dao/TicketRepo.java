package com.example.employeeportal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

	public List<Ticket> findTicketsByUser(User user);
}
