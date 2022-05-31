<%--The page that displays the car reservation form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.web.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file = "header.jsp" %>
	<br>
	<% Integer carid = Integer.parseInt(request.getParameter("carid")); %>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Reservation Form</h3>
			<hr>
			<br>
			</div>
			</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="reserveCarServlet">
					<fieldset><label>Car ID : <input type = "number" name = "carid" value = <%=carid %> readonly></label>
					</fieldset>
					<fieldset><label>Enter user name : <input type = "text" name = "username" required></label>
					</fieldset>
					<fieldset><label>Enter reserve from date : <input type = "date" name = "reserve_from" placeholder = "yyyy-mm-dd" required></label>
					</fieldset>
					<fieldset><label>Enter reserve till date : <input type = "date" name = "reserve_till" placeholder = "yyyy-mm-dd" required></label>
					</fieldset>
					<fieldset><input type = "submit" value = "Reserve"></fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>