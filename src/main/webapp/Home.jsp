<%@page import="com.studentmanagement.dao.ClassDaoI"%>
<%@page import="com.studentmanagement.dao.StudentDaoI"%>
<%@page import="com.studentmanagement.dao.TeacherDaoI"%>
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.controller.TeacherController"%>
<%@page import="com.studentmanagement.util.DbConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.coyote.Request"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import= "com.studentmanagement.bean.*" %>
   
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>MBK Edu | Home</title>
</head>
<body>

	<% 
	String userName =(String)session.getAttribute("userName");
			
	%>	
<!-- 	declearing the required variables for this page -->
	<%
	TeacherDaoI teacherDao = DaoUtil.getTeacherDaoObject();
	StudentDaoI studentDao = DaoUtil.getStudentDaoObject();
	ClassDaoI classDao = DaoUtil.getClassDaoObject();
		
	int totalTeachers = 0;
	int totalStudents = 0;
	int totalCalsses = 0;
	String role = (String)session.getAttribute("role");
	String profile = request.getContextPath();
	%>
<!-- 	getting total number fo teachers and students-->
	<%
	totalTeachers = teacherDao.noOfTeachers();
	totalStudents = studentDao.noOfStudents();
	totalCalsses = classDao.noOfClasses();
	%>
	
<% 	if(role != null) {
	if(role.equalsIgnoreCase("admin"))
		profile+="/admin.jsp";
	else if(role.equalsIgnoreCase("teacher"))
		profile+="/teacher.jsp";
	else if(role.equalsIgnoreCase("student"))
		profile+="/student.jsp";
}
%>
 	
	
	
    <header>
       <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
       <h1>MBK Education</h1>
    
    
    	<%
		if(userName != null){
		%>
        <h3 style="text-align:left; color:blue;" >Welcome</h3>
        <p style="text-align:left; color:blue;" ><%=userName%></p>
         <%
		}
         %>
         
    <nav>
        <a href="Home.jsp">Home</a>&ensp;|&ensp;
        <a href="aboutus.jsp">About us</a>&ensp;|&ensp;
        <a href="contactus.jsp">Contact us</a>&ensp;|&ensp;
        
        <% if(userName != null ){ %>
        <a href="<%=profile%>">Profile</a>&ensp;|&ensp;
        <a  href="<%=request.getContextPath()%>/logout">Logout</a>&ensp;
        <%
        }
        else{
        %>
        <a href="<%=request.getContextPath()%>/login.jsp">Login</a>&ensp;
        <%
        }
        %>
        <hr>
    </nav>
    </header>
    <main>
        <section>
            <h1>Our Vesion</h1>
            <p>Our vision is to develop well rounded, confident and responsible individuals who aspire to achieve their full potential. We will do this by providing a welcoming, happy, safe, and supportive learning environment in which everyone is equal and all achievements are celebrated</p>
        </section>

       
            <table>
           			<tr>
           			<th>Teachers</th>
                    <th>Students</th>
                    <th>Classes</th>
           			</tr>
                <tr>
                    <td><%=totalTeachers %></td>
                    <td><%=totalStudents %></td>
                    <td><%=totalCalsses %></td>
                </tr>
            </table>
      
        <br>
        <section>
            <img src="resources/pic1.jpg" alt="MBK Edu" width="33%">
            <img src="resources/pic4.jpg" alt="MBK Edu" width="33%">
            <img src="resources/pic3.jpg" alt="MBK Edu" width="33%">
        </section>
        <div>
            <form action="/classdetails.html">
                <button type="submit">View Your Class Details</button>
            </form>
        </div>
    </main>
    <footer>
        <a href="privacy-and-policy.jsp">Privacy Policy</a>&ensp;
        <a href="contactus.jsp">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
    </footer>
    
</body>
</html>