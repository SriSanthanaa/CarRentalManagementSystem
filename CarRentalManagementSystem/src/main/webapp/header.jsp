<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.adminman.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<a href="adminhome.jsp" class="navbar-brand"> Car
					Rental System </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="userindex.jsp"
					class="nav-link" style="color:white;"><b>Users</b></a></li>
				<li><a href="index.jsp"
					class="nav-link" style = "color:white;"><b>Cars</b></a></li>
				<li><a href="reserveDetails.jsp"
					class="nav-link" style = "color:white;"><b>Reserved Car Details</b></a></li>
				<li style="float:right;margin-right:10px"><h6 style="color:white;">Welcome back Admin!</h6></li>	
				
			</ul>
			<br>
			<a style="align:right;color:white" href = "logoutServlet" class="nav-link">Logout</a>
		</nav>
	</header>
</body>
</html>