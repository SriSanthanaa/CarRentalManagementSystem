<%--The page that displays the Edit form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
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
			<h3 class="text-center">Editing Form</h3>
			<hr>
			<br>
			</div>
			</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="EditAction.jsp">
					<fieldset class="form-group"><label>Enter Car ID : <input type = "number" name = "carid" required></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Car Name : <input type = "text" name = "carname" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Car Type : <input type = "text" name = "cartype" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Availability Date : <input type = "date" name = "avail_from" ></label>
					</fieldset>
					<fieldset class="form-group">
					<input type = "submit" value = "Edit">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>