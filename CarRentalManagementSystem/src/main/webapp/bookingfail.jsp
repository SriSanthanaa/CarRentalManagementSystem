<%--The page that displays when booking fails --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script type="text/javascript">
    var msg = "Car Booking failed";
    alert(msg);
</script>
</head>
<body>
<%@ include file = "header.jsp" %>
	<br>
            <% Car c = (Car) (session.getAttribute("currentSessionUser"));%>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<br>
				<h5 align="center">Booking Failed!!!!!</h5>
		</div>
	</div>
    
</body>
</html>