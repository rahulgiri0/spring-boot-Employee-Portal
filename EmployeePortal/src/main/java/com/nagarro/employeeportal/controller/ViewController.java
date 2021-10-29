package com.nagarro.employeeportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.employeeportal.dto.EmployeeCredential;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(path = "/loginprocess", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute EmployeeCredential credential) {

		System.out.println(credential);

		return "welcome";
	}
}
