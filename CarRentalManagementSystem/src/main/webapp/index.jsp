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
            <% 
            Car c = (Car) (session.getAttribute("currentUser"));%>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">List of Cars</h3>
			<hr>
			<br>
			<div class="container text-center">
				<a href="insert.jsp" class="btn btn-success">Add</a>
				&nbsp;&nbsp;&nbsp;&nbsp;

				<a href="search.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="Edit.jsp" class="btn btn-success">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="BookingDetails.jsp" class="btn btn-success">Booked Cars</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="TrackDetails.jsp" class="btn btn-success">Track Cars Details</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Car ID</th>
						<th>Car Name</th>
						<th>Car Type</th>
						<th>Available Date</th>
						<th>Actions</th>
						<th>Book/Reserve</th>
					</tr>
				</thead>
				<%
				  try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select carid,carname,cartype,avail_from from CarTable ";
					  stmt = connection.prepareStatement(query);
					  //out.println(query);
					  rs = stmt.executeQuery();
					  while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("carid") %></td>
				<td><%=rs.getString("carname") %></td>
				<td><%=rs.getString("cartype") %></td>
				<td><%=rs.getString("avail_from") %></td>
				<td> <a href="delete?carid=<%=rs.getString("carid") %>" class = "btn btn-success">Delete</a></td>
				<td> <a href="book.jsp?carid=<%=rs.getString("carid") %>" class = "btn btn-success">Book</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="reserve.jsp?carid=<%=rs.getString("carid") %>" class = "btn btn-success">Reserve</a>
				</td>
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