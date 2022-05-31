<%-- Home Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
<%@page import= "java.sql.*" %>

<%
try {
	Class.forName("org.postgresql.Driver");
}catch(ClassNotFoundException e){
e.printStackTrace();
}
Connection connection = null;
PreparedStatement stmt = null,pst = null;
ResultSet rs = null,ex = null;
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
<%@ include file = "header1.jsp" %>
	<br>
            <% 
            Car car = (Car) (session.getAttribute("currentUser"));%>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">My Profile</h3>
			<hr>
			<br>
			
			<br>
			<% String username = String.valueOf(session.getAttribute("username"));
			if(username != ""){ %>
			<table class="table table-bordered">
				<%
				  try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select * from MemberTable where username = ?";
					  stmt = connection.prepareStatement(query);
					  stmt.setString(1, username);
					  rs = stmt.executeQuery();
					  while(rs.next()){
						  int userid = Integer.parseInt(rs.getString("userid"));
				%>
				<tr>
				<th>User ID: </th>
				<td><%=rs.getString("userid") %></td>
				</tr>
				<tr>
				<th>User Name: </th>
				<td><%=rs.getString("username") %></td>
				</tr>
				<tr>
				<th>Full name: </th>
				<td><%=rs.getString("fullname") %></td>
				</tr>
				<tr>
				<th>E-mail Id: </th>
				<td><%=rs.getString("email_id") %></td>
				</tr>
				<tr>
				<th>Address: </th>
				<td><%=rs.getString("address") %></td>
				</tr>
				<tr>
				<th>Contact Number: </th>
				<td><%=rs.getString("ph_no") %></td>
				</tr>
				</table>
			<br>
			<div class = "container text-center">
				<a href="editUser1.jsp?userid=<%=userid %>" class = "btn btn-success">Edit</a>
			</div>
				<%
					  }
					  connection.close();
				  }catch(Exception e){
					  e.printStackTrace();
				  }
			}
				%>
			
			
		</div>
	</div>
    
</body>
</html>