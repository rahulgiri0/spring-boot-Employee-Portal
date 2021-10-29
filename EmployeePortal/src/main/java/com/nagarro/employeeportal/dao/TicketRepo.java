package com.nagarro.employeeportal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.employeeportal.model.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

}
