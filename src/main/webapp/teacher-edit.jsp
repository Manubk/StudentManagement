
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.dao.TeacherDaoI"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.studentmanagement.bean.*"  %>

<!-- varifying if the user is login or not -->
<%
if(session.getAttribute("userName") == null )
	response.sendRedirect("signup.jsp");
%>
	
<%	
	Teacher teacher = null;
	TeacherDaoI teacherDao =  DaoUtil.getTeacherDaoObject();
// 	teacher = teacherDao.read((String)session.getAttribute("email"));
	teacher = teacherDao.read(request.getParameter("email"));
	System.out.print(request.getParameter("email"));
%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css"/>
    <title>Mbk Edu | Teacher Profile</title> 
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
         <a href="<%=session.getAttribute("profile") %>">Profile</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()%>/logout">Logout</a>&ensp;
         <hr>
     </nav>
     <h1 style="text-align: center;">Details</h1>
     <form action="updateteacher" method="post">
     	<table>
        <tr>
            <td><b>Id :</b> </td>
            <td><input type="number" name="id" value="<%=teacher.getTeacher_id() %>"></td>
            <td><b>Phone :</b></td>
            <td><input type="number" name="phone" value="<%=teacher.getPhone() %>"></td>
        </tr>
        <tr>
            <td><b>Name :</b> </td>
            <td><input type="text" name="name" value="<%=teacher.getName() %>" ></td>
            <td><b>Email :</b></td>
            <td><input type="email" name="email" value="<%=teacher.getEmail() %>" ></td>
        </tr>
        <tr>
            <td><b>Father :</b> </td>
            <td><input type="text" name="father" value="<%=teacher.getFather() %>" ></td>
            <td><b>Password :</b></td>
            <td><input type="text" name="password" value="<%=teacher.getPass()%>" ></td>
        </tr>
        <tr>
            <td><b>Dob :</b> </td>
            <td><input type="date" name="dob" value="<%=teacher.getDob() %>" ></td>
            <td><b>Salary :</b></td>
            <td><input type="number" name="salary" value="<%=teacher.getSalary() %>"> </td>
        </tr>
        <tr>
            <td><b>Gender :</b> </td>
            <td> <input type="text" name="sex" value="<%=teacher.getSex()%>"></td>
            <td><b>Attendance :</b></td>
            <td><input type="number" name="attendance" value="<%=teacher.getAttendance()%>"></td>
        </tr>
        
     </table>
     <input type="submit" value="Save">
     </form>
     
     <br>

     <footer>
        <a href="#">Privacy Policy</a>&ensp;
        <a href="#">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
    </footer>
    
</body>
</html>