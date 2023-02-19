<%@page import="com.studentmanagement.dao.StudentDaoI"%>
<%@page import="com.studentmanagement.util.DaoUtil"%>
<%@page import="com.studentmanagement.dao.TeacherDaoI"%>
<%@page import="com.studentmanagement.bean.Student" %>
<%@page import="java.util.List" %>
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
	StudentDaoI studentDao = DaoUtil.getStudentDaoObject();
	List<Student> students = studentDao.getAllStudents();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>Mbk Edu | All Students</title>
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
         <a href="admin.jsp">Admin<a>&ensp;|&ensp;
         <a href="<%=request.getContextPath()%>/logout">Logout</a>&ensp;
         <hr>
     </nav>
     <%
     if(students.isEmpty()){
     %>
     <h1 style="text-align: center; color: red">No Record Found</h1>
     <%
     }else{
     %>
     <h1 style="text-align: center">All Students</h1>
     <div class="">
        <div class="">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Class</th>
                    <th>Dob</th>
                    <th>Gender</th>
                    <th>Father</th>
                    <th>Mother</th>
                    <th>Phone</th>
                    <th>Phone2</th>                       
                    <th>Email</th>
                    <th>Password</th>
                    <th>grade</th>
                    <th>Attendance</th>
                    <th>feePaid</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
               <%
               for(Student student : students){
               %>
                <tr>
                    <td><%=student.getStudent_Id() %></td>
                    <td><%=student.getName() %></td>
                    <td><%=student.getClass_Id() %></td>
                    <td><%=student.getDob() %></td>
                    <td><%=student.getSex() %></td>
                    <td><%=student.getFather() %></td>
                    <td><%=student.getMother() %></td>
                    <td><%=student.getPhone() %></td>
                    <td><%=student.getParPhone() %></td>
                    <td><%=student.getEmail() %></td>
                    <td><%=student.getPass() %></td>
                    <td><%=student.getGrade() %></td>
                    <td><%=student.getAttandance() %></td>
                    <td><%=student.getFreePaid() %></td>
                    <td><a href="<%=request.getContextPath()%>/student-edit.jsp?email=<%=student.getEmail()%>">edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/deletestudent?email=<%=student.getEmail()%>">delete</a></td>
                </tr>
                <%
                }
               %>
            </table>
            <button style="align-self: flex-end;"><a href="add-student.jsp">Add New Student</a></button>
        </div>
     </div>
     <%
     }
     %>
     
</body>
	<footer >
        <a href="#">Privacy Policy</a>&ensp;
        <a href="#">Contact us</a>&ensp;
        <a>&copy; 2023 | Mbk education</a>
     </footer>
</html>