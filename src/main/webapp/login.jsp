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

    <div class="parent">
      <div class="child1">
        <h1>Sign in</h1>
        <form action="login" method="post">
          <table>
            <tr>
              <th>Role :</th>
              <td>
                <select name="role">
                  <option selected>Select</option>
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
