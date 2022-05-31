<%-- Register page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: red">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Car
					Rental System </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Registration Form</h3>
			<hr>
			<br>
			</div>
			</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="UserServlet1">
					<fieldset class="form-group"><label>Enter your User name : <input type = "text" name = "username" required></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Enter your Password : <input type = "password" name = "pwd" required></label>
					</fieldset>
					<fieldset class="form-group"><label>Enter your Full name : <input type = "text" name = "fullname" required></label>
					</fieldset>
					<fieldset class="form-group"><label>Enter your e-mail id : <input type = "email" name = "email_id" required></label>
					</fieldset>
					<fieldset class="form-group"><label>Enter your address : <input type = "text" name = "address" required></label>
					</fieldset>
					<fieldset class="form-group"><label>Enter your Phone number : <input type = "text" name = "ph_no"  required></label>
					</fieldset>
					<fieldset class="form-group">
					<h5 align = "center"><input type = "submit" value = "Register"></h5>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>