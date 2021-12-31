package com.example.employeeportal.controller.mvccontroller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employeeportal.dto.TicketRaiseDto;
import com.example.employeeportal.dto.TicketUpdateDto;
import com.example.employeeportal.exception.TicketNotFoundException;
import com.example.employeeportal.model.Ticket;
import com.example.employeeportal.model.User;
import com.example.employeeportal.service.EmployeeService;
import com.example.employeeportal.service.PortalService;
import com.example.employeeportal.service.TicketService;

@Controller
@RequestMapping("/user")
public class PortalController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	TicketService ticketService;

	@Autowired
	PortalService portalService;

	public static final Logger logger = LoggerFactory.getLogger(PortalController.class);

	@RequestMapping("/index")
	public String welcome(HttpServletRequest request, Principal principal, HttpSession session) {

		String username = principal.getName();
		logger.trace(username + " has logged in to portal");
		User employee = employeeService.getEmployeebyUsername(username);

		List<Ticket> tickets = ticketService.getTicketByUser(employee);

		session.setAttribute("EmployeeName", employee.getEmployeeName());
		request.setAttribute("tickets", tickets);

		return "user/welcome";
	}

	@RequestMapping("/raiseTicket")
	public String raiseTicketPage() {

		return "/user/raiseTicket";
	}

	// persist ticket into db
	@RequestMapping("/saveTicket")
	public String saveTicket(@ModelAttribute TicketRaiseDto ticketRequest, Principal principal) {
		String username = principal.getName();
		logger.trace(username + "-> has raised a new ticket");
		// System.out.println(ticketRequest);

		User employee = employeeService.getEmployeebyUsername(username);
		// System.out.println(employee);
		Ticket ticket = portalService.constructTicket(ticketRequest, employee);
		Ticket savedTicket = ticketService.createTicket(ticket);

		return "redirect:/user/index";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Principal principal) {
		String username = principal.getName();
		logger.trace(username + "-> has deleted a ticket");
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));

		ticketService.deleteTicket(ticketId);

		return "redirect:/user/index";
	}

	// display edit page
	@RequestMapping("/editpage")
	public String editPage(HttpServletRequest request, Model model) throws TicketNotFoundException {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		Ticket ticket = ticketService.getTicket(ticketId);
		if (ticket == null) {
			throw new TicketNotFoundException("TICKET_NOT_FOUND");
		} else {
			model.addAttribute(ticket);
			return "/user/editPage";
		}

	}

// update ticket handle
	@RequestMapping("/editTicket")
	public String updateHandler(@ModelAttribute TicketUpdateDto ticketUpdateDto, Principal principal) {

		String username = principal.getName();
		logger.trace(username + " -> updated ticket No" + ticketUpdateDto.getTicketId());
		User employee = employeeService.getEmployeebyUsername(username);

		Ticket ticket = portalService.constructTicket(ticketUpdateDto, employee);

		Ticket updateTicket = ticketService.updateTicket(ticket);

		return "redirect:/user/index";
	}
}
