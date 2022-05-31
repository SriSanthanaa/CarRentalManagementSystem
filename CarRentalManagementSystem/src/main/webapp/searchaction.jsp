<%-- Result page after searching --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.sriadmin.usermanage.model.*"%>
    <%@page import = "com.sriadmin.usermanage.dao.*" %>
    <%@ page import = "java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
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
<%@ include file ="header1.jsp" %>
	<br>
	<jsp:useBean id = "ob" class= "com.sriadmin.usermanage.model.Car"/>
<jsp:setProperty property="*" name="ob"/>
<% String username = String.valueOf(session.getAttribute("username"));
List<Car> list = CarDao.searchCar(ob);
request.setAttribute("list",list);
if(list.size() == 0){
	response.sendRedirect("searchfailed.jsp");
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
				<c:forEach items="${list}" var="u">
				<tr>
				<td>${u.getCarid() }</td>
				<td>${u.getCarname() } </td>
				<td>${u.getCartype() } </td>
				<td>${u.getAvail_from() }</td>
				<td> <a href="bookbyuser.jsp?carid=${u.getCarid() }&username=<%=username %>" class = "btn btn-success">Book</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="reserveU.jsp?carid=${u.getCarid() }&username=<%=username %>" class = "btn btn-success">Reserve</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</body>
	</html>