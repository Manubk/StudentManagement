<%@page import="java.util.*"%>
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.dao.TeacherDaoI"%>
<%@page import="com.studentmanagement.bean.Teacher" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  
<!-- 	varifying credencials beforing rendering the page -->
<%
	String role = (String)session.getAttribute("role");
	String userName = (String)session.getAttribute("userName");
	if(!(role != null && role.equalsIgnoreCase("admin")))
		response.sendRedirect("login.jsp");
%>
<%
	TeacherDaoI teacherDao = DaoUtil.getTeacherDaoObject();
	List<Teacher> teachers = new ArrayList<Teacher>();
	
	teachers = teacherDao.allTeachers();
	
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>Mbk Edu | All Teachers</title>
</head>
<body>
    <header>
        <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
        <h1>MBK Education</h1>
     </header>
     <nav>
         <a href="/index.html">Home</a>&ensp;|&ensp;
         <a href="#">About us</a>&ensp;|&ensp;
         <a href="#">Contact us</a>&ensp;|&ensp;
         <a href="#">Profile</a>&ensp;|&ensp;
         <a href="/admin.html">Admin<a>&ensp;|&ensp;
         <a href="#">Logout</a>&ensp;
         <hr>
     </nav>
     <h1 style="text-align: center">All Teachers</h1>
     <div class="parent">
        <div class="child">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Dob</th>
                    <th>Gender</th>
                    <th>Father</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Salary</th>
                    <th>Attendance</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                <% for(Teacher teacher : teachers){ %>
                <tr>
                    <td><%=teacher.getTeacher_id() %></td>
                    <td><%=teacher.getName()%></td>
                    <td><%=teacher.getDob() %></</td>
                    <td><%=teacher.getSex() %></</td>
                    <td><%=teacher.getFather() %></</td>
                    <td><%=teacher.getPhone() %></</td>
                    <td><%=teacher.getEmail() %></</td>
                    <td><%=teacher.getSalary() %></</td>
                    <td><%=teacher.getAttendance() %></</td>
                    <td><a href="<%=request.getContextPath()%>/teacher-edit.jsp?email=<%=teacher.getEmail()%>">edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/deleteteacher?email=<%=teacher.getEmail()%>">delete</a></td>
                </tr>
                <%}%>
            </table>
        </div>
     </div>
     <footer >
        <a href="#">Privacy Policy</a>&ensp;
        <a href="#">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
     </footer>
</body>
</html>