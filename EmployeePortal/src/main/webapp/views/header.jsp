<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<h1 class="navbar-brand">Employee Portal</h1>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only"></span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/register">Sign Up <span class="sr-only"></span></a></li>
				<li class="nav-item active"><a class="nav-link" href="/signin">login
						<span class="sr-only"></span>
				</a></li>



			</ul>

		</div>
	</nav>



</body>
</html>