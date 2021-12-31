<%@page import="com.example.employeeportal.util.Message"%>
<%@page import="com.example.employeeportal.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register:Employee</title>


</head>
</head>
<body style="background-color: #e2e2e2;">

	 

	<div class="container ">
		<div class="row">
			<div class="col-md-8 offset-md-2 bg-white p-4 mt-3 ">
				<div class="my-card">
				
				<% Message message = (Message)session.getAttribute("message");
				if(message!=null && message.getType()=="alert-danger"){
				%>
				
					<div class="alert alert-danger" role="alert">
					
					<p><%=message.getContent() %></p>
					<%
					message=null;
					session.removeAttribute("message");%>
					</div>
					
					<%} else if(message!=null && message.getType()=="alert-success"){

					%>
					
					<div class="alert-success" role="alert">
					
					<p><%=message.getContent() %></p>
					<%
					message=null;
					session.removeAttribute("message");%>
					
					</div>
					<%} %>
					
						
					<h2 class="text-center">Sign Up here !!</h2>

					<form action="registerProcess" method="post">
						<div class=" form-group mb-3">
							<label for="employeeName" class="form-label">Employee
								Full Name:</label> <input type="text" class="form-control"
								name="employeeName" value="${employee.employeeName }" required
								aria-describedby="emailHelp">

						</div>
						<div class=" form-group mb-3">
							<label for="userName" class="form-label">User Name:</label> <input
								type="text" class="form-control" name="username"
								value="${employee.username }" required
								aria-describedby="emailHelp">

						</div>
						<div class="form-group mb-3">
							<label for="password" class="form-label">Password:</label> <input
								type="password" class="form-control" name="password" required>
						</div>
						<div class="form-group form-check mb-3 ">
							<input type="checkbox" name="agreement" class="form-check-input">
							<label for="agreement" class="form-label">Accept Terms
								and Conditions</label>
						</div>
						<div class="form-group mb-3 text-center">
							<button type="submit" class="btn btn-primary ">Sign Up-></button>
							<button type="reset" class="btn btn-warning ">Reset</button>
						</div>

					</form>

				</div>


			</div>
		</div>
	</div>

</body>
</html>