<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  

  
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


</head>
<body>
<%

response.setHeader("Cache-Control", "no-cache, no-store, must-validate");

response.setHeader("Pragma", "no-cache");

response.setHeader("Expires", "0");




%>
	<div class="container-fluid mb-3">
		<nav class="navbar navbar-expand navbar-dark  bg-dark ">
			<div class="container-fluid">
				<h1 class="navbar-brand">Employee Portal</h1>

				<form class="d-flex" action="/logout" method="post">
					<h4 class="navbar-brand">Welcome, ${EmployeeName } </h4>
					<button class="btn btn-success" type="submit">Logout</button>
				</form>
			</div>

		</nav>
	</div>


	
</body>
</html>