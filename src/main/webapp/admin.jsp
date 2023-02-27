<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- 	varifying credencials beforing rendering the page -->
<%
	String role = (String)session.getAttribute("role");
	String userName = (String)session.getAttribute("userName");
	System.out.print(role);
	if(!(role != null && role.equalsIgnoreCase("admin")))
		response.sendRedirect("login.jsp");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css"/>
    <title>Mbk Edu | Admin Panel</title>
</head>
<body>
    <header>
        <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
        <h1>MBK Education</h1>
     
     <nav>
         <a href="Home.jsp">Home</a>&ensp;|&ensp;
         <a href="aboutus.jsp">About us</a>&ensp;|&ensp;
         <a href="contactus.jsp">Contact us</a>&ensp;|&ensp;
         <a href="#">Profile</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()%>/admin.jsp">Admin</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()%>/logout">Logout</a>&ensp;
         <hr>
     </nav>
     </header>
     <div class="parent">
        <div class="child">
            <button ><a href="All-Students.jsp"> All Students </a></button> <br><br>
            <button ><a href="All-Teachers.jsp"> All Teachers </a></button> <br><br>
            <button ><a href="#"> All Class </a></button>
        </div>
     </div>
     <footer>
        <a href="#">Privacy Policy</a>&ensp;
        <a href="#">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
    </footer>
</body>
</html>