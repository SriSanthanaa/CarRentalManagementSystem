<%-- Home Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.adminman.model.*"%>
<%@page import= "java.sql.*" %>

<%
try {
			Class.forName("org.postgresql.Driver");
}catch(ClassNotFoundException e){
e.printStackTrace();
}
Connection connection = null;
PreparedStatement stmt = null;
ResultSet rs = null;
%>
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
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">List of Users</h3>
			<hr>
			<br>
			<div class="container text-center">
				<a href="insertUser.jsp" class="btn btn-success">Add</a>
				&nbsp;&nbsp;&nbsp;&nbsp;

				<a href="searchUser.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<table class="table table-bordered" style="table-layout:auto;width:100%;">
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
				<%
				  try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select * from UserTable ";
					  stmt = connection.prepareStatement(query);
					  //out.println(query);
					  rs = stmt.executeQuery();
					  while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("userid") %></td>
				<td><%=rs.getString("username") %></td>
				<td><%=rs.getString("pwd") %></td>
				<td><%=rs.getString("fullname") %></td>
				<td><%=rs.getString("email_id") %></td>
				<td><%=rs.getString("address") %></td>
				<td><%=rs.getString("ph_no") %></td>
				<td> <a href="deleteUser?userid=<%=rs.getString("userid") %>" class = "btn btn-success">Delete</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a href="editForm.jsp?userid=<%=rs.getString("userid") %>" class = "btn btn-success">Edit</a></td>
				</tr>
				<%
					  }
					  connection.close();
				  }catch(Exception e){
					  e.printStackTrace();
				  }
				%>
			</table>
		</div>
	</div>
    
</body>
</html>