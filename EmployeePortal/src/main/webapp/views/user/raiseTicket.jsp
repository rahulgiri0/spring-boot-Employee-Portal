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
<body style="background-color: #e2e2e2;">


	<div class="container">

		<div class="row mt-3">
			<div class="col-md-6 offset-md-3 bg-white p-4">
				<div class="container text-center mt-5">
					<h1>Raise Ticket</h1>

				</div>

				<form action="saveTicket" method="post">

					<div class="mb-3">
						<label for="category" class="form-label">Ticket Category:</label>
						<input type="text" class="form-control" name="category"
							aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Description:</label>
						<textarea class="form-control" rows="4" cols="50" name="description">Enter text here...</textarea>
					</div>
					<div class="row mb-2 text-center">
						
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