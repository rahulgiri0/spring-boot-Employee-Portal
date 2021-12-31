package com.example.employeeportal.controller.mvccontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employeeportal.model.User;
import com.example.employeeportal.service.EmployeeService;
import com.example.employeeportal.util.Message;

@Controller
public class ViewController {

	@Autowired
	EmployeeService employeeService;

	public static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// display home page
	@RequestMapping("/")
	public String home() {
		logger.trace("Employee Portal HomePage");
		return "home";
	}

	// display sign in page
	@RequestMapping(value = "/signin", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginPage() {
		logger.trace("login Page");
		return "login";
	}

	// logout handler
	@RequestMapping(value = "/user/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		logger.trace("User has logged out");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	// disploya register page
	@GetMapping("/register")
	public String registerPage() {
		logger.trace("Employee Registeration");
		return "register";
	}

	// registration handler
	@PostMapping("/registerProcess")
	public String registerHandler(@ModelAttribute User employee,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		try {

			if (!agreement) {

				throw new Exception("Not agreed terms and conditions");

			}

			employee.setRole("ROLE_USER");
			employee.setEnabled(true);
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			employeeService.createEmployee(employee);
			model.addAttribute("employee", new User());
			session.setAttribute("message", new Message("Succesfully Signed Up", "alert-success"));
			logger.trace(
					employee.getEmployeeName() + " has Successfull Signed Up with username" + employee.getUsername());
			return "register";

		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Some Thing went Worng !!" + e.getMessage());
			model.addAttribute("employee", employee);
			session.setAttribute("message", new Message("Something went wrong !! " + e.getMessage(), "alert-danger"));
			return "register";
		}

	}

}
