<%@page import="org.apache.coyote.Request"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="com.studentmanagement.bean.Student" %>
    <!-- Varefying the user session  -->
    <% if(session.getAttribute("email") == null){
    	request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div>
	<table>
		<thead>
		<tr>
		<td> ID </td>
		<td> NAME </td>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td> ${teacher.getTeacher_id()}</td>
		</tr>
		
		</tbody>
	</table>
	
	</div>
	
</body>
</html>