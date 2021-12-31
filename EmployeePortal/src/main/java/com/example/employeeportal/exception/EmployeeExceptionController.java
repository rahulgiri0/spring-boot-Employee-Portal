package com.example.employeeportal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeeportal.util.Message;

@ControllerAdvice
public class EmployeeExceptionController {
	@ExceptionHandler(value = EmployeeNotFoundException.class)

	final public ResponseEntity<Message> exception(EmployeeNotFoundException ex) {

		Message message = new Message("This Employee is Not Registered", ex.getMessage());

		return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}
}
