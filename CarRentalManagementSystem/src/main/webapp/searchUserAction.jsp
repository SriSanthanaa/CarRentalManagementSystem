<%-- Search Results --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="y"%>
<%@page import= "java.util.*" %>
<%@page import= "com.sriadmin.adminman.dao.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file = "header.jsp" %>
	<br>
	<jsp:useBean id = "ob" class= "com.sriadmin.usermanage.model.User"/>
<jsp:setProperty property="*" name="ob"/>
	<% List<User> list = UserAdminDao.searchUser(ob);
request.setAttribute("list",list);
if(list != null){
%>		
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<br>
			<div class="container text-center">
			<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="insertUser.jsp" class="btn btn-success">Add</a>
				&nbsp;&nbsp;&nbsp;&nbsp;

				<a href="searchUser.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<table class="table table-bordered" style="width:100%">
				<thead>
					<tr>
						<th>User ID</th>
						<th>User Name</th>
						<th>Password</th>
						<th>User Full name</th>
						<th>User Email Id</th>
						<th>User Address</th>
						<th>User Contact number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<y:forEach items="${list}" var="b">
				<tr>
				<td>${b.getUserid() }</td>
				<td>${b.getUsername() }</td>
				<td>${b.getPwd() }</td>
				<td>${b.getFullname() }</td>
				<td>${b.getEmail_id() }</td>
				<td>${b.getAddress() }</td>
				<td>${b.getPh_no() }</td>
				<td> <a href="deleteUser?userid=${b.getUserid() }" class = "btn btn-success">Delete</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="editUser.jsp?userid=${b.getUserid() }" class = "btn btn-success">Edit</a></td>
				</tr>
				</y:forEach>
			</table>
		</div>
	</div>
 <%
				}
else{
	response.sendRedirect("searchfail.jsp");
}
				%>   
</body>
</html>