<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ForgetPassword</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h2 class="text-center mb-4">Forget Password</h2>
		<form action="ForgetPasswordServlet" method="post">

			<!-- Email -->
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="Enter email">
			</div>

			<!-- Submit Button -->
			<button type="submit" class="btn btn-primary btn-block">Help me</button>
		</form>

		${errorMessage}<br>
			<a href="Signup.jsp">Signup</a>
	|
	<a href="Login.js">Login</a>
	
	</div>

	<br>
	

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
