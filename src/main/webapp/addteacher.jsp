<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- varifying if the user is login or not -->
<%
String role = (String)session.getAttribute("role");
String userName = (String)session.getAttribute("userName");
if(!(role != null && role.equalsIgnoreCase("admin")))
	response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="stylesheet/stylesheet.css">
<title>Mbk Edu | Add Teacher</title>
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
     <form action="addteacher" method="post">
     	<table>
        <tr>
            <td><b>Id :</b> </td>
            <td><input type="number" name="id" readonly="readonly"></td>
            <td><b>Phone :</b></td>
            <td><input type="number" name="phone" ></td>
        </tr>
        <tr>
            <td><b>Name :</b> </td>
            <td><input type="text" name="name" required="required" ></td>
            <td><b>Email :</b></td>
            <td><input type="email" name="email" required="required" ></td>
        </tr>
        <tr>
            <td><b>Father :</b> </td>
            <td><input type="text" name="father"  ></td>
            <td><b>Password :</b></td>
            <td><input type="text" name="password" required="required" ></td>
        </tr>
        <tr>
            <td><b>Dob :</b> </td>
            <td><input type="date" name="dob"
             re  ></td>
            <td><b>Salary :</b></td>
            <td><input type="number" name="salary" value="0" > </td>
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
            <td><b>Attendance :</b></td>
            <td><input type="number" name="attendance" value="0"></td>
        </tr>
        
     </table>
     <input type="submit" value="Save">
     </form>
     
     
     </div> 
     </div>
     

</body>
</html>