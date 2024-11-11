<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h2 class="text-center mb-4">Signup</h2>
		<form action="SignupServlet" method="post">
			<!-- First Name -->
			<div class="form-group">
				<label for="firstname">First Name</label> <input type="text"
					class="form-control" id="firstname" name="firstname"
					placeholder="Enter first name" >
			</div>   

			<!-- Last Name -->
			<div class="form-group">
				<label for="lastname">Last Name</label> <input type="text"
					class="form-control" id="lastname" name="lastname"
					placeholder="Enter last name"  >
			</div>

			<!-- Email -->
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="Enter email"  >
			</div>

			<!-- Password -->
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter password"  >
			</div>


			<!-- City -->
			<div class="form-group">
				<label for="city">City</label> <input type="text"
					class="form-control" id="city" name="city" placeholder="Enter city"
					 >
			</div>

			<!-- Submit Button -->
			<button type="submit" class="btn btn-primary btn-block">Sign
				Up</button>
		</form>
		
		${errorMessage}
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
