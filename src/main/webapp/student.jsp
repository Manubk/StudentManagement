<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.dao.StudentDaoI"%>
<%@page import="com.studentmanagement.bean.Student" %>
 <!-- varifying if the user is login or not -->
<%		
// 		only if student is loged in  and only student loged in can access this page
		String role = (String)session.getAttribute("role");
		if(session.getAttribute("userName") == null && !role.equalsIgnoreCase("student"))
				response.sendRedirect("signup.jsp");
%>
	
<!-- 	declearing required variables -->
<%
	String email = null;
	StudentDaoI studentDao = null;
	Student student = null;
%>

<!-- 	getting studetails from database -->
<%	
		 email = (String)session.getAttribute("email");	
		 studentDao = DaoUtil.getStudentDaoObject();
		 student = studentDao.read(email);
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>Mbk Edu | StudentView</title>
</head>
<body>
    <header>
        <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
        <h1>MBK Education</h1>
     </header>
     <nav>
         <a href="Home.jsp">Home</a>&ensp;|&ensp;
         <a href="#">About us</a>&ensp;|&ensp;
         <a href="#">Contact us</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()+"/student.jsp"%>">Profile</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()+"/logout"%>">Logout</a>&ensp;
         <hr>
     </nav>
     <h1 style="text-align:center;">Details</h1>
     	 <table>
        <tr>
            <td><b>Id :</b> </td>
            <td><%=student.getStudent_Id()%></td>
            <td><b>Email :<b></td>
            <td><%=student.getEmail() %></td>
        </tr>
        <tr>
            <td><b>Name :</b> </td>
            <td><%=student.getName() %></td>
            <td><b>Password :</b></td>
            <td><%=student.getPass() %></td>
        </tr>
        <tr>
            <td><b>Father :</b> </td>
            <td><%=student.getFather() %></td>
            <td><b>Mother :</b></td>
            <td><%=student.getMother() %></td>
        </tr>
        <tr>
            <td><b>Dob :</b> </td>
            <td><%=student.getDob() %></td>
            <td><b>Class :</b></td>
            <td><%=student.getClass_Id() %></td>
        </tr>
        <tr>
            <td><b>Gender :</b> </td>
            <td><%=student.getSex() %></td>
            <td><b>Grade :</b></td>
            <td><%=student.getGrade() %></td>
        </tr>
        <tr>
            <td><b>Phone :</b> </td>
            <td><%=student.getPhone()%></td>
            <td><b>Fee Paid :</b></td>
            <td><%=student.getFreePaid() %></td>
        </tr>
        <tr>
            <td><b>Par Phone :</b> </td>
            <td><%=student.getParPhone() %></td>
            <td><b>Attendance :</b></td>
            <td><%=student.getAttandance() %></td>
        </tr>
     </table>
     <br>
    	<button><a href="<%=request.getContextPath()%>/student-edit.jsp?email=<%=student.getEmail()%>">edit</a></button>
     <br>
  
    
     <footer>
        <a href="#">Privacy Policy</a>&ensp;
        <a href="#">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
    </footer>
    
</body>
</html>