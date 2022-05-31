<%--The page that displays when some action has some error --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Action fail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file ="header1.jsp" %>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<button onclick="history.back()" style="position:left">Back</button>
				 <h2 align = "center"><font color = "red"> Action Failed!!!</font></h2>
			</div>
		</div>
	</div>
</body>
</html>