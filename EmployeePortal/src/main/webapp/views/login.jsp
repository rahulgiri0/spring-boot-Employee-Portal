<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Login: Employee Portal</title>
</head>
<body style="background-color: #e2e2e2;">


	<div class="container">

		<div class="row mt-3">
			<div class="col-md-6 offset-md-3 bg-white p-4">
				<div class="container text-center mt-5">
					<h1>Employee Portal</h1>
					<h6>Please Enter Your Credentials to Login</h6>
				</div>
				<c:url var="loginUrl" value="/dologin" />
				<form action="${loginUrl}" method="post" >
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="mb-3">
						<label for="username" class="form-label">User Name:</label> <input
							type="text" class="form-control" name="username" required
							aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password:</label> <input
							type="password" class="form-control" name="password" required>
					</div>
					<div class="mb-3 text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>

				</form>
			</div>

		</div>

	</div>


</body>
</html>