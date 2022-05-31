<%--The page that displays the booking result member --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
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
int carid = (Integer)(request.getAttribute("carid"));
String msg = "Car with the car id " + carid + " have been booked Successfully!";%>


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
    var msg = <%=msg%>;
    alert(msg);
</script>
</head>
<body>
<%@ include file = "header2.jsp" %>
	<br>
            
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
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
					</tr>
				</thead>
				<%
				try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select carid,username,carname,cartype,book_date,booked_till from BookTable WHERE carid = ? AND status = ?";
					  pst = connection.prepareStatement(query);
					  pst.setInt(1,carid);
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