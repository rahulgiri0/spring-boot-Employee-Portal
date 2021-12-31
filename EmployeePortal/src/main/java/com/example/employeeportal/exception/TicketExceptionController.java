package com.example.employeeportal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeeportal.util.Message;

@ControllerAdvice
public class TicketExceptionController {

	@ExceptionHandler(value = TicketNotFoundException.class)

	final public ResponseEntity<Message> exception(TicketNotFoundException ex) {

		Message message = new Message("Ticket You are looking for is not present", ex.getMessage());

		return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

}
