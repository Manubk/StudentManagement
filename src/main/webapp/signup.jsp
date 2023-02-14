<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet/stylesheet.css">
    <title>MBK Edu | Signup</title>
</head>
<body>
    <div class="parent">
        <div class="child">
            <h1 style="text-align: center">Sign Up</h1>
            <form action="signup" method="post">
                <table>
                    <tr>
                        <th>Role :</th>
                        <td>
                          <select name="role">
                            <option selected>Select</option>
                            <option value="teacher" >Teacher</option>
                            <option value="student">Student</option>
                          </select>
                        </td>
                      </tr>
                    <tr>
                        <th>Name :</th>
                        <td><input type="text" name="name"  required="required"></td>
                    </tr>
                    <tr>
                        <th>Father :</th>
                        <td><input type="text" name="father" ></td>
                    </tr>
                    <tr>
                        <th>Dob :</th>
                        <td><input type="date" name="dob" ></td>
                    </tr>
                    <tr>
                        <th>Gender :</th>
                        <td>
                            <input type="radio" name="sex" value="f">
                            <label>M</label>
                            <input type="radio" name="sex" value="f">
                            <label>F</label>
                        </td>
                        
                    </tr>
                    <tr>
                        <th>Phone :</th>
                        <td><input type="number"  name="phone" required="required" ></td>
                    </tr>
                    <tr>
                        <th>Email :</th>
                        <td><input type="email" name="email" required="required"></td>
                    </tr>
                    <tr>
                        <th>Pass :</th>
                        <td><input type="password" name="password" required="required"></td>
                    </tr>
                </table>
                <input type="submit"> 
            </form>
            <br>
            <a href="login.jsp">Existing User</a>
        </div>
    </div>
    
</body>
</html>