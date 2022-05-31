<%--The page that displays the search form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.web.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
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
			<h3 class="text-center">Search Form</h3>
			<hr>
		</div>
	</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<br>
				<form action="searchUserAction.jsp">
				<fieldset class="form-group"><label>Search by User ID : <input type = "number" name = "userid"></label>
					</fieldset>	
					<fieldset class="form-group">
					<label>Search by User name : <input type = "text" name = "username"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by User Full Name : <input type = "text" name = "fullname"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by User E-Mail : <input type = "email" name = "email_id"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by User Address : <input type = "text" name = "address"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by User Phone number : <input type = "text" name = "address"></label>
					</fieldset>
					<fieldset class="form-group text-center">
					<input type = "submit" value = "Search">
					</fieldset>
				</form>				
			</div>
		</div>
	</div>
</body>
</html>