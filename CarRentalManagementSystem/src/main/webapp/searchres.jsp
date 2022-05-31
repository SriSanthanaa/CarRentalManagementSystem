<%-- Result page after editing --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.sriadmin.usermanage.model.*"%>
    <%@page import = "com.sriadmin.usermanage.dao.*" %>
    <%@ page import = "java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file ="header.jsp" %>
	<br>
	<jsp:useBean id = "ob" class= "com.sriadmin.usermanage.model.Car"/>
<jsp:setProperty property="*" name="ob"/>
<% List<Car> list = CarDao.searchCar(ob);
request.setAttribute("list",list);
if(list == null){
	response.sendRedirect("searchres1.jsp");
}
%>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Cars</h3>
			<hr>
			<br>
			<div class="container text-center">
				<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="searchform.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href = "bookingDetailsU.jsp" class = "btn btn-success">Booked Details</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Car ID</th>
						<th>Car Name</th>
						<th>Car Type</th>
						<th>Available Date</th>
						<th>Book/Reserve</th>
					</tr>
				</thead>
				<x:forEach items="${list}" var="a">
				<tr>
				<td>${a.getCarid() }</td>
				<td>${a.getCarname() } </td>
				<td>${a.getCartype() } </td>
				<td>${a.getAvail_from() }</td>
				<td> <a href="bookbyuser.jsp?carid=${a.getCarid() }" class = "btn btn-success">Book</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="reserveU.jsp?carid=${a.getCarid() }" class = "btn btn-success">Reserve</a></td>
				</tr>
				</x:forEach>
			</table>
		</div>
	</div>

	</body>
	</html>