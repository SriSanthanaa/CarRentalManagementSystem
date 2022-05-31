<%-- Admin Home Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.adminman.model.*"%>
<%@page import= "java.sql.*" %>

<%
Admin a = (Admin) session.getAttribute("currentSessionUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
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
			<ul class="navbar-nav">
				<li><a href="index.jsp"
					class="nav-link" style="color:white;"><b>Cars</b></a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="userindex.jsp"
					class="nav-link" style="color:white;"><b>Users</b></a></li>
			</ul>
			<div>
				<h4 style="color:white;float: right;">Welcome back Admin! <%=a.getAdmin_name() %></h4>
			</div>
		</nav>
	</header>
	<br>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Home Page</h3>
			<hr>
			<br>
			<div class="container text-center">
				<a href="userindex.jsp" class="btn btn-success">Manage Users</a>
				<br><br>

				<a href="memberindex.jsp" class="btn btn-success">Manage Members</a>
				<br><br>
				
				<a href="index.jsp" class="btn btn-success">Manage Cars</a>
				<br><br>
				
				
			</div>
			<br>
		</div>
	</div>
    
</body>
</html>