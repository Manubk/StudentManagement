<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="stylesheet/stylesheet.css" />
    <title>MBK Edu | Login</title>
  </head>
  <body>
  <% if(request.getAttribute("status")!=null){
	  	String loginError = (String)request.getAttribute("status");
	  	System.out.print(loginError);
	  	if(loginError.equalsIgnoreCase("false")){
		  %>
		  <p style="text-align: center; color: red;">Wrong Credentials try again</p>
	 	  <%
	  }
  }
	 %>
	 <header>
       <!-- <img src="resources/lgog.png" width="10%" height="5%"> <h1>MBK Education</h1> -->
       <h1>MBK Education</h1>
    
     <nav>
        <a href="Home.jsp">Home</a>&ensp;|&ensp;
        <a href="aboutus.jsp">About us</a>&ensp;|&ensp;
        <a href="contactus.jsp">Contact us</a>&ensp;
     </nav> 
     <hr>
	  </header>
  
  
    <div class="parent">
      <div class="child">
        <h1>Sign in</h1>
        <form action="login" method="post">
          <table>
            <tr>
              <th>Role :</th>
              <td>
                <select name="role">
                  <option selected>Select</option>
                  <option value="admin">Admin</option>
                  <option value="teacher">Teacher</option>
                  <option value="student">Student</option>
                </select>
              </td>
            </tr>
            <tr>
              <th>Email :</th>
              <td>
                <input type="email" name="email" placeholder="your email" />
              </td>
            </tr>
            <tr>
              <th>Pass :</th>
              <td>
                <input type="password" name="password" placeholder="password" />
              </td>
            </tr>
          </table>
          <input type="submit" value="SIGN IN">
        </form>
        <br>
        <a href="signup.jsp">New User</a>
      </div>
    </div>
  </body>
</html>
