<%@page import="com.example.employeeportal.model.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="all-css-js.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Welcome: Employee Portal</title>

</head>
<body style="background-color: #e2e2e2;">
	<div class="container">

		<div class="row mt-3">
			<div class="col-10 offset-1 bg-white p-2">
				<h3 class="text-center">
					Tickets<span style="margin-left: 50%;"><a href="raiseTicket"><button
								class="btn btn-outline-secondary btn-lg" type="submit">Raise
								New Ticket</button></a></span>
				</h3>
				<div class="table-responsive mt-4 ">
					<table class="table table-bordered border-primary ">
						<thead>
							<tr>
								<th scope="col" class="col-md-2">Ticket ID:</th>
								<th scope="col" class="col-md-3">Category</th>
								<th scope="col" class="col-md-2">Description</th>
								<th scope="col" class="col-md-2">Status</th>
								<th scope="col" class="col-md-2">Action</th>
							</tr>

						</thead>





						<%
						List<Ticket> list = (List<Ticket>) request.getAttribute("tickets");
						if (list == null) {
						%>
						<tr>
							<h3>No data found</h3>
						</tr>
						<%
						} else {
						for (Ticket t : list) {
						%>
						<tr>
							<td><%=t.getTicketId()%> <input type="text"
								value="<%=t.getTicketId()%>" name="bookId" hidden></td>
							<td><%=t.getCategory()%></td>
							<td><%=t.getDescription()%></td>
							<td><%=t.getStatus()%></td>

							<td>
								<div class="row">

									<div class="col-6">
										<form action="delete" method="post">
											<input type="hidden" value="<%=t.getTicketId()%>"
												name="ticketId">
											<button class="btn btn-outline-danger " type="submit">Delete</button>
										</form>
									</div>

									<div class="col-6">
										<form action="editpage" method="post">
											<input type="hidden" value="<%=t.getTicketId()%>"
												name="ticketId">
											<button class="btn btn-outline-info" type="submit">Edit</button>
										</form>
									</div>

								</div>
							</td>
						</tr>

						<%
						}
						}
						%>



					</table>


				</div>


			</div>

		</div>

	</div>
</body>
</html>