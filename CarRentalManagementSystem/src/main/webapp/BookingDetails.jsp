<%--The page that displays the booking details for admin--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.dao.*"%>
<%@page import= "java.sql.*" import = "java.util.*" %>
<%
try {
			Class.forName("org.postgresql.Driver");
}catch(ClassNotFoundException e){
e.printStackTrace();
}
Connection connection = null;
PreparedStatement pst = null;
ResultSet rs = null;
int st = CarDao.reservetobooking();
if(st != 0){
	System.out.println("reserve table to booking table");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file = "header.jsp" %>
	<br>
           <div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="BookingDetails.jsp">
					<fieldset><label>Enter User Name : <input type = "text" name = "username" required></label>
					</fieldset>
					<fieldset>
					<input type = "submit" value = "Fetch">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Booking Details</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Car ID</th>
						<th>User Name</th>
						<th>Car Name</th>
						<th>Car Type</th>
						<th>Booked From</th>
						<th>Return Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<%
				try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select carid,username,carname,cartype,book_date,booked_till from BookTable WHERE username = ? AND status = ?";
					  pst = connection.prepareStatement(query);
					  String username = request.getParameter("username");
					  pst.setString(1,username);
					  pst.setString(2,"booked");
					  //out.println(query);
					  rs = pst.executeQuery();
					while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("carid") %></td>
				<td><%=rs.getString("username") %></td>
				<td><%=rs.getString("carname") %></td>
				<td><%=rs.getString("cartype") %></td>
				<td><%=rs.getString("book_date") %></td>
				<td><%=rs.getString("booked_till") %></td>
				<td><a href = "cancelBooking?carid=<%=rs.getString("carid") %>&username=<%=rs.getString("username") %>" class ="btn btn-success">Return</a></td>
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