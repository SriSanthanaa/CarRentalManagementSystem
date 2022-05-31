<%-- Home Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*"%>
<%@page import= "java.sql.*" import = "com.sriadmin.usermanage.dao.*" import= "java.text.*"%>

<%
try {
			Class.forName("org.postgresql.Driver");
}catch(ClassNotFoundException e){
e.printStackTrace();
}
Connection connection = null;
PreparedStatement stmt = null;
ResultSet rs = null;
int st = CarDao.findCar();

%>
<% 
            String username = request.getParameter("username");
System.out.println(username);
/*if(st == 0){
	request.setAttribute("username", username);
    RequestDispatcher rd = request.getRequestDispatcher("noCars.jsp");
    rd.forward(request, response); 
}*/
session.setAttribute("username",username);
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
<header>

		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: red">
			<div>
				<a href="userhome.jsp" class="navbar-brand"> Car
					Rental System </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="userhome.jsp"
					class="nav-link" style = "color:white;"><b>Cars</b></a></li>
				<li><a href="ProfileUser.jsp"
					class="nav-link" style="color:white;"><b>My account</b></a></li>
				<li><a href = "requestMember?username=<%=request.getParameter("username")%>"
					class="nav-link" style="color:white;"><b>Request For Membership</b></a></li>
					
				<li style="float:right;margin-right:10px" class="nav-link"><h6 style="color:white;">Welcome back User!</h6></li>	
				
			</ul>
			<br>
			<a style="align:right;color:white" href = "logoutServlet" class="nav-link">Logout</a>
		</nav>
	</header>
	<br>
            
			
           <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Cars</h3>
			<hr>
			<br>
			<div class="container text-center">
			
				
				<a href="searchformuser.jsp" class="btn btn-success">Search</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="bookingDetailsUser.jsp?" class="btn btn-success">Booked Cars</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Car ID</th>
						<th>Car Name</th>
						<th>Car Type</th>
						<th>Available Date</th>
						<th>Book</th>
					</tr>
				</thead>
				<%
				  try{
					  String date1 = CarDao.get_Date();
					  java.sql.Date date = java.sql.Date.valueOf(date1);
					  date = Date.valueOf(date1);
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select carid,carname,cartype,avail_from from CarTable WHERE avail_from::date = ?";
					  stmt = connection.prepareStatement(query);
					  //out.println(query);
					  stmt.setDate(1,date);
					  rs = stmt.executeQuery();
						  while(rs.next()){
					  
				%>
				<tr>
				<td><%=rs.getString("carid") %></td>
				<td><%=rs.getString("carname") %></td>
				<td><%=rs.getString("cartype") %></td>
				<td><%=rs.getString("avail_from") %></td>
				<td> <a href="bookform.jsp?carid=<%=rs.getString("carid") %>" class = "btn btn-success">Book</a></td>
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