<%-- Result page after editing --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.sriadmin.usermanage.model.*"%>
    <%@page import = "com.sriadmin.adminman.dao.*" %>
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
<%@ include file = "header2.jsp" %>
	<br>
	<jsp:useBean id = "ob" class= "com.sriadmin.usermanage.model.User"/>
<jsp:setProperty property="*" name="ob"/>
<%

String msg;

if(UserAdminDao.updateUser(ob) >0){
	msg = "Success";
}
else{
	msg = "User not found";
}
System.out.println(msg);
%>
<%
response.sendRedirect("userhome.jsp");
%>
</body>
</html>