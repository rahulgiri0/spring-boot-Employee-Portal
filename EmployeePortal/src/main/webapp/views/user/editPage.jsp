<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="all-css-js.jsp"%>

<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Raise Ticket: Employee Portal</title>
</head>
<body>


	<div class="container">

		<div class="row mt-3">
			<div class="col-md-6 offset-md-3 bg-white p-4">
				<div class="container text-center mt-5">
					<h1>Edit Ticket</h1>

				</div>

				<form action="editTicket" method="post">
					<input type="hidden" name="ticketId" value="${ticket.ticketId }">
					<div class="mb-3">
						<label for="category" class="form-label">Ticket Category:</label>
						<input type="text" class="form-control" name="category" value="${ticket.category }" required
							aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Description:</label>
						<textarea class="form-control" rows="4" cols="50" name="description" required>${ticket.description }</textarea>
					</div>
					<div class="row mb-2">
						
						<div class="col-6">
							<input type="submit" value="Save" name="submitButton"
								class="btn btn-secondary btn-sm">
						</div>
						<div class="col-6">
							<a href="/user/index"><input type="Button" value="Cancel"
								name="Cancel" class="btn btn-secondary btn-sm"></a>
						</div>

					</div>

				</form>
			</div>

		</div>

	</div>







</body>
</html>