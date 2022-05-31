<%-- Home page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
				<a href="Home.jsp" class="navbar-brand"> Car
					Rental System </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<h2 align = "center"><a href="adminLogin.jsp" class="btn btn-success">Receptionist Login</a></h2>
				<h2 align = "center"><a href="memberlogin.jsp" class="btn btn-success">Member Login</a></h2>
				<h2 align = "center"><a href="login.jsp" class="btn btn-success">User Login</a></h2>
			</div>
		</div>
	</div>
</body>
</html>