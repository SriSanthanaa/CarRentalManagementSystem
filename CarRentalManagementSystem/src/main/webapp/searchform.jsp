<%--The page that displays the search form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.web.*" import = "com.sriadmin.adminman.web.*"%>
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
<%@ include file = "header1.jsp" %>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Search Form</h3>
			<hr>
		</div>
	</div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="searchaction.jsp">
					<fieldset class="form-group"><label>Search by Car ID : <input type = "number" name = "carid"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by Car name : <input type = "text" name = "carname"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by Car type : <input type = "text" name = "cartype"></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Search by Car availability date : <input type = "date" name = "avail_from" placeholder = "yyyy-mm-dd"></label>
					</fieldset>
					<fieldset class="form-group text-center">
					<input type = "submit" value = "Search">
					</fieldset>
				</form>
				<br>
				<%--
				<form action="SearchCarname">
					<fieldset class="form-group">
					<label>Search by Car name : <input type = "text" name = "carname"></label>
					</fieldset>
					<fieldset class="form-group">
					<input type = "submit" value = "Search">
					</fieldset>
				</form>
				<br>
				<form action="SearchCartype">
					<fieldset class="form-group">
					<label>Search by Car type : <input type = "text" name = "cartype"></label>
					</fieldset>
					<fieldset class="form-group"><input type = "submit" value = "Search"></fieldset>
					
				</form>
				<br>
				<form action="SearchAvaildate">
					<fieldset class="form-group">
					<label>Search by Car availability date : <input type = "date" name = "avail_from" placeholder = "yyyy-mm-dd"></label>
					</fieldset>
					<fieldset class="form-group"><input type = "submit" value = "Search"></fieldset>
				</form> --%>
				
			</div>
		</div>
	</div>
</body>
</html>