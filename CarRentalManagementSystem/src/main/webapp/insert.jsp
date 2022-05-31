<%-- Insert Form page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
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
			<a style="align:right;color:white" href = "logoutServlet" class="nav-link">Logout</a>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Insert Form</h3>
			<hr>
			<br>
			</div>
			</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="CarServlet">
					<fieldset class="form-group">
					<label>Enter Car Name : <input type = "text" name = "carname" required></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Enter Car Type : <input type = "text" name = "cartype" required></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Enter Car availability date : <input type = "date" name = "avail_from" placeholder = "yyyy-mm-dd" required></label>
					</fieldset>
					<fieldset class="form-group">
					<input type = "submit" value = "Add">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>