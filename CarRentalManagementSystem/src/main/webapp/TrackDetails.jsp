<%--The page that displays the booking details for member--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
<%@page import= "java.sql.*" import = "java.util.*" import = "java.io.*"%>
<%
String username = String.valueOf(session.getAttribute("username"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file = "header.jsp" %>
	<br>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Booked & Reserved Car Details</h3>
			<hr>
			<br>
		<div class = "container">
			<%
			File file = new File("bookingDetails.txt");
		    Scanner sc = new Scanner(file);
		    while(sc.hasNextLine()){
			%>
			<ul style = "list-style-type:none;">
			<li><%out.println(sc.nextLine()); %></li>
			</ul>
			<%	out.println("\n");
		    }
		    sc.close(); %>
		    </div>
		</div>
	</div>
    
</body>
</html>