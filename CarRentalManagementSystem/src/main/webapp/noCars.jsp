<%--The page that displays no Cars page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.web.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file = "header2.jsp" %>
<%
String username = request.getParameter("username");
System.out.println(username);
session.setAttribute("username",username);%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<br>
			<h1 align = "center">No Cars Available today!!!</h1>
			<br>
			<h3 align = "center">If you need to see the cars available on other day please request for Membership!!</h3>
			<h3>Click here for membership!<a href = "requestMember?username=<%=request.getParameter("username")%>">Membership Request!</a></h3>
				
			</div>
		</div>
	</div>
</body>
</html>