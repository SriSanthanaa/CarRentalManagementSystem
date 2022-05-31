<%--The page that displays the Edit form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.sriadmin.usermanage.model.*" %>
    <%int userid = Integer.parseInt(request.getParameter("userid")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@ include file = "header1.jsp" %>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="EditUserAction1.jsp">
					<fieldset class="form-group"><label>Enter User ID : <input type = "number" name = "userid" value = <%=userid %> readonly></label>
					</fieldset>
					<fieldset class="form-group">
					<label>User Name : <input type = "text" name = "username" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Full Name : <input type = "text" name = "fullname" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>E-mail : <input type = "text" name = "email_id" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Address : <input type = "text" name = "address" ></label>
					</fieldset>
					<fieldset class="form-group">
					<label>Phone number : <input type = "text" name = "ph_no" ></label>
					</fieldset>
					<fieldset class="form-group">
					<input type = "submit" value = "Edit">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>