<%--The page that displays the car booking form for member --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.sriadmin.usermanage.model.*" import = "com.sriadmin.usermanage.web.*" import = "java.util.Date"%>
<%@ page import = "java.text.*" import = "java.sql.*" %>
<%
try {
			Class.forName("org.postgresql.Driver");
}catch(ClassNotFoundException e){
e.printStackTrace();
}
Connection connection = null;
PreparedStatement pst = null;
ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file = "header1.jsp" %>
	<br>
	<% Integer carid = Integer.parseInt(request.getParameter("carid"));
	String username = String.valueOf(session.getAttribute("username"));
	%>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
		<button onclick="history.back()" class = "btn btn-success">Back</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
			<h3 class="text-center">Booking Form</h3>
			<hr>
			<br>
			</div>
			</div>
	<%
				try{
					  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
					  String query = "select avail_from from CarTable WHERE carid = ?";
					  pst = connection.prepareStatement(query);
					  pst.setInt(1,carid);
					  //out.println(query);
					  rs = pst.executeQuery();
					  rs.next();
					  String avail_from = rs.getString("avail_from");
	  			%>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="bookServlet">
					<fieldset><label>Car ID : <input type = "number" name = "carid" value = <%=carid %> readonly></label>
					</fieldset>
					<fieldset><label>Enter user name : <input type = "text" name = "username" value = <%=username %> readonly></label>
					</fieldset>
					<fieldset><label>Enter booking date : <input type = "date" name = "avail_from" placeholder = "yyyy-mm-dd" value = <%=avail_from %> min = "<%=avail_from %>" readonly></label>
					</fieldset>
					<fieldset><label>Enter the till date : <input type = "date" name = "book_till" placeholder = "yyyy-mm-dd" required></label>
					</fieldset>
					<fieldset class= "text-center"><input type = "submit" value = "Book"></fieldset>
				</form>
				<%
					  connection.close();
                }catch(Exception e){
	  				e.printStackTrace();
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>