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
			<h3 class="text-center">List of Members</h3>
			<hr>
			<br>
			<div class="container text-center">
			<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="memberRequests.jsp" class="btn btn-success">Requests</a>
				&nbsp;&nbsp;&nbsp;&nbsp;

				<a href="searchMember.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Member ID</th>
						<th>User ID</th>
						<th>Member Name</th>
						<th>Password</th>
						<th>Member Full name</th>
						<th>Member Email Id</th>
						<th>Member Address</th>
						<th>Member Contact number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<%
				  try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select * from MemberTable ";
					  stmt = connection.prepareStatement(query);
					  //out.println(query);
					  rs = stmt.executeQuery();
					  while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("memberid") %></td>
				<td><%=rs.getString("userid") %></td>
				<td><%=rs.getString("username") %></td>
				<td><%=rs.getString("pwd") %></td>
				<td><%=rs.getString("fullname") %></td>
				<td><%=rs.getString("email_id") %></td>
				<td><%=rs.getString("address") %></td>
				<td><%=rs.getString("ph_no") %></td>
				<td> <a href="deleteMember?userid=<%=rs.getString("userid") %>" class = "btn btn-success">Delete</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a href="editUser.jsp?userid=<%=rs.getString("userid") %>" class = "btn btn-success">Edit</a></td>
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