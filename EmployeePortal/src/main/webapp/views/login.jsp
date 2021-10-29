<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="css/index.css" rel="stylesheet">
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
				<form action="loginprocess" method="post" >
					<div class="mb-3">
						<label for="librarianId" class="form-label">Employee ID:</label> <input
							type="text" class="form-control" name="employeeId"
							aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password:</label> <input
							type="password" class="form-control" name="password">
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