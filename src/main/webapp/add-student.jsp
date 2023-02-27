
<%@page import="com.studentmanagement.dao.StudentDaoI"%>
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.dao.TeacherDaoI"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.studentmanagement.bean.*"  %>

<!-- varifying if the user is login or not -->
<%
String role = (String)session.getAttribute("role");
String userName = (String)session.getAttribute("userName");
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
    <title>Mbk Edu | Add Student</title> 
</head>
<body>
    <header>
        <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
        <h1>MBK Education</h1>
     
     <nav>
         <a href="Home.jsp">Home</a>&ensp;|&ensp;
         <a href="aboutus.jsp">About us</a>&ensp;|&ensp;
         <a href="contactus.jsp">Contact us</a>&ensp;|&ensp;
         <a href="admin.jsp">Admin</a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()%>/logout">Logout</a>&ensp;
         <hr>
     </nav>
     </header>
     <div class="parent">
     <div class="child">
     <h1 style="text-align: center;">Fill Details</h1>
      <form action="addstudent" method="post">
     	 <table>
        <tr>
            <td><b>Id :</b> </td>
            <td><input type="number" name="id" readonly="readonly" ></td>
            <td><b>Email :</b></td>
            <td><input type="email" name="email" ></td>
        </tr>
        <tr>
            <td><b>Name :</b> </td>
            <td><input type="text" name="name" "></td>
            <td><b>Password :</b></td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><b>Father :</b> </td>
            <td><input type="text" name="father" ></td>
            <td><b>Mother :</b></td>
            <td><input type="text" name="mother" ></td>
        </tr>
        <tr>
            <td><b>Dob :</b> </td>
            <td><input type="date" name="dob" required="required" ></td>
            <td><b>Class :</b></td>
            <td><input type="number" name="classId" ></td>
        </tr>
        <tr>
            <td><b>Gender :</b> </td>
            <td>
            <label for="sexf">
            <input type="radio" name="sex" id="sexf" value="f">Female
            </label>
            <label for="sexm">
            <input type="radio" name="sex" id="sexm" value="M" >Male
            </label>
            
            </td>
            <td><b>Grade :</b></td>
            <td><input type="number" name="grade" value="0"></td>
        </tr>
        <tr>
            <td><b>Phone :</b> </td>
            <td><input type="number" name="phone" required="required" ></td>
            <td><b>Fee Paid :</b></td>
            <td><input type="number" name="feePaid" value="0"></td>
        </tr>
        <tr>
            <td><b>Par Phone :</b> </td>
            <td><input type="number" name="parPhone" required="required"></td>
            <td><b>Attendance :</b></td>
            <td><input type="number" name="attendance" value="0" ></td>
        </tr>
     </table>
     <br>
    	<input type="submit" value="save">
     <br>
     </form>
    
     
     </div>
     </div>
     
     <br>

     <footer>
        <a href="privacy-and-policy.jsp">Privacy Policy</a>&ensp;
        <a href="contactus.jsp">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
    </footer>
    
</body>
</html>